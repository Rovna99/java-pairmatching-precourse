package pairmatching.service;

import java.util.List;

import pairmatching.domain.Crews;
import pairmatching.domain.MatchResult;
import pairmatching.domain.MatchResults;
import pairmatching.domain.UserDetail;

public class PairMatchService {
	private final MatchResults matchResults = new MatchResults();

	public boolean isDetailCanMatch(UserDetail detail) {
		return matchResults.canMatch(detail);
	}

	public MatchResult matchPair(UserDetail detail) {
		Crews crews = new Crews(createCrewNames(detail.getCourseName()));
		crews.suppleCrews();
		crews.matchCrews();
		MatchResult matchResult = new MatchResult(detail, crews.getMatched());
		matchResults.saveResult(matchResult);
		return matchResult;
	}

	private List<String> createCrewNames(String fileName) {
		CrewReader crewReader = new CrewReader(fileName);
		return crewReader.readCrewNames();
	}

	public MatchResult InquiryMatchResult(UserDetail userDetail) {
		return matchResults.getMatchResult(userDetail);
	}

	public boolean checkResults() {
		return matchResults.canInquiryResults();
	}


}
