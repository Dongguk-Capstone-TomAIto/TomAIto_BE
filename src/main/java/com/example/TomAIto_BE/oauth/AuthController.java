package com.example.TomAIto_BE.oauth;

import com.example.TomAIto_BE.common.ApiResponse;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseCookie;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AuthController {
    @PostMapping("/logout")
    public ApiResponse<String> logout(HttpServletResponse httpServletResponse) {
        ResponseCookie cookie = ResponseCookie.from("Authorization", "")
                .path("/")
                .httpOnly(true)
                .maxAge(0)
                .build();

        httpServletResponse.addHeader("Set-Cookie", cookie.toString());
        return ApiResponse.onSuccess("로그아웃 성공");
    }
}
