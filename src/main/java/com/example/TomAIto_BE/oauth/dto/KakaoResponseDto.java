package com.example.TomAIto_BE.oauth.dto;


import java.util.Map;

public class KakaoResponseDto implements OAuth2Response{
    private final Map<String,Object> attribute;
    public KakaoResponseDto(Map<String,Object> attribute) {
        this.attribute = attribute;
    }

    @Override
    public String getProvider() {
        return "Kakao";
    }

    @Override
    public String getProviderId() {
        return attribute.get("id").toString();
    }

    @Override
    public String getEmail() {
        Map<String, Object> properties = (Map<String, Object>) attribute.get("properties");
        return properties.get("nickname").toString();
    }

    @Override
    public String getName() {
        return "";
    }
}
