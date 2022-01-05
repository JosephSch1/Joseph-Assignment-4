package com.coderscampus;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;


public class StudentService {
	
	WriteFile newFile = new WriteFile();

	Student[] compsciStudent = new Student[40];
	Student[] APMathStudent =  new Student[40];
	Student[] statStudent = new Student[40];
	
	
	public StudentService() {
		readStudentsFromFile();
	}

	public void createStudentFileByCourse() {
		newFile.writeStudentsToFile(compsciStudent, "course1.csv");
		newFile.writeStudentsToFile(APMathStudent, "course2.csv");
		newFile.writeStudentsToFile(statStudent, "course3.csv");
	}
	
	public void readStudentsFromFile() {
		String line = "";
		
		int compsciIdx = 0;
		int mathIdx = 0;
		int statIdx = 0;
		
		try (BufferedReader fileReader = new BufferedReader(new FileReader("student-master-list.csv"))) {
			fileReader.readLine();
			while ((line = fileReader.readLine()) != null) {
				String[] info = line.split(",");
				String id = info[0];
				String name = info[1];
				String course = info[2];
				String Strgrade = info[3];
				Integer grade = Integer.parseInt(Strgrade);
				Student studentInfo = new Student(id, name, course, grade);
				if (studentInfo.getCourse().matches("^[COMPSCI]+\\s[0-9]{1,3}$")) {
					compsciStudent[compsciIdx++] = studentInfo;
				}
				if (studentInfo.getCourse().matches("^[APMTH]+\\s[0-9]{1,3}$")) {
					APMathStudent[mathIdx++] = studentInfo;
				}
				if (studentInfo.getCourse().matches("^[STAT]+\\s[0-9]{1,3}$")) {
					statStudent[statIdx++] = studentInfo;
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("A FileNotFoundException has occured");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("An IOException has occured");
			e.printStackTrace();
		}
	}

	public Student[] getCompsciStudent() {
		return getSortedList(compsciStudent);
	}

	public Student[] getAPMathStudent() {
		return getSortedList(APMathStudent);
	}

	public Student[] getStatStudent() {
		return getSortedList(statStudent);
	}
	
	public Student[] getSortedList(Student[] students) {
		Arrays.sort(students, new Comparator<Student>() {

			@Override
			public int compare(Student student1, Student student2) {
				if (student1 == null || student2 == null) {
				return 0;
				} else {
					return student2.compareTo(student1);
				}
			}
			
		});
		return students;
	}
}
