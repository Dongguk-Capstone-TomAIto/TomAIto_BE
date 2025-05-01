package com.example.TomAIto_BE.domain.history.entity;


import com.example.TomAIto_BE.domain.user.entity.User;
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
public class History {
    @Id
    @GeneratedValue
    private Long id;

    private String result;

    private String type;

    @CreatedDate
    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
