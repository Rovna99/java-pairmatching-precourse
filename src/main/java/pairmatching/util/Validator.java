package pairmatching.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import pairmatching.domain.Course;
import pairmatching.domain.Mission;

public class Validator {
	private static final String MAIN_FUNCTION_PATTERN = "^[\\dA-Z]*$";

	public static void validateMainFunctionSelect(String input) {
		if (!Pattern.matches(MAIN_FUNCTION_PATTERN,input)) {
			throw new IllegalArgumentException("올바른 커맨드를 입력해 주세요.");
		}
	}

	public static void validateCourseAndMission(String input) {
		List<String> details = Arrays.stream(input.replaceAll(" ","").split(","))
			.collect(Collectors.toList());
		Course.of(details.get(0));
		Mission.findLevel(details.get(1));
		Mission.findMission(details.get(2));
	}
}
