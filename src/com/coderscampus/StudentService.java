package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class StudentService {

	Student[] compsciStudent = getCompsciStudent();
	Student[] APMathStudent = getAPMathStudent();
	Student[] statStudent = getStatStudent();

	public Student[] readFromFile() {
		int i = 0;
		String line = "";
		Student[] student = new Student[100];
		try (BufferedReader fileReader = new BufferedReader(new FileReader("student-master-list.csv"))) {
			fileReader.readLine();
			while ((line = fileReader.readLine()) != null) {
				String[] info = line.split(",");
				String id = info[0];
				String name = info[1];
				String course = info[2];
				String Strgrade = info[3];
				Integer grade = Integer.parseInt(Strgrade);
				student[i] = new Student(id, name, course, grade);
				i++;
			}
			return student;

		} catch (FileNotFoundException e) {
			System.out.println("A FileNotFoundException has occured");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("An IOException has occured");
			e.printStackTrace();
		}

		return student;
	}

	public Student[] getCompsciStudent() {
		Student[] student = new Student[100];
		student = readFromFile();
		Student[] compSci = new Student[100];
		int count = 0;
		int j = 0;
		for (int i = 0; i < student.length; i++) {
			if (student[i].getCourse().matches("^[COMPSCI]+\\s[0-9]{1,3}$")) {
				compSci[i] = student[i];
				count++;
			}
		}
		Student[] compSci2 = new Student[count];
		for (int k = 0; k < compSci.length; k++) {
			if (compSci[k] != null) {
				compSci2[j] = compSci[k];
				j++;
			}
		}
		Arrays.sort(compSci2);
		return compSci2;
	}

	public Student[] getAPMathStudent() {
		Student[] student = new Student[101];
		student = readFromFile();
		Student[] math = new Student[100];
		int count = 0;
		int j = 0;
		for (int i = 0; i < student.length; i++) {
			if (student[i].getCourse().matches("^[APMTH]+\\s[0-9]{1,3}$")) {
				math[i] = student[i];
				count++;
			}
		}
		Student[] math2 = new Student[count];
		for (int k = 0; k < math.length; k++) {
			if (math[k] != null) {
				math2[j] = math[k];
				j++;
			}
		}
		Arrays.sort(math2);
		return math2;
	}

	public Student[] getStatStudent() {
		Student[] student = new Student[101];
		student = readFromFile();

		Student[] stat = new Student[100];
		int count = 0;
		int j = 0;
		for (int i = 0; i < student.length; i++) {
			if (student[i].getCourse().matches("^[STAT]+\\s[0-9]{1,3}$")) {
				stat[i] = student[i];
				count++;
			}
		}
		Student[] stat2 = new Student[count];
		for (int k = 0; k < stat.length; k++) {
			if (stat[k] != null) {
				stat2[j] = stat[k];
				j++;
			}
		}
		Arrays.sort(stat2);
		return stat2;
	}

}
