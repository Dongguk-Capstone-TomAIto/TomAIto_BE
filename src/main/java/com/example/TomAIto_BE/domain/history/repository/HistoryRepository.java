package com.example.TomAIto_BE.domain.history.repository;

import com.example.TomAIto_BE.domain.history.entity.History;
import com.example.TomAIto_BE.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Long> {
    List<History> findByUser(User user);
}
