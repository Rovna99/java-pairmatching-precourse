package pairmatching.controller;


import static pairmatching.domain.MainFunctionCommand.*;

import pairmatching.view.InputView;

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

	public void selectPairMatch() {

	}

	public void selectPairInquiry() {

	}

	public void selectPairInit() {

	}

}
