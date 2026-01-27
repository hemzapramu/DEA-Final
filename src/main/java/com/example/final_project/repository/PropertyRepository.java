package com.example.final_project.repository;

import com.example.final_project.model.Property;
import com.example.final_project.model.PropertyStatus;
import com.example.final_project.model.PropertyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
    List<Property> findByType(PropertyType type);

    List<Property> findByStatus(PropertyStatus status);

    List<Property> findByPriceLessThanEqual(java.math.BigDecimal price);

    List<Property> findByAddressContainingIgnoreCase(String address);
}
