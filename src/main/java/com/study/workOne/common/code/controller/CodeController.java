package com.study.workOne.common.code.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.workOne.common.code.dto.CommonCode;
import com.study.workOne.common.code.service.CodeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/code")
@RequiredArgsConstructor
@Slf4j
public class CodeController {

	private CodeService codeService;
	
	@GetMapping("/group")
	public ResponseEntity<List<CommonCode>> getCodeGroups() {
		List<CommonCode> list = codeService.getCodeGroups();
		return ResponseEntity.ok(list);
	}
}
