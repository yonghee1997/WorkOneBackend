package com.study.workOne.common.code.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.study.workOne.common.code.dto.CommonCode;
import com.study.workOne.common.code.dto.CommonCodeAttr;
import com.study.workOne.common.code.dto.CommonCodeDetail;
import com.study.workOne.common.code.mapper.CodeMapper;
import com.study.workOne.common.code.service.CodeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CodeServiceImpl implements CodeService {
	
	private final CodeMapper codeMapper;

	@Override
	public List<CommonCode> getCodeGroupsList() {
		
		return codeMapper.selectCodeGroupsList();
	}

	@Override
	public List<CommonCodeDetail> getCodeDetailList(String codeId) {
		
		return codeMapper.selectCodeDetailList(codeId);
	}

	@Override
	public List<CommonCodeAttr> getCodeAttrList(String codeId) {
		
		return codeMapper.selectCodeAttrList(codeId);
	}
	
	

}
