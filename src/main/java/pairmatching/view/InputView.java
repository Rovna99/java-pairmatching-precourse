package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.util.Validator;

public class InputView {

	public static String inputMainFunctionSelect() {
		System.out.println("기능을 선택하세요.");
		System.out.println("1. 페어 매칭");
		System.out.println("2. 페어 조회");
		System.out.println("3. 페어 초기화");
		System.out.println("Q. 종료");
		String input = Console.readLine();
		Validator.validateMainFunctionSelect(input);
		return input;
	}

}
