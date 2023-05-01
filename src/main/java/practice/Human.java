package practice;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "print", query = "select e from Employee e")
public class Human {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String  name;
private int  age;
public Human() {
	super();
	// TODO Auto-generated constructor stub
}
public Human(String name, int age) {
	super();
	this.name = name;
	this.age = age;
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
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
@Override
public String toString() {
	return "Human [id=" + id + ", name=" + name + ", age=" + age + "]";
}
}
