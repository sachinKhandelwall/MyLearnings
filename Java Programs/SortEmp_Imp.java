import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Employee{
	
	String name;
	int salary;

	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + "]";
	}
}


public class SortEmp_Imp {
	public static void main(String[] args) {
		
		List<Employee> list = new ArrayList<Employee>();
		
		Employee e1 = new Employee("Sachin", 1300);
		Employee e2 = new Employee("RRR", 100);
		Employee e3 = new Employee("AAA", 130);
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		Collections.sort(list, (o1, o2) -> o1.getSalary() - o2.getSalary());
		System.out.println(list);
		
		
		
		

	}
	
	

}
