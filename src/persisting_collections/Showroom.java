package persisting_collections;

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
public class Showroom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int showroom_id;
	private String showroom_name;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "showroom_id", nullable = false)
	private List<Cars> cars;

	public Showroom() {
		
	}

	public Showroom(String showroom_name, List<Cars> cars) {
		this.showroom_name = showroom_name;
		this.cars = cars;
	}

	@Override
	public String toString() {
		return "Showroom [showroom_id=" + showroom_id + ", showroom_name=" + showroom_name + ", cars=" + cars + "]";
	}

	public int getShowroom_id() {
		return showroom_id;
	}

	public void setShowroom_id(int showroom_id) {
		this.showroom_id = showroom_id;
	}

	public String getShowroom_name() {
		return showroom_name;
	}

	public void setShowroom_name(String showroom_name) {
		this.showroom_name = showroom_name;
	}

	public List<Cars> getCars() {
		return cars;
	}

	public void setCars(List<Cars> cars) {
		this.cars = cars;
	}

}