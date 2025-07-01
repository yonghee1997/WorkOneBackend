package com.study.workOne.common.code.dto;

import lombok.Data;

@Data
public class CommonCode {
	private String codeId;
	private String id;	// 그리드 추가를 위해 추가한 값
    private String codeNm;
    private String description;
    private String useYn;
    private String createDt;
    private String createId;
    private String updateDt;
    private String updateId;
}
