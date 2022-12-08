package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Pair {
	private final Crew crew1;
	private final Crew crew2;
	private final Crew crew3;
	private final List<String> pairNames;

	public Pair(Crew crew1, Crew crew2) {
		this.crew1 = crew1;
		this.crew2 = crew2;
		this.crew3 = null;
		pairNames = createEvenPairNames();
	}

	private List<String> createEvenPairNames() {
		List<String> pairNames = new ArrayList<>();
		pairNames.add(crew1.getName());
		pairNames.add(crew2.getName());
		return pairNames;
	}

	public Pair(Crew crew1, Crew crew2, Crew crew3) {
		this.crew1 = crew1;
		this.crew2 = crew2;
		this.crew3 = crew3;
		pairNames = createOddPairNames();
	}

	private List<String> createOddPairNames() {
		List<String> pairNames = new ArrayList<>();
		pairNames.add(crew1.getName());
		pairNames.add(crew2.getName());
		pairNames.add(crew3.getName());
		return pairNames;
	}

	public List<String> getPairName() {
		return pairNames;
	}
}
