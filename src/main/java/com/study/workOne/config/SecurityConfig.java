package com.study.workOne.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // 🔐 보안 필터 체인 설정
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // ✅ CORS 설정 활성화 (CorsConfigurationSource 사용)
            .cors(Customizer.withDefaults())

            // ✅ CSRF 보호 비활성화 (개발 시에는 주로 비활성화)
            .csrf(csrf -> csrf.disable())

            // ✅ 요청 인증 처리
            .authorizeHttpRequests(auth -> auth
                // 로그인, 회원가입 경로는 인증 없이 접근 허용
                .requestMatchers("/api/auth/**").permitAll()

                // 그 외 모든 요청은 인증 필요
                .anyRequest().authenticated()
            )

            // ✅ 세션 설정 (세션 기반 인증 유지)
            .sessionManagement(session -> session
                // 인증 시 세션을 생성하여 유지 (기본값이지만 명시적으로 지정)
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)

                // 동시에 하나의 세션만 허용 (선택)
                .maximumSessions(1)
            )

            // ✅ 인증된 사용자 정보(SecurityContext)를 자동 저장
            .securityContext(context -> context
                .requireExplicitSave(false) // 인증 성공 시 자동 저장
            );

        return http.build();
    }

    // 🌐 CORS 설정 - 프론트와 백엔드가 다른 포트/도메인일 때 허용
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();

        // 허용할 Origin (프론트엔드 URL)
        config.setAllowedOrigins(List.of("https://localhost:5173"));

        // 허용할 HTTP 메서드
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // 허용할 헤더
        config.setAllowedHeaders(List.of("Authorization", "Content-Type", "X-Requested-With"));

        // 쿠키(JSESSIONID 등) 포함 허용
        config.setAllowCredentials(true);

        // CORS 경로 등록 (API 경로에만 적용)
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return source;
    }
}
