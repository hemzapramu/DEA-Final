package com.example.final_project.service;

import com.example.final_project.model.Inquiry;
import com.example.final_project.model.User;
import com.example.final_project.repository.InquiryRepository;
import com.example.final_project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InquiryService {

    private final InquiryRepository inquiryRepository;
    private final UserRepository userRepository;

    public Inquiry createInquiry(Inquiry inquiry) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(username).orElseThrow();
        inquiry.setUser(user);
        return inquiryRepository.save(inquiry);
    }

    public List<Inquiry> getMyInquiries() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(username).orElseThrow();
        return inquiryRepository.findByUserId(user.getId());
    }
}
