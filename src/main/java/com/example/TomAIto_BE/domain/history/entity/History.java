package com.example.TomAIto_BE.domain.history.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.auditing.config.AuditingConfiguration;

import java.time.LocalDate;

@Entity
@EntityListeners(AuditingConfiguration.class)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class History {
    @Id
    @GeneratedValue
    private Long id;

    private Long result;

    private String image;

    private boolean pest;

    @CreatedDate
    private LocalDate createdAt;
}
