package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Crew {
	private final String name;
	private final List<Crew> pairedCrew;

	public Crew(String name) {
		this.name = name;
		this.pairedCrew = new ArrayList<>();
	}

	public void savePair(Crew pairCrew) {
		pairedCrew.add(pairCrew);
	}

	public boolean hasMatchHistory(Crew pairCrew) {
		return pairedCrew.contains(pairCrew);
	}

	public String getName() {
		return name;
	}
}
