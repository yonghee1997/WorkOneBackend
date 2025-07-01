package com.study.workOne.common.code.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.workOne.common.code.dto.CommonCode;
import com.study.workOne.common.code.dto.CommonCodeAttr;
import com.study.workOne.common.code.dto.CommonCodeDetail;

@Mapper
public interface CodeMapper {

	List<CommonCode> selectCodeGroupsList();
	
	List<CommonCodeDetail> selectCodeDetailList(String codeId);
	
	List<CommonCodeAttr> selectCodeAttrList(String codeId);
	
	int saveCommonCode(CommonCode code);
}
