package pairmatching.domain;

public enum Course {
	BACKEND("백엔드", "backend-crew.md"),
	FRONTEND("프론트엔드", "frontend-crew.md");

	private final String name;
	private final String courseName;

	Course(String name, String courseName) {
		this.name = name;
		this.courseName = courseName;
	}

	public void findByCourse() {

	}

	public String getCourseName() {
		return courseName;
	}
}
