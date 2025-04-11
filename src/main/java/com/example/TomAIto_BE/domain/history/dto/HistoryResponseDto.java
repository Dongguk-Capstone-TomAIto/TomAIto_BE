package com.example.TomAIto_BE.domain.history.dto;

import com.example.TomAIto_BE.domain.history.entity.History;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

public class HistoryResponseDto {
    @Builder
    public static class HistoryDto {
        private LocalDate createdAt;
        private String result;
    }
    public static HistoryResponseDto.HistoryDto toHistoryDto(History history) {
        return HistoryDto.builder()
                .createdAt(history.getCreatedAt())
                .result(history.getResult())
                .build();
    }
}
