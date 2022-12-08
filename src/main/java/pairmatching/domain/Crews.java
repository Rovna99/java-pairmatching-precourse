package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Crews {
	private final List<String> crewNames;
	private final List<Crew> crews;

	public Crews(List<String> crewNames) {
		this.crewNames = crewNames;
		crews = creatCrews();
	}

	private List<Crew> creatCrews() {
		List<Crew> crew = new ArrayList<>();
		for (String name : crewNames) {
			crew.add(new Crew(name));
		}
		return crew;
	}

	public List<String> suppleCrewName() {
		return Randoms.shuffle(crewNames);
	}
}
