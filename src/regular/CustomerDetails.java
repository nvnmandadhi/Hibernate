package regular;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class CustomerDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customer_id;
	private String customerName;
	private String contactName;
	private String address;
	private String city;
	private String postalCode;
	private String country;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "customer_id")
	private List<OrderDetails> order;

	public CustomerDetails() {
	}

	public List<OrderDetails> getOrder() {
		return order;
	}

	public void setOrder(List<OrderDetails> order) {
		this.order = order;
	}

	public CustomerDetails(String customerName, String contactName, String address, String city, String postalCode,
			String country, List<OrderDetails> order) {
		this.customerName = customerName;
		this.contactName = contactName;
		this.address = address;
		this.city = city;
		this.postalCode = postalCode;
		this.country = country;
		this.order = order;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	@Override
	public String toString() {
		return "Customers [customer_id=" + customer_id + ", customerName=" + customerName + ", contactName="
				+ contactName + ", address=" + address + ", city=" + city + ", postalCode=" + postalCode + ", country="
				+ country + ", order=" + order + "]";
	}

}
