package com.study.workOne.common.code.service;

import java.util.List;

import com.study.workOne.common.code.dto.CommonCode;
import com.study.workOne.common.code.dto.CommonCodeAttr;
import com.study.workOne.common.code.dto.CommonCodeDetail;

public interface CodeService {

	List<CommonCode> getCodeGroupsList();
	
	List<CommonCodeDetail> getCodeDetailList(String codeId);
	
	List<CommonCodeAttr> getCodeAttrList(String codeId);
}
