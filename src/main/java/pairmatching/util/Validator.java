package pairmatching.util;

import pairmatching.domain.MainFunctionCommand;

public class Validator {

	public static void validateMainFunctionSelect(String input) {
		MainFunctionCommand.of(input);
	}
}
