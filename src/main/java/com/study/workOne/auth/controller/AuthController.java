package com.study.workOne.auth.controller;

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

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final AuthService authService;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginDto dto, HttpSession session) throws Exception {
		UserDto user = authService.login(dto);
		session.setAttribute("user", user);
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
