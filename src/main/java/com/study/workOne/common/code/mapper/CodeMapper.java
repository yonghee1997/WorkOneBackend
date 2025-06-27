package com.study.workOne.common.code.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.workOne.common.code.dto.CommonCode;

@Mapper
public interface CodeMapper {

	List<CommonCode> selectCodeGroups();
}
