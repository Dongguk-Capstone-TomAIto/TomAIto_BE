package com.example.TomAIto_BE.domain.history.repository;

import com.example.TomAIto_BE.domain.history.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {
}
