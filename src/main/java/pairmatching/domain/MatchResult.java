package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class MatchResult {
	private final UserDetail userDetail;
	private final List<Pair> matchResult;
	public MatchResult(UserDetail detail, List<Pair> matchResult) {
		this.userDetail = detail;
		this.matchResult = matchResult;
	}

	public boolean hasMatchResult(UserDetail detail) {
		if (matchResult.isEmpty()) {
			return false;
		}
		return userDetail.isSameDetail(detail);
	}

	public List<List<String>> getMatchResult() {
		List<List<String>> pairNames = new ArrayList<>();
		for (Pair pair : matchResult) {
			pairNames.add(pair.getPairName());
		}
		return pairNames;
	}

	public boolean isEmpty() {
		return matchResult.isEmpty();
	}
}

