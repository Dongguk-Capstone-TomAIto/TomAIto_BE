package com.example.TomAIto_BE.domain.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    private String nickname;

    @CreatedDate
    private LocalDate createdAt;

}
