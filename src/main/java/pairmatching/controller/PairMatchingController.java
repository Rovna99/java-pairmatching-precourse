package pairmatching.controller;

import static pairmatching.domain.MainFunctionCommand.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.domain.MatchResult;
import pairmatching.domain.UserDetail;
import pairmatching.service.PairMatchService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {
	private final PairMatchService pairMatchService;

	public PairMatchingController() {
		pairMatchService = new PairMatchService();
	}

	public void run() {
		String selectMain = "";
		while (!selectMain.equals(QUIT.getCommand())) {
			try {
				selectMain = InputView.inputMainFunctionSelect();
				performSelectFunction(selectMain);
			} catch (IllegalArgumentException e) {
				OutputView.printError(e.getMessage());
			}
		}
	}

	public void performSelectFunction(String selectMain) {
		if (selectMain.equals(PAIR_MATCH.getCommand())) {
			selectPairMatch();
		}
		if (selectMain.equals(PAIR_INQUIRY.getCommand()) && pairMatchService.checkResults()) {
			selectPairInquiry();
		}
		if (selectMain.equals(PAIR_INIT.getCommand())) {
			selectPairInit();
		}
	}

	private void selectPairMatch() {
		try {
			UserDetail detail = receiveUserDetails();
			pairMatch(detail);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			selectPairMatch();
		}
	}

	private UserDetail receiveUserDetails() {
		OutputView.printCourseAndMission();
		List<String> detail = Arrays.stream(InputView.inputCourseAndMission().replaceAll(" ", "")
			.split(",")).collect(Collectors.toList());
		return new UserDetail(detail.get(0), detail.get(1), detail.get(2));
	}

	private void pairMatch(UserDetail detail) {
		if (pairMatchService.isDetailCanMatch(detail)) {
			MatchResult matchResult = pairMatchService.matchPair(detail);
			OutputView.printMatchResult(matchResult.getMatchResult());
			return;
		}
		rematch(detail);
	}

	private void rematch(UserDetail detail) {
		while (InputView.inputPairRematch().equals("네")) {
			MatchResult matchResult = pairMatchService.matchPair(detail);
			if (!matchResult.isEmpty()) {
				OutputView.printMatchResult(matchResult.getMatchResult());
				return;
			}
		}
	}

	private void selectPairInquiry() {
		try {
			UserDetail userDetail = receiveUserDetails();
			MatchResult matchResult = pairMatchService.InquiryMatchResult(userDetail);
			OutputView.printMatchResult(matchResult.getMatchResult());
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			selectPairInquiry();
		}
	}

	private void selectPairInit() {
		OutputView.printInitMessage();
		pairMatchService.initMatchResults();
	}

}
