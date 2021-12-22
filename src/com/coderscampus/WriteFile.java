package com.coderscampus;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class WriteFile {

	public void writeCSFile() {
		StudentService service = new StudentService();
		Student[] compsci = service.compsciStudent;

		try (BufferedWriter writer = new BufferedWriter(new FileWriter("course1.csv"))) {
			writer.write("Student ID," + "Student Name," + "Course," + "Grade" + "\n");
			for (int i = 0; i < compsci.length; i++) {
				if (compsci[i] != null) {
					writer.write(compsci[i].getStudentId() + "," + compsci[i].getName() + "," + compsci[i].getCourse()
							+ "," + compsci[i].getGrade() + "\n");
				}
			}

		} catch (IOException e) {
			System.out.println("Encountered an IO exception");
			e.printStackTrace();
		}
	}

	public void writeStatFile() {
		StudentService service = new StudentService();
		Student[] stat = service.statStudent;
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("course2.csv"))) {
			writer.write("Student ID," + "Student Name," + "Course," + "Grade" + "\n");
			for (int i = 0; i < stat.length; i++) {
				if (stat[i] != null) {
					writer.write(stat[i].getStudentId() + "," + stat[i].getName() + "," + stat[i].getCourse() + ","
							+ stat[i].getGrade() + "\n");
				}
			}
		} catch (IOException e) {
			System.out.println("Encountered an IO exception");
			e.printStackTrace();
		}
	}

	public void writeMathFile() {
		StudentService service = new StudentService();
		Student[] math = service.APMathStudent;
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("course3.csv"))) {
			writer.write("Student ID," + "Student Name," + "Course," + "Grade" + "\n");
			for (int i = 0; i < math.length; i++) {
				if (math[i] != null) {
					writer.write(math[i].getStudentId() + "," + math[i].getName() + "," + math[i].getCourse() + ","
							+ math[i].getGrade() + "\n");
				}
			}
		} catch (IOException e) {
			System.out.println("Encountered an IO exception");
			e.printStackTrace();
		}
	}
}
