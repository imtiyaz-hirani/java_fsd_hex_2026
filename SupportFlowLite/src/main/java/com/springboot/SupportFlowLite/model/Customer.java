package com.springboot.SupportFlowLite.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Table(name = "customers")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //findById

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email; //Customer customer = findByEmail(String email)

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private Instant createdAt;

    @OneToOne
    private User user; // Customer findByUserUsername(String username)

}