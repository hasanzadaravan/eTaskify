package com.eTaskifyApi.eTaskify.services;

import com.eTaskifyApi.eTaskify.model.Organization;
import com.eTaskifyApi.eTaskify.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;


    public Organization findById(Long id) {
        Optional<Organization> byId = organizationRepository.findById(id);
        return byId.get();
    }
}