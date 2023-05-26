package com.masai;
import java.util.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
public class Main {
	static EntityManagerFactory emf;
	static{
		emf=Persistence.createEntityManagerFactory("emp_connect");
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {

			System.out.println("1. Add Employee");
			System.out.println("2. update Employee");
			System.out.println("3. delete employee");
			System.out.println("4. show employee");
			System.out.println("0.  exit from sysytem");
			System.out.println("enter the preferance");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				AddEmployee(sc);
				break;
			case 2:
				updateEmp(sc);
				break;
			case 3:
				deleteEmployee(sc);
				break;
			case 4:
				viewEmployee(sc);
				break;
			case 0:
				System.out.println("Thanks you visist again");
				break;
			default:
				System.out.println("Invalid selection");
			}

		} while (choice != 0);
		sc.close();
	}


private static void viewEmployee(Scanner sc) {
	System.out.println("enter Id");
	int id=sc.nextInt();
		view(id);
		
	}


private static void view(int id) {
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	Employee e= em.find(Employee.class, id);
	if(e!=null) {
		System.out.println("Id : "+ e.getEmpid()+", name : "+e.getName()+", Salary : "+e.getSalary());
	}else {
		System.out.println( "Id not Exists");
	}
	em.close();
}


private static void deleteEmployee(Scanner sc) {
	System.out.println("enter Id");
	int id=sc.nextInt();
		del(id);
	}


private static void del(int id) {
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	Employee e=em.find(Employee.class, id);
	if(e!=null) {
		et.begin();
		em.remove(e);
		et.commit();
	}else {
		System.out.println("Employye id not exists");
	}
	em.close();
}


private static void updateEmp(Scanner sc) {
		System.out.println("enter Id");
		int id=sc.nextInt();
		System.out.println("enter salary");
		double salary=sc.nextDouble();
		updateES(id,salary);
	}


private static void updateES(int id, double salary) {
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	Employee e=em.find(Employee.class, id);
	if(e!=null) {
		et.begin();
		e.setSalary(salary);
		et.commit();
		System.out.println("Update Sucess");
	}else {
		System.out.println("Employee id not exists");
	}
	em.close();
	
}


private static void AddEmployee(Scanner sc) {
	System.out.println("Enetr your EmployeeId ");
	int id = sc.nextInt();
	System.out.println("Enetr your Name");
	String name = sc.next();
	System.out.println("Enetr your Salary");
	double sl = sc.nextDouble();

	Employee e1 = new Employee(id, name, sl);
	AddEmp(e1);
}

private static void AddEmp(Employee e) {
	EntityManager em= emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	try {
	et.begin();
	em.persist(e);
	et.commit();
	System.out.println("Employee added");
	}catch(PersistenceException a) {
		System.out.println(a);
	}
	finally {
		em.close();
	}
	
	
}
}
