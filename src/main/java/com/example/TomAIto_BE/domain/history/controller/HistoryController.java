package com.example.TomAIto_BE.domain.history.controller;


import com.example.TomAIto_BE.common.ApiResponse;
import com.example.TomAIto_BE.domain.history.dto.HistoryRequestDto;
import com.example.TomAIto_BE.domain.history.dto.HistoryResponseDto;
import com.example.TomAIto_BE.domain.history.service.HistoryService;
import com.example.TomAIto_BE.oauth.CustomOAuth2User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/history")
@RequiredArgsConstructor
public class HistoryController {
    private final HistoryService historyService;

    @PostMapping("")
    public ApiResponse<HistoryResponseDto.saveDto> saveHistory(@AuthenticationPrincipal CustomOAuth2User user, @Valid @RequestBody HistoryRequestDto.saveHistory saveHistoryDto ) {
        return ApiResponse.onSuccess(historyService.saveHistory(user.getUsername(), saveHistoryDto));
    }


    @GetMapping("")
    public ApiResponse<List<HistoryResponseDto.HistoryDto>> getHistory(@AuthenticationPrincipal CustomOAuth2User user) {
        return ApiResponse.onSuccess(historyService.getHistoryList(user.getUsername()));
    }
}
