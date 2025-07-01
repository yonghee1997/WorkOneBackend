package com.study.workOne.common.code.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.workOne.common.code.dto.CommonCode;
import com.study.workOne.common.code.dto.CommonCodeAttr;
import com.study.workOne.common.code.dto.CommonCodeDetail;
import com.study.workOne.common.code.mapper.CodeMapper;
import com.study.workOne.common.code.service.CodeService;
import com.study.workOne.result.SaveResult;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
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

	@Override
	public SaveResult saveCommonCodes(List<CommonCode> codeList) {
		List<String> failedIds = new ArrayList<>();
		
		for(CommonCode code : codeList) {
			try {
				int result = codeMapper.saveCommonCode(code);
			} catch(Exception e) {
				throw new RuntimeException(code.getCodeId());
			}
		}
		
		return new SaveResult(failedIds); 
		
	}
	
}
