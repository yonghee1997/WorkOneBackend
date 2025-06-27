package com.study.workOne.auth.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.workOne.auth.dto.LoginDto;
import com.study.workOne.auth.dto.UserDto;
import com.study.workOne.auth.service.AuthService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final AuthService authService;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginDto dto, HttpSession session) throws Exception {
		UserDto user = authService.login(dto);
		session.setAttribute("user", user);
		
		// ✅ Spring Security Context에 인증 정보 수동 저장
	    UsernamePasswordAuthenticationToken auth = 
	        new UsernamePasswordAuthenticationToken(
	            user, // Principal
	            null, // Credentials (이미 검증됨)
	            List.of() // Authorities (권한, 필요시 UserDetails에서 꺼냄)
	        );

	    SecurityContextHolder.getContext().setAuthentication(auth);
				
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/check")
	public ResponseEntity<?> checkLogin(HttpSession session) {
	    Object user = session.getAttribute("user");
	    if (user != null) {
	        return ResponseEntity.ok().build(); // 로그인 O
	    } else {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // 로그인 X
	    }
	}
	
	@PostMapping("/logout")
	public ResponseEntity<?> logout(HttpSession session) {
		session.invalidate(); // 세션 무효화
		return ResponseEntity.ok().build();
	}
}
