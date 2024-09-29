package org.example.notecollecterspring.dto.dao;

import jakarta.servlet.http.PushBuilder;
import org.example.notecollecterspring.dto.dto.impl.UserDTO;
import org.example.notecollecterspring.dto.entity.impl.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserDAO extends JpaRepository<UserEntity, String> {}
