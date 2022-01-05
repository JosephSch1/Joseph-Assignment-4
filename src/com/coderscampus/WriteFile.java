package com.coderscampus;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class WriteFile {

	public void writeStudentsToFile(Student[] students, String fileName) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			writer.write("Student ID," + "Student Name," + "Course," + "Grade" + "\n");
			for (int i = 0; i < students.length; i++) {
				if (students[i] != null) {
					writer.write(students[i].getStudentId() + "," + students[i].getName() + "," + students[i].getCourse()
							+ "," + students[i].getGrade() + "\n");
				}
			}

		} catch (IOException e) {
			System.out.println("Encountered an IO exception");
			e.printStackTrace();
		}
	}
}
	