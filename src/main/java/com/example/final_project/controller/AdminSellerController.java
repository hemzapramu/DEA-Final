package com.example.final_project.controller;

import com.example.final_project.model.SellerApplication;
import com.example.final_project.service.SellerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/sellers")
@RequiredArgsConstructor
@Slf4j
// Ensure you enable @EnableMethodSecurity in SecurityConfig or rely on
// SecurityFilterChain
public class AdminSellerController {

    private final SellerService sellerService;

    @GetMapping("/pending")
    public ResponseEntity<?> getPendingApplications() {
        log.info("Admin requesting pending seller applications");
        List<SellerApplication> apps = sellerService.getAllPendingApplications();
        log.info("Found {} pending applications", apps.size());
        return ResponseEntity.ok(apps);
    }

    @PostMapping("/{id}/approve")
    public ResponseEntity<?> approveApplication(@PathVariable Long id) {
        sellerService.approveApplication(id);
        return ResponseEntity.ok("Application approved");
    }

    @PostMapping("/{id}/reject")
    public ResponseEntity<?> rejectApplication(@PathVariable Long id, @RequestParam(required = false) String param) {
        // Note: param is just a placeholder, we might want a body for reason
        return ResponseEntity.badRequest().body("Use JSON body for reason");
    }

    @PostMapping("/{id}/reject-with-reason")
    public ResponseEntity<?> rejectApplicationWithReason(@PathVariable Long id, @RequestBody RejectReasonDTO reason) {
        sellerService.rejectApplication(id, reason.getReason());
        return ResponseEntity.ok("Application rejected");
    }

    @PostMapping("/{id}/resend-activation")
    public ResponseEntity<?> resendActivation(@PathVariable Long id) {
        sellerService.resendActivation(id);
        return ResponseEntity.ok("Activation email resent");
    }

    @lombok.Data
    public static class RejectReasonDTO {
        private String reason;
    }

    @GetMapping("/pre-generated")
    public ResponseEntity<?> getPreGeneratedSellers() {
        return ResponseEntity.ok(sellerService.ensurePreGeneratedSellers());
    }

    @PostMapping("/manual")
    public ResponseEntity<?> createManualSeller(@RequestBody ManualSellerDTO dto) {
        sellerService.createManualSeller(dto.getUsername(), dto.getPassword());
        return ResponseEntity.ok("Seller created successfully");
    }

    @lombok.Data
    public static class ManualSellerDTO {
        private String username;
        private String password;
    }
}
