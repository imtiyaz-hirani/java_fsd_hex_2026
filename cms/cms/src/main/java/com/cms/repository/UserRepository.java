package com.cms.repository;

import com.cms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

    @Query("""
            select u
            from User u
            where u.username = ?1
            """)
    User getByUsername(String username);
    // select * from User where username = ?1
}
