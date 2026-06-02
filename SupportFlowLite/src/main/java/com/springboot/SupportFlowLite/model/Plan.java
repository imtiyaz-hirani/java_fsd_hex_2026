package com.springboot.SupportFlowLite.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "plans")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name; // e.g., "Fiber Premium", "Blazing Gaming Pack"

    @Column(nullable = false)
    private Integer speedMbps; // e.g., 100, 300, 1000

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price; // Monthly rental price

    @Column(name = "data_limit_gb")
    private Integer dataLimitGb; // Nullable if truly unlimited
}