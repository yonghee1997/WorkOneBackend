package com.study.workOne.auth.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.study.workOne.auth.dto.LoginDto;
import com.study.workOne.auth.dto.UserDto;

@Mapper
public interface UserMapper {
	UserDto selectUserInfo(LoginDto dto);
}
