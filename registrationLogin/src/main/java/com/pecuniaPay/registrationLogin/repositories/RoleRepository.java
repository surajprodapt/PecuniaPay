package com.pecuniaPay.registrationLogin.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pecuniaPay.registrationLogin.entities.ERole;
import com.pecuniaPay.registrationLogin.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
