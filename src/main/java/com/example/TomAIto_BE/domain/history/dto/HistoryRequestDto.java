package com.example.TomAIto_BE.domain.history.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class HistoryRequestDto {
    @Getter
    public static class saveHistory{

        @NotBlank
        String type;

        @NotBlank
        String result;
    }
}
