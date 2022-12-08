package pairmatching.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class CrewReaderTest {

	@Test
	void readerTest() {
		CrewReader crewReader = new CrewReader("backend-crew.md");
		List<String> expect = Arrays.asList("백호", "태웅", "치수", "태섭", "대만", "준호", "대협", "덕규", "태산", "경태", "수겸",
			"현준", "준섭", "한나", "소연", "호열", "대남", "용팔", "구식", "달재");

		List<String> nameList = crewReader.readCrewNames();

		assertEquals(expect, nameList);
	}
}
