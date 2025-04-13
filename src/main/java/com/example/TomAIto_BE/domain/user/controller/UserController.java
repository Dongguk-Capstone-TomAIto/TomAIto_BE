package com.example.TomAIto_BE.domain.user.controller;


import com.example.TomAIto_BE.common.ApiResponse;
import com.example.TomAIto_BE.oauth.CustomOAuth2User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    @GetMapping("/me")
    public ApiResponse<String> getCurrentUser(
            @AuthenticationPrincipal CustomOAuth2User customOAuth2User) {

        if (customOAuth2User == null) {
            return ApiResponse.onFailure("인증 정보 없음");

        }

        return ApiResponse.onSuccess(customOAuth2User.getName());
    }



}
