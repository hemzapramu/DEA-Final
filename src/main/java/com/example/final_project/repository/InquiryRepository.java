package com.example.final_project.repository;

import com.example.final_project.model.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InquiryRepository extends JpaRepository<Inquiry, Long> {
    List<Inquiry> findByPropertyId(Long propertyId);

    List<Inquiry> findByUserId(Long userId);
}
