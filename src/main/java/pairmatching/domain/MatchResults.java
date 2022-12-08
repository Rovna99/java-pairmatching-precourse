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

	public MatchResult getMatchResult(UserDetail userDetail) {
		for (MatchResult result : results) {
			if (result.hasMatchResult(userDetail)) {
				return result;
			}
		}
		throw new IllegalArgumentException("매칭된 이력이 없습니다.");
	}

	public boolean canInquiryResults() {
		if (results.isEmpty()) {
			throw new IllegalArgumentException("매칭된 이력이 없습니다.");
		}
		return true;
	}

	public void initResults() {
		results.clear();
	}
}
