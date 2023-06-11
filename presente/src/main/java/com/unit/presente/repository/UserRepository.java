package com.unit.presente.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.unit.presente.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository <User, UUID> {
    public User findByCpf(String cpf);
}
