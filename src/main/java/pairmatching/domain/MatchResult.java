package pairmatching.domain;

import java.util.List;

public class MatchResult {
	private final Level level;
	private final String mission;
	private final List<Pair> matchResult;
	public MatchResult(Level level, String mission, List<Pair> matchResult) {
		this.level = level;
		this.mission = mission;
		this.matchResult = matchResult;
	}

	public boolean hasMatchResult(Level level, String mission) {
		return (this.level == level && this.mission.equals(mission));
	}
}
