////YOTUBE LINK  https://www.youtube.com/watch?v=z6tUlmeoIv8&ab_channel=%D0%90%D0%BB%D1%8C%D0%B1%D0%B8%D0%BD%D0%B0%D0%9A%D1%80%D0%B0%D1%81%D0%B8%D0%BA%D0%BE%D0%B2%D0%B0

import java.io.File;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Driver_SchoolDB {

	public static void main(String[] args) throws IOException {

		List<Course> courses = new ArrayList<>();
		List<Faculty> faculty = new ArrayList<>();
		List<Student> students = new ArrayList<>();
		List<GeneralStaff> generalStuff = new ArrayList<>();

		FileInputStream fileStream = null;
		Scanner scanner = null;
		try {

			File file = new File("SchoolDB_Initial.txt");
			Scanner sc = new Scanner(file);
			String line = "";
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
			sc.close(); //closed the scanner 
			sc = new Scanner(file);

			while (sc.hasNextLine() && line != null) {

				String line1 = sc.nextLine();
				if (line1.startsWith("Course: ")) {
					String arguments = line1.substring("Course: ".length());
					String words[] = arguments.split(",");

					Boolean isGraduateCourse = Boolean.valueOf(words[0].trim());
					int courseNum = Integer.parseInt(words[1].trim());
					String courseDept = words[2].trim();
					int numCredits = Integer.parseInt(words[3].trim());
					Course course1 = new Course(isGraduateCourse, courseNum, courseDept, numCredits);//constructor - methods which returns an object 
					courses.add(course1);

				}

				if (line1.startsWith("Faculty:")) {
					if (line1.equals("Faculty:")) {
						Faculty faculty1 = new Faculty();

						faculty.add(faculty1);
					} else {
						String arguments = line1.substring("Faculty: ".length());
						String words[] = arguments.split(",");
						if (words.length == 1) {
							Boolean isTenured = Boolean.valueOf(words[0].trim());
							Faculty faculty2 = new Faculty(isTenured);
							faculty.add(faculty2);
						}
						if (words.length == 2) {
							// String deptName, boolean isTenured
							String deptName = words[0].trim();
							Boolean isTenured = Boolean.valueOf(words[1].trim());
							Faculty faculty3 = new Faculty(deptName, isTenured);

							faculty.add(faculty3);

						}
						if (words.length == 4) {
							// String name, int birthYear, String deptName, boolean isTenured
							String name = words[0].trim();
							int birthYear = Integer.parseInt(words[1].trim());
							String deptName = words[2].trim();
							Boolean isTenured = Boolean.valueOf(words[3].trim());

							Faculty faculty4 = new Faculty(name, birthYear, deptName, isTenured);

							faculty.add(faculty4);
						}
					}
				}
				if (line1.startsWith("GeneralStaff:")) {

					if (line1.equals("GeneralStaff:")) {
						GeneralStaff generalStaff1 = new GeneralStaff();

						generalStuff.add(generalStaff1);
					}

					// String duty
					else {
						String arguments = line1.substring("GeneralStaff: ".length());
						String words[] = arguments.split(",");
						if (words.length == 1) {
							String duty = words[0].trim();
							GeneralStaff generalStaff2 = new GeneralStaff(duty);

							generalStuff.add(generalStaff2);
						}
						if (words.length == 2) {// String deptName,String duty
							String deptName = words[0].trim();
							String duty = words[1].trim();
							GeneralStaff generalStaff3 = new GeneralStaff(deptName, duty);

							generalStuff.add(generalStaff3);
						}
						if (words.length == 4) { /// String name,int birthYear,String deptName,String duty
							String name = words[0].trim();
							int birthYear = Integer.parseInt(words[1].trim());
							String deptName = words[2].trim();
							String duty = words[3].trim();
							GeneralStaff generalStaff4 = new GeneralStaff(name, birthYear, deptName, duty);

							generalStuff.add(generalStaff4);
						}
					}

				}
				if (line1.startsWith("Student:")) {
					if (line1.equals("Student:")) {

						Student studentt = new Student();

						students.add(studentt);
					}

					else {
						String arguments = line1.substring("Student: ".length());
						String words[] = arguments.split(",");
						if (words.length == 1) {// boolean isGraduate
							Boolean isGraduate = Boolean.valueOf(words[0].trim());
							Student student1 = new Student(isGraduate);

							students.add(student1);
						}
						if (words.length == 2) {// String major, boolean isGraduate
							String major = words[0].trim();
							Boolean isGraduate = Boolean.valueOf(words[1].trim());
							Student student2 = new Student(major, isGraduate);

							students.add(student2);
						}
						if (words.length == 4) { // String name, int birthYear, String major, boolean isGraduate
							String name = words[0].trim();
							int birthYear = Integer.parseInt(words[1].trim());
							String major = words[2].trim();
							Boolean isGraduate = Boolean.valueOf(words[3].trim());
							Student student3 = new Student(name, birthYear, major, isGraduate);

							students.add(student3);
						}

					}
				}

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (fileStream != null && scanner != null) {
				fileStream.close();
				scanner.close();

			}
		}

		Scanner sc = new Scanner(System.in);
		// String choice = sc.next();
		String name = "";
		//String stored_User_choice = "";

		System.out.println(
				"Good afternoon! Welcome to the School Database! " + "\nDear User, introduce yourself please.");

		name = sc.nextLine();
		boolean isFinished = false;
		while (!isFinished) {
			displayMenu();
			String menuChoice = sc.nextLine();

			switch (menuChoice) {

			case "A": {
				System.out.println("You chose option A  < create a course >");
				System.out.println("Type parameters of the course, please");
				System.out.println(
						"1)isGraduate course?\n2)What is the course Number?\n3)What is the course Deparment\n4)What is the number of credits?(SEPARATE parameters , ) ");
				String userParameters = sc.nextLine();
				if (userParameters.isEmpty()) {
					System.out.println("add some parameters");
				} else {
					String[] parameters = userParameters.split(",");
					Boolean isGraduateCourse = Boolean.valueOf(parameters[0].trim());
					int courseNum = Integer.parseInt(parameters[1].trim());
					String courseDept = parameters[2].trim();
					int numCredits = Integer.parseInt(parameters[3].trim());
					Course userCourse1 = new Course(isGraduateCourse, courseNum, courseDept, numCredits);
					courses.add(userCourse1);
					System.out.print("Succesfully created a student object  ");
				}

				break;

			}
			case "B": {
				System.out.println("You chose option B < create a faculty >");
				System.out.println("Type parameters of the faculty, please");
				String userParameters = sc.nextLine();
				if (userParameters.isEmpty()) {
					Faculty userFaculty1 = new Faculty();

					faculty.add(userFaculty1);
					System.out.print("Succesfully added new default faculty to the database");
				} else {
					String[] parameters = userParameters.split(",");
					if (parameters.length == 1) {
						Boolean isTenured = Boolean.valueOf(parameters[0]);
						Faculty userFaculty2 = new Faculty(isTenured);
						faculty.add(userFaculty2);
						System.out.print("Succesfully added new  faculty to the database which has 1 parameter ");
					}
					if (parameters.length == 2) {
						// String deptName, boolean isTenured
						String deptName = parameters[0].trim();
						Boolean isTenured = Boolean.valueOf(parameters[1]);
						Faculty userFaculty3 = new Faculty(deptName, isTenured);

						faculty.add(userFaculty3);
						System.out.print("Succesfully added new  faculty to the database which has 2 parameter ");

					}
					if (parameters.length == 4) {
						// String name, int birthYear, String deptName, boolean isTenured
						String name2 = parameters[0].trim();
						int birthYear = Integer.parseInt(parameters[1]);
						String deptName = parameters[2].trim();
						Boolean isTenured = Boolean.valueOf(parameters[3]);

						Faculty userFaculty4 = new Faculty(name, birthYear, deptName, isTenured);

						faculty.add(userFaculty4);
						System.out.print("Succesfully added new  faculty to the database which has 4 parameter ");

					}

				}
				break;

			}
			// break;

			case "C": {
				System.out.println("You chose option C < create General Staff >");
				System.out.println("Type parameters of the generalstaff, please");
				String userParameters = sc.nextLine();
				if (userParameters.isEmpty()) {

					GeneralStaff defaultGenstaff = new GeneralStaff();
					System.out.println("Succesfully added default student faculty to the database");
					generalStuff.add(defaultGenstaff);
					break;
				}
				String[] parameters = userParameters.split(",");
				if (parameters.length == 1) {
					String duty = parameters[0].trim();
					GeneralStaff generalStaff2 = new GeneralStaff(duty);

					generalStuff.add(generalStaff2);
				}
				if (parameters.length == 2) {// String deptName,String duty
					String deptName = parameters[0].trim();
					String duty = parameters[1].trim();
					GeneralStaff generalStaff3 = new GeneralStaff(deptName, duty);

					generalStuff.add(generalStaff3);
				}
				if (parameters.length == 4) { /// String name,int birthYear,String deptName,String duty
					String name3 = parameters[0].trim();
					int birthYear = Integer.parseInt(parameters[1].trim());
					String deptName = parameters[2].trim();
					String duty = parameters[3].trim();
					GeneralStaff generalStaff4 = new GeneralStaff(name, birthYear, deptName, duty);

					generalStuff.add(generalStaff4);
				}

				break;

			}

			case "D": {
				System.out.println("You chose option D < create student >");

				System.out.println("Type parameters of the student, please");
				String userParameters = sc.nextLine();
				if (userParameters.isEmpty()) {

					Student defaultStudent = new Student();
					System.out.print("Succesfully added new default student to the database");
					break;

				}

				String parameters[] = userParameters.split(",");
				if (parameters.length == 1) {// boolean isGraduate
					Boolean isGraduate = Boolean.valueOf(parameters[0].trim());
					Student UserStudent1 = new Student(isGraduate);

					students.add(UserStudent1);
					System.out.print("Succesfully added new  student  to the database which has 1 parameter ");
				}
				if (parameters.length == 2) {// String major, boolean isGraduate
					String major = parameters[0].trim();
					Boolean isGraduate = Boolean.valueOf(parameters[1].trim());
					Student UserStudent2 = new Student(major, isGraduate);

					students.add(UserStudent2);
					System.out.print("Succesfully added new  student  to the database which has 2 parameter ");
				}
				if (parameters.length == 4) { // String name, int birthYear, String major, boolean isGraduate
					String name4 = parameters[0].trim();
					int birthYear = Integer.parseInt(parameters[1].trim());
					String major = parameters[2].trim();
					Boolean isGraduate = Boolean.valueOf(parameters[3].trim());
					Student UserStudent3 = new Student(name, birthYear, major, isGraduate);

					students.add(UserStudent3);
					System.out.print("Succesfully added new  student  to the database which has 4 parameter ");
					break;
				}

			}

			case "E": {
				System.out.println("You chose option E < add course to a faculty>");
				// display all faculties
				
				for(int i = 0;i<faculty.size();i++) {
					System.out.println(i+". "+faculty.get(i));
				}
				

				System.out.println("Type the index faculty of your choice");
				String userFaculty = sc.nextLine();
				// cast to the faculty object
				for(int i = 0;i<courses.size();i++) {
					System.out.println(i+". "+courses.get(i));
				}
				
				System.out.println("Type the  course of your choice");
				String userCourse = sc.nextLine(); // cast tot he course object

				
				int userFaculty1 = Integer.parseInt(userFaculty);
				int userCourse1 = Integer.parseInt(userCourse); //casting 
				
				Faculty faculty1 = faculty.get(userFaculty1); 
				Course course1 = courses.get(userCourse1);
				
				faculty1.addCourseTaught(course1);
				
				
				
				
				// aded course to the faculty
				
				System.out.println("The course was added");

				// faculties.get(userNumber).addCourse(courses.get(userNumberOfCourse);
				// user select the faculty
				// show all courses
				// chose the course and add it to previously chose faculty

				break;
			}
			case "F": {
				
				System.out.println("You chose option F < add course to a student object >");
				// display all courses
				for(int i = 0;i<students.size();i++) {
					System.out.println(i+". "+students.get(i));
				}
				

				System.out.println("Type the index faculty of your choice");
				String userStudents = sc.nextLine();
				// cast to the faculty object
				for(int i = 0;i<courses.size();i++) {
					System.out.println(i+". "+courses.get(i));
				}
				
				System.out.println("Type the  course of your choice");
				String userCourse = sc.nextLine(); // cast tot he course object

				students.get(Integer.parseInt(userStudents)).addCourseTaken(courses.get(Integer.parseInt(userCourse))); 
				// aded course to the faculty
				System.out.println("The course was added");

				

				 // aded course to the student
				break;
			}
			case "G": {
				System.out.println("You chose otpion G <  add an array of 2 courses to faculty object>");
				
				// display all faculties
				
				
				for(int i = 0;i<faculty.size();i++) {
					System.out.println(i+". "+faculty.get(i));
				}
				

				System.out.println("Type the index faculty of your choice. ");
				String userFaculty = sc.nextLine();
				
				// cast to the faculty object
				for(int i = 0;i<courses.size();i++) {
					System.out.println(i+". "+courses.get(i));
				}
				
				System.out.println("Type the  course of your choice,You can type a few courses , separate it with ','");
				String userCourse = sc.nextLine(); // cast tot he course object

				String [] userCourses = userCourse.split(",");
				
				List <Course>  coursesToAdd = new ArrayList<>();
				
				for(int i =0; i<userCourses.length; i++) {
					coursesToAdd.add(courses.get(Integer.parseInt(userCourses[i])));
				}
				Faculty faculty1 = faculty.get(Integer.parseInt(userFaculty));
				Course [] courses1 = coursesToAdd.toArray(new Course [coursesToAdd.size()]);
				
				faculty1.addCoursesTaught(courses1);
				System.out.println("The course was added");
				// display faculty object's courses
				// user chooses and saves index
				// methods that picks course at index which (user chose)

				break;
			}
			case "H": {
				System.out.println("You chose otpion G <  add an array of 2 course to student object >");
				for(int i = 0;i<students.size();i++) {
					System.out.println(i+". "+students.get(i));
				}
				

				System.out.println("Type the index faculty of your choice");
				String userStudent = sc.nextLine();
				
				// cast to the faculty object
				for(int i = 0;i<courses.size();i++) {
					System.out.println(i+". "+courses.get(i));
				}
				
				System.out.println("Type the  course of your choice");
				String userCourse = sc.nextLine(); // cast tot he course object

				String [] userCourses = userCourse.split(",");
				
				List <Course>  coursesToAdd = new ArrayList<>();
				
				for(int i =0; i<userCourses.length; i++) {
					coursesToAdd.add(courses.get(Integer.parseInt(userCourses[i])));
				}
				students.get(Integer.parseInt(userStudent)).addCoursesTaken(coursesToAdd.toArray(new Course [coursesToAdd.size()]));
				System.out.println("The course was added");
				
				break;
			}
			case "I": {
				System.out.println("get course of index from faculty object>");
				

				for(int i = 0;i<faculty.size();i++) {
					System.out.println(i+". "+faculty.get(i));
				}
				

				System.out.println("Type the index faculty of your choice");
				String userFaculty = sc.nextLine();
				
				
				
				System.out.println("Type the index course of your choice");
				String userCourse = sc.nextLine();
				
				// cast to the faculty object
				
				System.out.println(faculty.get(Integer.parseInt(userFaculty)).getCourseTaught(Integer.parseInt(userCourse)));
				
				
				
				
				break;

			}
			case "J": {
				
				System.out.println("get course of index from student object>");
                
				

				for(int i = 0;i<students.size();i++) {
					System.out.println(i+". "+students.get(i));
				}
				

				System.out.println("Type the index faculty of your choice");
				String userStudents = sc.nextLine();
				
				
				
				System.out.println("Type the index course of your choice");
				String userCourse = sc.nextLine();
				
				// cast to the faculty object
				
				System.out.println(students.get(Integer.parseInt(userStudents)).getCourseTaken(Integer.parseInt(userCourse)));
				
				
				break;

			}
			case "K": {
				System.out.println(" select a Faculty object and a Course object from menus and query the Faculty"
						+ " object for the Course to determine whether the Faculty object teaches it or not");
				
				for(int i = 0;i<faculty.size();i++) {
					System.out.println(i+". "+faculty.get(i));
				}
				
				

				System.out.println("Type the index faculty of your choice");
				String userFaculty = sc.nextLine();
				// cast to the faculty object
				for(int i = 0;i<courses.size();i++) {
					System.out.println(i+". "+courses.get(i));
				}
				
				System.out.println("Type the  course of your choice");
				String userCourse = sc.nextLine();
				
				Faculty userFaculty1 = faculty.get(Integer.parseInt(userFaculty));
				Course userCourse1 = courses.get(Integer.parseInt(userCourse));
				boolean isFound = false;
				for(int i =0;i<userFaculty1.getNumCoursesTaught();i++) {
					if(userCourse1.equals(userFaculty1.getCourseTaught(i))) {
						isFound = true;
						
					}
					
				}
				
				if (isFound = true) {
					System.out.println("course is assigned to the faculty");
				}
				else System.out.println("the course is not assigned tot the faculty");
				//faculty
				//course 
				
				break;

			}
			case "l": {
				System.out.println("Determine which Faculty object teaches the most and the least courses");
				
				List <Faculty> sortedFaculties = faculty.stream().sorted().collect(Collectors.toList());
				
				System.out.println("Faculty which teaches the most amount of courses" + sortedFaculties.get(0));
				
				
				
				break;
				//

			}
			case "m": {
				System.out.println("Determine which Course is the minimum of all Course objects in the catalog.");
				List <Faculty> sortedFaculties = faculty.stream().sorted().collect(Collectors.toList());
				System.out.println("Faculty which teaches the least amount of courses" + sortedFaculties.get(sortedFaculties.size()-1));
				
				break;

			}
			case "n": {
				System.out.println("Determine which Course is the minimum of all Course objects in the catalog.");
				break;

			}
			case "o": {
				System.out.println(" Determine which Student has the most and least credits.");
				break;

			}
			case "X": {
				System.out.println("Exit the MENU");
				isFinished = true;
				break;

			}

			}

		}
		System.out.println("Displaying New INFO edited to the Database by " + name);

		// write to the file

		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter("Test1.txt");
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.println("**************************************************************");
			printWriter.println("SCHOOL DATABASE INFO:\n");

			printWriter.println("************************************************");
			printWriter.println("COURSES:");
			for (Course course : courses) {
				printWriter.println(course);
			}
			printWriter.println("************************************************");
			printWriter.println("************************************************");
			printWriter.println("PERSONS:");
			printWriter.println("************************************************");
			printWriter.println("************************************************");
			printWriter.println("EMPLOYEES:");
			printWriter.println("************************************************");
			printWriter.println("************************************************");
			printWriter.println("GENERAL STAFF:");
			for (GeneralStaff genralStaffs : generalStuff) {
				printWriter.println(genralStaffs);
			}
			printWriter.println("************************************************");
			printWriter.println("************************************************");
			printWriter.println("FACULTY:");
			for (Faculty faculties : faculty) {
				printWriter.println(faculties);
			}
			printWriter.println("************************************************");
			printWriter.println("************************************************");
			printWriter.println("STUDENTS:");
			for (Student studentss : students) {
				printWriter.println(studentss);
			}
			printWriter.println("************************************************");
			printWriter.println("**************************************************************\n");
			printWriter.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println();
		System.out.println("**************************************************************");
		System.out.println("SCHOOL DATABASE INFO:\n");

		System.out.println("************************************************");
		System.out.println("COURSES:");
		for (Course course : courses) {
			System.out.println(course);
		}
		System.out.println("************************************************");
		System.out.println("************************************************");
		System.out.println("PERSONS:");
		System.out.println("************************************************");
		System.out.println("************************************************");
		System.out.println("EMPLOYEES:");
		System.out.println("************************************************");
		System.out.println("************************************************");
		System.out.println("GENERAL STAFF:");
		for (GeneralStaff genralStaffs : generalStuff) {
			System.out.println(genralStaffs);
		}
		System.out.println("************************************************");
		System.out.println("************************************************");
		System.out.println("FACULTY:");
		for (Faculty faculties : faculty) {
			System.out.println(faculties);
		}
		System.out.println("************************************************");
		System.out.println("************************************************");
		System.out.println("STUDENTS:");
		for (Student studentss : students) {
			System.out.println(studentss);
		}
		System.out.println("************************************************");
		System.out.println("**************************************************************\n");
	}

	public static void displayMenu() {

		String[] menu = { "Type A -  to select an option < create a course > ",
				"Type B -  to select an option < create a faculty > ",
				"Type C -  to select an option < create a Student > ",
				"Type D -  to select an option < create a GeneralStaff  > ",
				"Type E -  to select an option < add course to a Student > ",
				"Type F -  to select an option < add an array of 2 courses to a Faculty > ",
				"Type G -  to select an option < Add an array of 2 Courses to a Student object > ",
				"Type H -  to select an option < Add an array of 2 Courses to a Student object > ",
				"Type I -  to select an option < Get the Course at index  from a faculty object > ",
				"Type J - to select an option < Get the Course at index  from a Student object",
				"Type K Allow the user to select a Faculty object and a Course object from menus and query the"
						+ " Faculty object for the Course to determine whether the Faculty object teaches it or not",
				"Type l  Determine which Faculty object teaches the most and the least courses",
				"Type m determine which Course is the minimum of all Course objects in the catalog",
				"Type n  Determine which Course is the maximum of all Course objects in the catalog",
				"Type o Determine which Student has the most and least credits",
				"Type X -  to select an option < Get the Course at index  from a Student object > "

		};
		for (int i = 0; i < menu.length; i++) {
			System.out.println(menu[i]);
		}

	}
}
