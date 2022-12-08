package pairmatching.util;

import java.util.Arrays;

import pairmatching.domain.MainFunctionCommand;

public class Validator {
	private static final String MAIN_FUNCTION_PATTERN = "ㄱ-ㅎ가-힣0-9";
	private static final String COURSE_AND_MISSION_PATTERN = "ㄱ-ㅎ가-힣";

	public static void validateMainFunctionSelect(String input) {
		if (!MAIN_FUNCTION_PATTERN.matches(input)) {
			throw new IllegalArgumentException("올바른 커맨드를 입력해 주세요.");
		}
	}

	public static void validateCourseAndMission(String input) {
		String[] details = input.split(",");
		if (Arrays.stream(details).noneMatch(COURSE_AND_MISSION_PATTERN::matches)) {
			throw new IllegalArgumentException("양식에 맞게 올바른 값을 입력해주세요.");
		}
	}
}
