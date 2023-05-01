package practice;

import jakarta.persistence.*;
@Entity
public class Student extends Human{
@GeneratedValue(strategy = GenerationType.AUTO)
private int stuId;
private String coourse;
private int marks;

public Student() {
	super();
	// TODO Auto-generated constructor stub
}

public Student(String name, int age, String coourse, int marks) {
	super(name, age);
	this.coourse = coourse;
	this.marks = marks;
}

public int getStuId() {
	return stuId;
}
public void setStuId(int stuId) {
	this.stuId = stuId;
}
public String getCoourse() {
	return coourse;
}
public void setCoourse(String coourse) {
	this.coourse = coourse;
}
public int getMarks() {
	return marks;
}
public void setMarks(int marks) {
	this.marks = marks;
}
@Override
public String toString() {
	return "Student [stuId=" + stuId + ", coourse=" + coourse + ", marks=" + marks + "]";
}
}