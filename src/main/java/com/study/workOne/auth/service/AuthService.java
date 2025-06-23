package com.study.workOne.auth.service;

import com.study.workOne.auth.dto.LoginDto;
import com.study.workOne.auth.dto.UserDto;

public interface AuthService {
	UserDto login(LoginDto dto) throws Exception;
}
