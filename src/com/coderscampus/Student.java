package com.coderscampus;

public class Student implements Comparable<Student> {

	private String studentId;
	private String name;
	private String course;
	private Integer grade;

	public Student(String studentId, String name, String course, Integer grade) {
		this.studentId = studentId;
		this.name = name;
		this.course = course;
		this.grade = grade;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	@Override
	public int compareTo(Student that) {
		return that.grade - this.grade;
	}

}
