package pairmatching.domain;

import java.util.Arrays;

public enum Course {
	BACKEND("백엔드", "backend-crew.md"),
	FRONTEND("프론트엔드", "frontend-crew.md");

	private final String name;
	private final String courseName;

	Course(String name, String courseName) {
		this.name = name;
		this.courseName = courseName;
	}

	public static Course of(String input) {
		return Arrays.stream(Course.values()).filter(course -> course.name.equals(input)).findFirst()
			.orElseThrow(() -> new IllegalArgumentException("잘못된 코스 이름 입니다."));
	}

	public String getCourseName() {
		return courseName;
	}
}
