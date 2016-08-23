package CarRunner;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int address_id;

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public Address() {

	}

	public Address(String street, int zipcode) {
		this.street = street;
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Address [address_id=" + address_id + ", street=" + street + ", zipcode=" + zipcode + "]";
	}

	private String street;
	private int zipcode;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

}
