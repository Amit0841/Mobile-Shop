package p2;

import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
	private String city;
	private String state;
	private int zipcode;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String city, String state, int zipcode) {
		super();
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + ", zipcode=" + zipcode + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(city, state, zipcode);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(city, other.city) && Objects.equals(state, other.state) && zipcode == other.zipcode;
	}
	
}
