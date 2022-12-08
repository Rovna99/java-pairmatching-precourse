package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class MatchResults {
	private final List<MatchResult> results = new ArrayList<>();

	public boolean canMatch(UserDetail userDetail) {
		return results.stream().noneMatch(matchResult -> matchResult.hasMatchResult(userDetail));
	}

	public void saveResult(MatchResult result) {
		results.add(result);
	}
}
