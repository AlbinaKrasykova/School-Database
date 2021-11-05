
public class Student extends Person {
	  private static int numStudents = 0;
	   private int studentID;
	   private Course[] coursesTaken;
	   private int numCoursesTaken;
	   private boolean isGraduate;
	   private String major;

	   public Student() {
	       super();
	       numStudents += 1;
	       this.coursesTaken = new Course[50];
	       this.numCoursesTaken = 0;
	       this.isGraduate = false;
	       this.major = "undeclared";
	       studentID = numStudents;
	   }

	   public Student(boolean isGraduate) {
	       super();
	       numStudents += 1;
	       this.coursesTaken = new Course[50];
	       this.numCoursesTaken = 0;
	       this.isGraduate = isGraduate;
	       this.major = "undeclared";
	       studentID = numStudents;
	   }

	   public Student(String major, boolean isGraduate) {
	       super();
	       numStudents += 1;
	       this.coursesTaken = new Course[50];
	       this.numCoursesTaken = 0;
	       this.isGraduate = isGraduate;
	       this.major = major;
	       studentID = numStudents;
	   }

	   public Student(String name, int birthYear, String major, boolean isGraduate) {
	       super(name, birthYear);
	       numStudents += 1;
	       this.coursesTaken = new Course[50];
	       this.numCoursesTaken = 0;
	       this.isGraduate = isGraduate;
	       this.major = major;
	       studentID = numStudents;
	   }

	   public boolean isGraduate() {
	       return isGraduate;
	   }

	   public void setGraduate(boolean isGraduate) {
	       this.isGraduate = isGraduate;
	   }

	   public int getNumCoursesTaken() {
	       return numCoursesTaken;
	   }

	   public static int getNumStudents() {
	       return numStudents;
	   }

	   public int getStudentID() {
	       return studentID;
	   }

	   public String getMajor() {
	       return major;
	   }

	   public void setMajor(String major) {
	       this.major = major;
	   }

	   public void addCourseTaken(Course course) {
		   if(numCoursesTaken < coursesTaken.length) {
			   coursesTaken[numCoursesTaken] = course;
	           numCoursesTaken +=1;
	       }
	   }
	   
	   public void addCoursesTaken(Course[] courses) {
		  
		  
			   for(int i =0; i< courses.length;i++) {
				   addCourseTaken(courses[i]);
               }
		       
	   }

	   
	   
	   

	   public Course getCourseTaken(int i) {

		   if (i >= 0 && i < numCoursesTaken) {
               return coursesTaken[i];
       }
       else {
               return null;
	   }
	   }
	   public String getCourseTakenAsString(int i) {

	       if ((i >= numCoursesTaken) || (i < 0))
	           return "";
	       else

	           return coursesTaken[i].getCourseDept() + "-" + coursesTaken[i].getCourseNum();

	   }

	   public String getAllCoursesTakenAsString() {
	       String output = "";
	       for (int i = 0; i < numCoursesTaken; i++) {
	           if (i == 0) {
	               output = getCourseTakenAsString(i);
	           } else {
	               output = output + ", " + getCourseTakenAsString(i);
	           }
	       }
	       return output;
	   }

	   @Override
	   public boolean equals(Object obj) {
	       Student s = (Student) obj;

	       if (this.getNumCoursesTaken() != s.getNumCoursesTaken()) {
	           return false;
	       }
	       if (this.getStudentID() != s.getStudentID()) {
	           return false;
	       }
	       if (this.getMajor() != s.getMajor()) {
	           return false;
	       }
	       if (this.isGraduate() != s.isGraduate()) {
	           return false;
	       }
	       if (this.getName() != s.getName()) {
	           return false;
	       }
	       if (this.getBirthYear() != s.getBirthYear()) {
	           return false;
	       }
	       return true;
	   }

	   @Override
	   public String toString() {
	       String graduateStatus = "";
	       if (isGraduate) {
	           graduateStatus = "Graduate";
	       } else {
	           graduateStatus = "Undergraduate";
	       }
	       String output = super.toString() + " ";
	       output = output + String.format(
	               "Student: studentID: %04d | Major %20s | %14s | Number of Courses Taken: %3d | Courses Taken: %s",
	               studentID, major, graduateStatus, numCoursesTaken, getAllCoursesTakenAsString());
	       return output;
	   }

	   public int compareTo(Student c) {
	       return this.studentID - c.studentID;
	   }
	}

