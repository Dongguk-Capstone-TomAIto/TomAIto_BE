package com.example.TomAIto_BE.domain.history.service;


import com.example.TomAIto_BE.domain.history.dto.HistoryRequestDto;
import com.example.TomAIto_BE.domain.history.dto.HistoryResponseDto;
import com.example.TomAIto_BE.domain.history.entity.History;
import com.example.TomAIto_BE.domain.history.repository.HistoryRepository;
import com.example.TomAIto_BE.domain.user.entity.User;
import com.example.TomAIto_BE.domain.user.repository.UserRepository;
import com.example.TomAIto_BE.domain.user.service.UserService;
import jakarta.transaction.Transactional;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class HistoryService {
    private final HistoryRepository historyRepository;
    private final UserRepository userRepository;

    public void saveHistory(String username, HistoryRequestDto.saveHistory saveHistory) {
        User user = userRepository.findByUsername(username);
        History history = History.builder()
                .result(saveHistory.getResult())
                .createdAt(LocalDate.now())
                .user(user)
                .build();
        historyRepository.save(history);
    }

    public List<HistoryResponseDto.HistoryDto> getHistoryList(String username) {
        User user = userRepository.findByUsername(username);
        List<History> historyList = historyRepository.findByUser(user);
        return historyList.stream().map(HistoryResponseDto::toHistoryDto).collect(Collectors.toList());
    }
}
