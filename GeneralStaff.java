
public class GeneralStaff extends Employee{

	
	private String duty; 
	   public GeneralStaff()
	   {
	   this.duty="";
	   }
	   public GeneralStaff(String duty)
	   {
	   this.duty=duty;
	   }
	   public GeneralStaff(String deptName,String duty)
	   {
	   super(deptName);
	   this.duty=duty;
	   }
	   public GeneralStaff(String name,int birthYear,String deptName,String duty)
	   {
	   super(name,birthYear,deptName);
	   this.duty=duty;
	   }
	   public String getDuty()
	   {
	   return duty;
	   }
	   /*
	   public boolean equals(GeneralStaff obj1)
	   {
	   if(!duty.equals(obj1.duty))
	   {
	   return false;
	   }
	   else if(!deptName.equals(obj1.deptName))
	   {
	   return false;
	   }
	   else if(this.getBirthYear()!=obj1.getBirthYear())
	   {
	   return false;
	   }
	   else if(!obj1.getName().equals(this.getName()))
	   {
	   return false;
	   }
	   return true;
	   }
	   */
	   public String toString()
	   {
	   return super.toString() + String.format(" GeneralStaff: Duty: %10s",duty);
	   }
	   
	   }
	    