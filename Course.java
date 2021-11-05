
public class Course implements Comparable<Course> {

	   private boolean isGraduateCourse;
	   private int courseNum;
	   private String courseDept;
	   private int numCredits;
	  
	   public Course(boolean isGraduateCourse, int courseNum, String courseDept, int numCredits) {
	       this.isGraduateCourse=isGraduateCourse;
	       this.courseNum=courseNum;
	       this.courseDept=courseDept;
	       this.numCredits=numCredits;
	   }
	   public boolean isGraduateCourse() {
	       return this.isGraduateCourse;
	   }
	   public int getCourseNum() {
	       return courseNum;
	   }
	   public String getCourseDept() {
	       return courseDept;
	   }
	   public int getNumCredits() {
	       return numCredits;
	   }
	   public String getCourseName() {
	       if (this.isGraduateCourse == true) {
	           return "G" + this.courseDept + this.courseNum;
	       }
	       else {
	           return "U" + this.courseDept + this.courseNum;
	       }
	   }
	   public boolean equals(Object obj) {
	       Course other=(Course)obj;
	       if(this.isGraduateCourse!=other.isGraduateCourse) {
	           return false;
	       }
	       if(this.courseNum!=other.courseNum) {
	           return false;
	       }
	       if(this.courseDept!=other.courseDept) {
	           return false;
	       }
	       if(this.numCredits!=other.numCredits) {
	           return false;
	       }
	       else
	           return true;
	   }
	   public String toString() {
	       if(isGraduateCourse) {
	           return String.format("Course: %3s-%3d | Number of Credits: %02d | Graduate", courseDept,courseNum, numCredits, isGraduateCourse);
	       }
	       else {
	           return String.format("Course: %3s-%3d | Number of Credits: %02d | Undergraduate", courseDept, courseNum,numCredits,isGraduateCourse);
	       }
	   }
	   public int compareTo(Course c) {
	       if(courseNum==c.getCourseNum()) {
	           return 0;
	       }
	       else if(courseNum>=c.getCourseNum()){
	           return 1;
	       }
	       else {
	           return -1;
	       }
	   }
}