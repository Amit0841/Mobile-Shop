package practice;

import jakarta.persistence.*;

@Entity
public class Employee extends Human{
@GeneratedValue(strategy = GenerationType.AUTO)
private int empId;
private String companyName;
private int salary;

public Employee(){
	super();
	// TODO Auto-generated constructor stub
}

public Employee(String name, int age, String companyName, int salary) {
	super(name, age);
	this.companyName = companyName;
	this.salary = salary;
}

public int getEmpId() {
	return empId;
}

public void setEmpId(int empId) {
	this.empId = empId;
}

public String getCompanyName() {
	return companyName;
}

public void setCompanyName(String companyName) {
	this.companyName = companyName;
}

public int getSalary() {
	return salary;
}

public void setSalary(int salary) {
	this.salary = salary;
}

@Override
public String toString() {
	return "Employee [empId=" + empId + ", companyName=" + companyName + ", salary=" + salary + "]";
}

}
