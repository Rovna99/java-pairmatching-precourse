package pairmatching.controller;


import static pairmatching.domain.MainFunctionCommand.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

	public void run() {
		String selectMain = "";
		while (selectMain.equals(QUIT.getCommand())) {
			selectMain = InputView.inputMainFunctionSelect();
			performSelectFunction(selectMain);
		}
	}

	public void performSelectFunction(String selectMain) {
		if (selectMain.equals(PAIR_MATCH.getCommand())) {
			selectPairMatch();
		}
		if (selectMain.equals(PAIR_INQUIRY.getCommand())) {
			selectPairInquiry();
		}
		if (selectMain.equals(PAIR_INIT.getCommand())) {
			selectPairInit();
		}
	}

	private void selectPairMatch() {
		List<String> courseAndMission = receiveUserDetails();
	}

	private List<String> receiveUserDetails() {
		OutputView.printCourseAndMission();
		return Arrays.stream(InputView.inputCourseAndMission().split(","))
			.collect(Collectors.toList());
	}

	private void selectPairInquiry() {

	}

	private void selectPairInit() {

	}

}
