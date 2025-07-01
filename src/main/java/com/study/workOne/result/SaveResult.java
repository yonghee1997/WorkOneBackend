package com.study.workOne.result;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SaveResult {
	private List<String> failedIds;
}
