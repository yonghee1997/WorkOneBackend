package com.study.workOne.common.code.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.workOne.common.code.dto.CommonCode;
import com.study.workOne.common.code.dto.CommonCodeAttr;
import com.study.workOne.common.code.dto.CommonCodeDetail;
import com.study.workOne.common.code.service.CodeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/code")
@RequiredArgsConstructor
@Slf4j
public class CodeController {

	private final CodeService codeService;
	
	@GetMapping("/group")
	public ResponseEntity<List<CommonCode>> getCodeGroupsList() {
		List<CommonCode> list = codeService.getCodeGroupsList();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/detail")
	public ResponseEntity<List<CommonCodeDetail>> getCodeDetailList(@RequestParam("codeId") String codeId) {
		List<CommonCodeDetail> list = codeService.getCodeDetailList(codeId);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/attr")
	public ResponseEntity<List<CommonCodeAttr>> getCodeAttrList(@RequestParam("codeId") String codeId) {
		List<CommonCodeAttr> list = codeService.getCodeAttrList(codeId);
		return ResponseEntity.ok(list);
	}
	
}



