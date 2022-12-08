package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Pair {
	private final List<Crew> pair;

	public Pair(Crew crew1, Crew crew2) {
		pair = createPair(crew1, crew2);
	}

	private List<Crew> createPair(Crew crew1, Crew crew2) {
		List<Crew> matchedCrew = new ArrayList<>();
		matchedCrew.add(crew1);
		matchedCrew.add(crew2);
		return matchedCrew;
	}
}
