package com.study.workOne.common.code.dto;

import lombok.Data;

@Data
public class CommonCodeDetail {
	private String codeDetailId;
    private String codeId;
    private String detailName;
    private String description;
    private Integer orderNo;
    private String useYn;
    private String createDt;
    private String createId;
    private String updateDt;
    private String updateId;
}
