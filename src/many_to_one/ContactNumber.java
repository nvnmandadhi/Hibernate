package many_to_one;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ContactNumber {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String number;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ContactNumber() {
	}

	public ContactNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return number;
	}

	public void setName(String number) {
		this.number = number;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "ContactNumber [id=" + id + ", name=" + number + "]";
	}

}
