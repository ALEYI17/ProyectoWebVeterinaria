package com.vetcare.proyecto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vetcare.proyecto.entities.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity,Long>{

    Optional<UserEntity> findByUsername(String username);

    Boolean existsByUsername(String username);
}
