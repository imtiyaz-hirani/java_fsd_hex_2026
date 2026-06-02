package com.springboot.SupportFlowLite.model;

import com.springboot.SupportFlowLite.enums.Department;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "executives")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Executive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Department department; // e.g., Technical Support, Billing Team

    @OneToOne
    private User user;
}