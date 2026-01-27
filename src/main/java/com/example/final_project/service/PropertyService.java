package com.example.final_project.service;

import com.example.final_project.model.Property;
import com.example.final_project.model.PropertyStatus;
import com.example.final_project.model.PropertyType;
import com.example.final_project.model.User;
import com.example.final_project.repository.PropertyRepository;
import com.example.final_project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PropertyService {

    private final PropertyRepository propertyRepository;
    private final UserRepository userRepository;

    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    public List<Property> searchProperties(String query) {
        // Simple search by address for now
        return propertyRepository.findByAddressContainingIgnoreCase(query);
    }

    public List<Property> getPropertiesByType(PropertyType type) {
        return propertyRepository.findByType(type);
    }

    public Property getPropertyById(Long id) {
        return propertyRepository.findById(id).orElseThrow(() -> new RuntimeException("Property not found"));
    }

    public Property createProperty(Property property) {
        // Get current logged in user (Agent)
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        User agent = userRepository.findByEmail(username).orElseThrow();
        property.setAgent(agent);
        property.setCreatedAt(LocalDateTime.now());
        if (property.getStatus() == null)
            property.setStatus(PropertyStatus.AVAILABLE);

        return propertyRepository.save(property);
    }

    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }
}
