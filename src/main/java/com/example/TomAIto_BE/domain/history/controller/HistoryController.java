package com.example.TomAIto_BE.domain.history.controller;


import com.example.TomAIto_BE.domain.history.dto.HistoryRequestDto;
import com.example.TomAIto_BE.domain.history.dto.HistoryResponseDto;
import com.example.TomAIto_BE.domain.history.service.HistoryService;
import com.example.TomAIto_BE.oauth.CustomOAuth2User;
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
    public void saveHistory(@AuthenticationPrincipal CustomOAuth2User user, @RequestBody HistoryRequestDto.saveHistory saveHistory ) {
        historyService.saveHistory(user.getUsername(), saveHistory);
    }


    @GetMapping("")
    public List<HistoryResponseDto.HistoryDto> getHistory(@AuthenticationPrincipal CustomOAuth2User user) {
        return historyService.getHistoryList(user.getUsername());
    }
}
