package pairmatching.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Mission {
	LEVEL1_MISSION("레벨1", Arrays.asList("자동차경주", "로또" ,"숫자야구게임")),
	LEVEL2_MISSION("레벨2", Arrays.asList("장바구니", "결제" , "지하철노선도")),
	LEVEL3_MISSION("레벨3", Collections.emptyList()),
	LEVEL4_MISSION("레벨4", Arrays.asList("성능개선" , "배포")),
	LEVEL5_MISSION("레벨5", Collections.emptyList());

	private final String level;
	private final List<String> missions;

	Mission(String level, List<String> missions) {
		this.level = level;
		this.missions = missions;
	}

	public static Mission findMission(String input) {
		return Arrays.stream(Mission.values()).filter(mission -> mission.missions.contains(input)).findFirst()
			.orElseThrow(() -> new IllegalArgumentException("잘못된 미션 이름입니다."));
	}

	public static String findLevel(String input) {
		return Arrays.stream(Mission.values()).filter(mission -> mission.level.equals(input)).findFirst()
			.orElseThrow(() -> new IllegalArgumentException("잘못된 레벨입니다.")).getLevel();
	}

	public String getLevel() {
		return level;
	}
}
