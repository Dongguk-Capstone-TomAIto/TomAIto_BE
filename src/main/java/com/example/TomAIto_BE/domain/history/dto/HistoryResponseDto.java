package com.example.TomAIto_BE.domain.history.dto;

import com.example.TomAIto_BE.domain.history.entity.History;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

public class HistoryResponseDto {
    @Builder
    @Getter
    public static class saveDto{
        private LocalDate createdAt;
        private String result;
        private String type;
    }
    @Builder
    @Getter
    public static class HistoryDto {
        private LocalDate createdAt;
        private String result;
        private String type;
    }
    public static HistoryResponseDto.HistoryDto toHistoryDto(History history) {
        return HistoryDto.builder()
                .createdAt(history.getCreatedAt())
                .result(history.getResult())
                .type(history.getType())
                .build();
    }
}
