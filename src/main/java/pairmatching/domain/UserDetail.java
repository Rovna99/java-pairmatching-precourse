package pairmatching.domain;

public class UserDetail {
	private final Course course;
	private final String level;
	private final String mission;

	public UserDetail(String course, String level, String mission) {
		this.course = Course.of(course);
		this.level = level;
		this.mission = mission;
	}

	public String getCourseName() {
		return course.getCourseName();
	}

	public boolean isSameDetail(UserDetail detail) {
		return (course == detail.course && level.equals(detail.level) && mission.equals(detail.mission));
	}
}
