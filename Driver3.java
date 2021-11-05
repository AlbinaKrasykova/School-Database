
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver3 {

	public static void main(String[] args) {

		List<Course> courses = new ArrayList<>();
		List<Faculty> faculty = new ArrayList<>();
		List<Student> students = new ArrayList<>();
		List<GeneralStaff> generalStuff = new ArrayList<>();

		Scanner sc = new Scanner(System.in);
		// String choice = sc.next();
		String name = "";
		String stored_User_choice = "";

		System.out.println(
				"Good afternoon! Welcome to the School Database! " + "\nDear User, introduce yourself please.");

		name = sc.nextLine();
     boolean isFinished=false;
		while (!isFinished) {
			displayMenu();
			String menuChoice = sc.nextLine();

			switch (menuChoice) {

			case "A": {
				System.out.println("You chose option A  < create a course >");
				System.out.println("Type parameters of the course, please");
				System.out.println(
						"1)isGraduate course?\n2)What is the course Number?\n3)What is the course Deparment\n4)What is the number of credits? ");
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
				}
				else { String[] parameters = userParameters.split(",");
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
				if  (userParameters.isEmpty()) {
					
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
				//display all faculties 
				for (Faculty faculties : faculty) {   ///FIXME not displaying 
					System.out.println(faculties);
				}
				
				
				System.out.println("Type the index faculty of your choice");
				String userFaculty = sc.nextLine();//cast to the faculty object
				for (Course course : courses) {
					System.out.println(course);
				}
				System.out.println("Type the  course of your choice");
				String userCourse = sc.nextLine(); //cast tot he course object
				
				userFaculty.addCourseTaught(userCourse); //aded course to the faculty 
				
				//faculties.get(userNumber).addCourse(courses.get(userNumberOfCourse);
				//user select the faculty
				//show all courses 
				//chose the course and add it to previously chose faculty 

				break;
			}
			case "F": {
				System.out.println("You chose option F < add course to a student object >");
				//display all courses 
				for (Course course : courses) {
					System.out.println(course);
				}
				
				
				System.out.println("Type the  faculty of your choice");
				//display all students 
				String userCourse1 = sc.nextLine(); //cast from string to the course object 
				for (Student studentss : students) {
					System.out.println(studentss);
				}
				System.out.println("Type the student  of your choice");
				String userStudent1 = sc.nextLine(); // cast from sting to the student object 
				userStudent1.addCourseTaken(userCourse1); //aded course to the student 
				break;
			}
			case "G": {
				System.out.println("You chose otpion G <  add an array of 2 courses to faculty object>");
				//display faculty object's courses
				//user chooses and saves index
				//methods that picks course at index which (user chose)
				
				break;
			}
			case "H": {
				System.out.println("You chose otpion G <  add an array of 2 course to student object >");
				break;
			}
			case "I": {
				System.out.println("get course of index from faculty object>");
				//Display faculty
				//Display courses
				//ask user to chose course at index
				//Save user index
				//faculty. getCourseTaught(int index)
				break;

			}
			case "J": {
				System.out.println("get course of index from student object>");
				//Display students
				//Display courses
				//ask user to chose course at index
				//Save user index
				//students. getCourseTaught(int index)
				break;

			}
			case "K": {
				System.out.println(" select a Faculty object and a Course object from menus and query the Faculty"
						+ " object for the Course to determine whether the Faculty object teaches it or not");
				break;

			}
			case "l": {
				System.out.println("Determine which Faculty object teaches the most and the least courses");
				break;
				//

			}
			case "m": {
				System.out.println("Determine which Course is the minimum of all Course objects in the catalog.");
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
		
		//write to the file
		
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

/*
 * (3 pts) Create 3 new Course objects based on input (3 pts) Create 3 new
 * Faculty objects based on input (3 pts) Create 3 new GeneralStaff objects
 * based on input (3 pts) Create 3 new Student objects based on input (2 pts)
 * Add 2 new Courses to a Faculty object (2 pts) Add 2 new Courses to a Student
 * object (1 pts) Add an array of 2 Courses to a Faculty object (1 pts) Add an
 * array of 2 Courses to a Student object (1 pts) Get the Course at index (valid
 * and invalid indexes) from a Faculty object (1 pts) Get the Course at index
 * (valid and invalid indexes) from a Student object (1 pts) Allow the user to
 * select a Faculty object and a Course object from menus and query the Faculty
 * object for the Course to determine whether the Faculty object teaches it or
 * not. (1 pts) Determine which Faculty object teaches the most and the least
 * courses. (1 pts) Determine which Course is the minimum of all Course objects
 * in the catalog. (1 pts) Determine which Course is the maximum of all Course
 * objects in the catalog. (1 pts) Determine which Student has the most and
 * least credits. (5 pts) Display all the Objects using toString on the console
 * (this includes existing plus recently added)
 * 
 */
