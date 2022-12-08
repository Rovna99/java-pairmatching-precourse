package pairmatching.service;

import java.util.List;

import pairmatching.domain.Crews;
import pairmatching.domain.MatchResult;
import pairmatching.domain.MatchResults;
import pairmatching.domain.UserDetail;

public class PairMatchService {
	private final MatchResults matchResults = new MatchResults();
	private final Crews backendCrews = new Crews(createBackendCrew());
	private final Crews frontendCrews = new Crews(createFrontendCrew());

	public boolean isDetailCanMatch(UserDetail detail) {
		return matchResults.canMatch(detail);
	}

	public MatchResult matchPair(UserDetail detail) {
		MatchResult matchResult = null;
		if (detail.getCourseName().equals("백엔드")) {
			matchResult = matchBackend(detail);
		}
		if (detail.getCourseName().equals("프론트엔드")) {
			matchResult = matchFrontend(detail);
		}
		return matchResult;
	}

	private MatchResult matchBackend(UserDetail detail) {
		backendCrews.suppleCrews();
		backendCrews.matchCrews();
		MatchResult matchResult = new MatchResult(detail, backendCrews.getMatched());
		matchResults.saveResult(matchResult);
		return matchResult;
	}

	private MatchResult matchFrontend(UserDetail detail) {
		frontendCrews.suppleCrews();
		frontendCrews.matchCrews();
		MatchResult matchResult = new MatchResult(detail, frontendCrews.getMatched());
		matchResults.saveResult(matchResult);
		return matchResult;
	}

	private List<String> createBackendCrew() {
		CrewReader crewReader = new CrewReader("backend-crew.md");
		return crewReader.readCrewNames();
	}

	private List<String> createFrontendCrew() {
		CrewReader crewReader = new CrewReader("frontend-crew.md");
		return crewReader.readCrewNames();
	}

	public MatchResult InquiryMatchResult(UserDetail userDetail) {
		return matchResults.getMatchResult(userDetail);
	}

	public boolean checkResults() {
		return matchResults.canInquiryResults();
	}

	public void initMatchResults() {
		matchResults.initResults();
	}
}
