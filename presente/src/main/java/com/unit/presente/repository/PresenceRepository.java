package com.unit.presente.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unit.presente.model.entity.Presence;

@Repository
public interface PresenceRepository extends JpaRepository<Presence, UUID> {
    
}
