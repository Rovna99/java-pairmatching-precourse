package pairmatching.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class CrewsTest {

	@Test
	void crewSuppleTest() {
		List<String> crewNames = Arrays.asList("독고배달","메리배달이","엉클배달이","왕배달이");
		Crews crews = new Crews(crewNames);

		List<String> suppleCrews = crews.suppleCrewName();

		assertNotEquals(crewNames, suppleCrews);
	}
}
