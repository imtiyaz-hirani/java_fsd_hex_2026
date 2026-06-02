package com.springboot.SupportFlowLite.repository;

import com.springboot.SupportFlowLite.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}
