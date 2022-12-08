package pairmatching.domain;

import java.util.Arrays;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private final String name;

	Course(String name) {
		this.name = name;
	}

	public static Course of(String input) {
		return Arrays.stream(Course.values()).filter(course -> course.name.equals(input)).findFirst()
			.orElseThrow(() -> new IllegalArgumentException("잘못된 코스 이름 입니다."));
	}

	public String getCourseName() {
		return name;
	}
}
