package pairmatching.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class MatchResultTest {

	@Test
	void matchResultTest() {
		Level level1 = Level.LEVEL1;
		Level level2 = Level.LEVEL2;
		String mission1 = "자동차 경주";
		String mission2 = "로또";
		List<Pair> result = new ArrayList<>();
		MatchResult matchResult = new MatchResult(level1, mission1, result);

		assertFalse(matchResult.hasMatchResult(level2, mission2));
	}
}
