package persisting_collections;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cars {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int car_id;
	private String car_name;

	public Cars() {
	}

	public Cars(String car_name) {
		super();
		this.car_name = car_name;
	}

	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public String getCar_name() {
		return car_name;
	}

	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}

	@Override
	public String toString() {
		return "Cars [car_id=" + car_id + ", car_name=" + car_name + "]";
	}

}
