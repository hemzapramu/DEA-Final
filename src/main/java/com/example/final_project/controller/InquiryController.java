package com.example.final_project.controller;

import com.example.final_project.model.Inquiry;
import com.example.final_project.service.InquiryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inquiries")
@RequiredArgsConstructor
public class InquiryController {

    private final InquiryService service;

    @PostMapping
    public ResponseEntity<Inquiry> createInquiry(@RequestBody Inquiry inquiry) {
        return ResponseEntity.ok(service.createInquiry(inquiry));
    }

    @GetMapping("/my")
    public ResponseEntity<List<Inquiry>> getMyInquiries() {
        return ResponseEntity.ok(service.getMyInquiries());
    }
}
