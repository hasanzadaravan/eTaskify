package com.eTaskifyApi.eTaskify.repository;

import com.eTaskifyApi.eTaskify.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

  Optional<Organization> findById(Long id);
}

