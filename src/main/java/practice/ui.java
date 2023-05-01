package practice;

import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class ui {
static EntityManagerFactory emf;

static {
	emf=Persistence.createEntityManagerFactory("myname");
}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = -1;
		do {
			System.out.println("0. Exit");
			System.out.println("1. Add Student");
			System.out.println("2. View Student by Id");
			System.out.println("3. Update Student");
			System.out.println("4. Delete Student");
			System.out.print("Enter Selection ");
			
			choice = sc.nextInt();
			switch(choice) {
				case 0:
					System.out.print("Thanks for using our services");
					break;
				case 1:
					addStudentUI(sc);
					break;
				case 2:
					viewStudentUI(sc);
					break;
		
				default:
					System.out.print("Invalid Selection, try again");
			}
			
		}while(choice != 0);
		sc.close();
		}

	private static void viewStudentUI(Scanner sc) {
		EntityManager em=emf.createEntityManager();
		Query que= em.createNamedQuery("print");
     List <Human> list=que.getResultList();
   list.forEach(System.out::println);

	}

	private static void addStudentUI(Scanner sc) {
		EntityManager em=emf.createEntityManager();
		String name=sc.next();
		int AnnualIncome=sc.nextInt();
		String post=sc.next();
		
		Employee a=new Employee(name,20,post,AnnualIncome);
		EntityTransaction et=em.getTransaction();

		et.begin();
		
		em.persist(a);
		et.commit();
		em.close();
		
	}
	

	
}
