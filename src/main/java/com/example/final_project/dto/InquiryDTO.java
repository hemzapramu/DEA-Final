package com.example.final_project.dto;

import com.example.final_project.model.InquiryStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DTO for returning inquiry summary information.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InquiryDTO {
    private Long id;
    private Long userId;
    private String userName;
    private String userEmail;

    // Property details
    private Long propertyId;
    private String propertyTitle;
    private String propertyAddress;
    private String propertyImage;
    private Double propertyPrice;
    private Integer propertyBedrooms;
    private Integer propertyBathrooms;
    private Double propertyAreaSqFt;
    private String propertyType; // SALE or RENT

    // Assigned agent details
    private Long assignedAgentId;
    private String assignedAgentName;
    private String assignedAgentProfileImage;
    private String assignedAgentPhone;
    private String assignedAgentTitle;

    private InquiryStatus status;
    private String lastMessagePreview;
    private LocalDateTime lastMessageAt;
    private LocalDateTime createdAt;
    private boolean hasUnread;
}
