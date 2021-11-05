
public class Person implements Comparable <Person>{

	private String name;
	private  int birthYear;
	
	public  Person() {
		name = "";
		birthYear = 0; 
	}		
	public Person(String name, int birthYear) {
	  this.name = name;
	  this.birthYear = birthYear; 
	}
	String getName() {
		return this.name;
	}
	int getBirthYear() {
		return this.birthYear;
	}
	public void setName(String name) {
		this.name = name;
	}
	void setBirthYear(int year) {
		this.birthYear = year;
	} 
	

  
   public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return birthYear == person.birthYear &&
                name.equals(person.getName());
    }


    public String toString() {
        return String.format("Person: Name: %30s | Birth Year: %4d", name, birthYear);
    }

@Override 
   public int compareTo(Person o) {
        if (birthYear - o.birthYear == 0) return 0;
        else if (birthYear - o.birthYear < 0) return -1;
        else return 1;}
 

}
