package pairmatching.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CrewTest {

	@ParameterizedTest
	@ValueSource(strings = {"메이배달이, 엉클배달이, 왕배달이"})
	void crewHistoryCheckTest(String pairName) {
		Crew crew = new Crew("독고배달");

		crew.savePairName(pairName);

		assertTrue(crew.hasMatchHistory(pairName));
	}
}
