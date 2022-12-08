package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Crew {
	private final String name;
	private final List<String> pairNames;

	public Crew(String name) {
		this.name = name;
		this.pairNames = new ArrayList<>();
	}

	public void savePairName(String pairName) {
		pairNames.add(pairName);
	}

	public boolean hasMatchHistory(String pairName) {
		return pairNames.contains(pairName);
	}

}
