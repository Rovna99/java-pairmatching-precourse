package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Crews {
	private final List<Crew> crews;
	private List<Pair> matched = new ArrayList<>();

	public Crews(List<String> crewNames) {
		crews = creatCrews(crewNames);
	}

	private List<Crew> creatCrews(List<String> crewNames) {
		List<Crew> crew = new ArrayList<>();
		for (String name : crewNames) {
			crew.add(new Crew(name));
		}
		return crew;
	}

	public void suppleCrews() {
		 Randoms.shuffle(crews);
	}

	public void matchCrews() {
		initMatched();
		if (crews.size() % 2 == 0) {
			matchEvenCrews();
		}
		if (crews.size() % 2 != 0 && canMatchOddNumberCrews()) {
			matchOddCrews();
		}
	}

	private void initMatched() {
		matched = new ArrayList<>();
	}

	private boolean canMatchOddNumberCrews() {
		int LastThreeCrewsIndex = crews.size()-3;
		Crew crew1 = crews.get(LastThreeCrewsIndex++);
		Crew crew2 = crews.get(LastThreeCrewsIndex++);
		Crew crew3 = crews.get(LastThreeCrewsIndex);
		return !isPairedOneTime(crew1, crew2, crew3);
	}

	private void matchEvenCrews() {
		for (int i = 0; i < crews.size(); i = i+2) {
			Crew crew1 = crews.get(i);
			Crew crew2 = crews.get(i+1);
			if (isPairedOneTime(crew1, crew2)) {
				break;
			}
			matchEvenCrew(crew1, crew2);
		}
	}

	private void matchOddCrews() {
		for (int i = 0; i < crews.size()-3; i = i+2) {
			Crew crew1 = crews.get(i);
			Crew crew2 = crews.get(i+1);
			if (isPairedOneTime(crew1, crew2) ) {
				break;
			}
			matchEvenCrew(crew1, crew2);
		}
	}

	private boolean isPairedOneTime(Crew crew1, Crew crew2) {
		return crew1.hasMatchHistory(crew2);
	}

	private boolean isPairedOneTime(Crew crew1, Crew crew2, Crew crew3) {
		return (crew1.hasMatchHistory(crew2) && crew1.hasMatchHistory(crew3) && crew2.hasMatchHistory(crew3));
	}

	private void matchEvenCrew(Crew crew1, Crew crew2) {
		saveEvenCrew(crew1, crew2);
		matched.add(new Pair(crew1, crew2));

	}

	private void matchOddCrew(Crew crew1, Crew crew2, Crew crew3) {
		saveOddCrew(crew1, crew2, crew3);
		matched.add(new Pair(crew1, crew2, crew3));

	}

	private void saveEvenCrew(Crew crew1, Crew crew2) {
		crew1.savePair(crew2);
		crew2.savePair(crew1);
	}

	private void saveOddCrew(Crew crew1, Crew crew2, Crew crew3) {
		crew1.savePair(crew2);
		crew1.savePair(crew3);
		crew2.savePair(crew1);
		crew2.savePair(crew3);
		crew3.savePair(crew1);
		crew3.savePair(crew2);
	}

	public List<Pair> getMatched() {
		return matched;
	}
}
