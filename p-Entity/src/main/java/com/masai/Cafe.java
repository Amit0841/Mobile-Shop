package com.masai;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Cafe {
@Id
	private int id;
	private String name;
	private String rating;
	private double peice;
	private LocalDate DateOfOpen;
	public Cafe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cafe(int id, String name, String rating, double peice, LocalDate dateOfOpen) {
		super();
		this.id = id;
		this.name = name;
		this.rating = rating;
		this.peice = peice;
		DateOfOpen = dateOfOpen;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public double getPeice() {
		return peice;
	}
	public void setPeice(double peice) {
		this.peice = peice;
	}
	public LocalDate getDateOfOpen() {
		return DateOfOpen;
	}
	public void setDateOfOpen(LocalDate dateOfOpen) {
		DateOfOpen = dateOfOpen;
	}
	@Override
	public String toString() {
		return "Cafe [id=" + id + ", name=" + name + ", rating=" + rating + ", peice=" + peice + ", DateOfOpen="
				+ DateOfOpen + "]";
	}
	
	
}
