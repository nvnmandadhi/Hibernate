package CarRunner;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int car_id;
	private String car_name;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "engine_id")
	private Engine engine;

	public Car() {

	}

	public Car(String car_name, Engine engine) {
		this.car_name = car_name;
		this.engine = engine;
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

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	@Override
	public String toString() {
		return "Car [car_id=" + car_id + ", car_name=" + car_name + ", engine=" + engine + "]";
	}

}
