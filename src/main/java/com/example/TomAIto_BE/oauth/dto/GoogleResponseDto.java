package com.example.TomAIto_BE.oauth.dto;

import java.util.Map;

// 엑세스 토큰으로 받아온 구글 사용자 정보.
public class GoogleResponseDto implements OAuth2Response {


    private final Map<String,Object> attribute;
    public GoogleResponseDto(Map<String,Object> attribute) {
        this.attribute = attribute;
    }
    @Override
    public String getProvider() {
        return "Google";
    }

    @Override
    public String getProviderId() {
        return attribute.get("sub").toString();
    }

    @Override
    public String getEmail() {
        return attribute.get("email").toString();
    }

    @Override
    public String getName() {
        return attribute.get("name").toString();
    }
}
