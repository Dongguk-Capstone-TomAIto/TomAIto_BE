package com.example.TomAIto_BE.domain.user.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.auditing.config.AuditingConfiguration;

import java.time.LocalDate;

@Entity
@EntityListeners(AuditingConfiguration.class)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String username;

    private String role;

    private String email;

    @CreatedDate
    private LocalDate createdAt;

}
