package com.springboot.SupportFlowLite.model;

import com.springboot.SupportFlowLite.enums.TicketStatus;
import com.springboot.SupportFlowLite.enums.TicketType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "tickets")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TicketType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TicketStatus status;

    @Column(nullable = false)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String details;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private Instant createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Instant updatedAt;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Executive executive;
}
