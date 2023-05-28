package com.masai;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
	static EntityManagerFactory emf;
	
	static {
		emf=Persistence.createEntityManagerFactory("amit");
	}
public static void main(String[] args) {
	addCafe();
	
}
private static void addCafe() {
	
	Cafe c=new Cafe(2,"b","c",4.3,LocalDate.parse( "2023-06-02"));
	addD(c);
	
}
private static void addD(Cafe c) {
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	et.begin();
	em.persist(c);
	et.commit();
	em.close();
	
}
}
