package com.springboot.SupportFlowLite.model;

import jakarta.persistence.*;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Table(name = "customer_plan")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Plan plan;

    @Column(name = "subscribed_at", updatable = false)
    @CreationTimestamp
    private Instant subscribedAt;

    @Column(nullable = false)
    private boolean active = true;


}
