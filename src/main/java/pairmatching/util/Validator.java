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

	public static void validatePairRematch(String input) {
		if (!(input.equals("네") || input.equals("아니오"))) {
			throw new IllegalArgumentException("네 또는 아니오 중에 입력해주세요.");
		}
	}

	public static void validateCourseAndMission(String input) {
		List<String> details = Arrays.stream(input.replaceAll(" ","").split(","))
			.collect(Collectors.toList());
		if (details.size() != 3) {
			throw new IllegalArgumentException("과정, 레벨, 미션을 모두 입력해주세요.");
		}
		Course.of(details.get(0));
		Mission.findLevel(details.get(1));
		Mission.findMission(details.get(2));
	}
}
