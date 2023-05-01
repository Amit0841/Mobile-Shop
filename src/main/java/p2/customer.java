 package p2;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity

public class customer {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String name;
private double annualIncome;
@Embedded
@ElementCollection(fetch = FetchType.EAGER)
private List<Address> list =new ArrayList();


public customer(String name, double annualIncome, List<Address> list) {
	super();
	this.name = name;
	this.annualIncome = annualIncome;
	this.list = list;
}



public List<Address> getList() {
	return list;
}



public void setList(List<Address> list) {
	this.list = list;
}



public customer() {
	super();
	// TODO Auto-generated constructor stub
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

public double getAnnualIncome() {
	return annualIncome;
}

public void setAnnualIncome(double annualIncome) {
	this.annualIncome = annualIncome;
}

@Override
public String toString() {
	return "customer [id=" + id + ", name=" + name + ", annualIncome=" + annualIncome + ", list=" + list + "]";
}

}
