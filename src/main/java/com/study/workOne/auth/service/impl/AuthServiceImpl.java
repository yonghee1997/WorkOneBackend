package com.study.workOne.auth.service.impl;

import org.springframework.stereotype.Service;

import com.study.workOne.auth.dto.LoginDto;
import com.study.workOne.auth.dto.UserDto;
import com.study.workOne.auth.mapper.UserMapper;
import com.study.workOne.auth.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

	private final UserMapper userMapper;

	@Override
	public UserDto login(LoginDto dto) throws Exception {
		UserDto user = userMapper.selectUserInfo(dto);
		
		if(user == null || user.getUserId() == null) {
			throw new Exception("해당 아이디가 존재하지 않습니다.");
		} else if(!user.getUserPw().equals(dto.getUserPw())) {
			throw new Exception("비밀번호를 확인해주세요.");
		}
		
		user.setUserPw(null);
				
		return user;
	}
}
