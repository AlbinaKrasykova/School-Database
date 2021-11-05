
public class Employee extends Person  {
	   private String deptName;
	   private static int numEmployees;
	   private int employeeID;
	  
	   public Employee() {
	       super("",0);
	       deptName="";
	       employeeID=++numEmployees;
	   }
	   public Employee(String deptName) {
	       super("",0);
	       this.deptName=deptName;
	       this.employeeID=++numEmployees;
	   }
	   public Employee(String name, int birthYear, String deptName) {
	       super(name,birthYear);
	       this.deptName=deptName;
	       this.employeeID=++numEmployees;
	   }
	   public String getDeptName() {
	       return deptName;
	   }
	   public static int getNumEmployees() {
	       return numEmployees;
	   }
	   public int getEmployeeID() {
	       return employeeID;
	   }
	   public void setDeptName(String deptName) {
	       this.deptName=deptName;
	   }
	
       @Override 
	   public boolean equals(Object obj) {
		   if (obj == null){ return false;}
		   if (this == obj){ return true;}
	       if(obj instanceof Employee) {
	           Employee otherEmployee = (Employee)obj;
	           if( (this.getName().contentEquals(otherEmployee.getName()) )
	           && (this.getBirthYear() == otherEmployee.getBirthYear())
	           && (this.getDeptName().contentEquals(otherEmployee.getDeptName()))
	           && (this.getEmployeeID() == otherEmployee.getEmployeeID())) {
	              
	               return true;          
	           }
	       }
	       return false;
	   }
	   public String toString() {
	       return String.format(super.toString()+" Employee: Department: %20s | Employee Number: %3d", deptName,employeeID);
	   }
	   public int compareTo(Employee c) {
	       return this.employeeID-c.employeeID;
	   }

}
