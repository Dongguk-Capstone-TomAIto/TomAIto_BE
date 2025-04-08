package com.example.TomAIto_BE.oauth;

import com.example.TomAIto_BE.domain.user.dto.UserDto;
import com.example.TomAIto_BE.domain.user.entity.User;
import com.example.TomAIto_BE.domain.user.repository.UserRepository;
import com.example.TomAIto_BE.oauth.dto.GoogleResponseDto;
import com.example.TomAIto_BE.oauth.dto.KakaoResponseDto;
import com.example.TomAIto_BE.oauth.dto.OAuth2Response;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;


// 결국 엑세스토큰으로 사용자 정보받아서 db에 존재하는 사용자인지 확인하고 아니면 회원가입하는  '소셜로그인'과정.
@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    public CustomOAuth2UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // userRequest에 엑세스 토큰 들어있음.
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        // 가져온 유저정보.
        OAuth2User oAuth2User = super.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        OAuth2Response oAuth2Response = null;
        if (registrationId.equals("kakao")) {

            oAuth2Response = new KakaoResponseDto(oAuth2User.getAttributes());
        }
        else if (registrationId.equals("google")) {

            oAuth2Response = new GoogleResponseDto(oAuth2User.getAttributes());
        }
        else {

            return null;
        }

        //리소스 서버에서 발급 받은 정보로 사용자를 특정할 아이디값을 만듬
        // ex) naver a123, google b123
        String username = oAuth2Response.getProvider()+" "+oAuth2Response.getProviderId();
        User existData = userRepository.findByUsername(username);

        if(existData == null) {
            User user = User.builder()
                    .username(username)
                    .email(oAuth2Response.getEmail())
                    .name(oAuth2Response.getName())
                    .role("ROLE_USER")
                    .build();
            userRepository.save(user);

            UserDto userDto = UserDto.builder()
                    .username(username)
                    .name(oAuth2Response.getName())
                    .role("ROLE_USER")
                    .build();

            return new CustomOAuth2User(userDto);
        }

        else{
            UserDto userDto = UserDto.builder()
                    .username(existData.getUsername())
                    .name(existData.getName())
                    .role(existData.getRole())
                    .build();


            return new CustomOAuth2User(userDto);
        }
    }
}
