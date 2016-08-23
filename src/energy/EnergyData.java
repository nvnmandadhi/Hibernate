package energy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EnergyData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double temperature;
	private double moisture;
	private double natural_gas;
	private double diesel;
	private double light_fuel_oil;

	public EnergyData(double temperature, double moisture, double natural_gas, double diesel, double light_fuel_oil) {
		this.temperature = temperature;
		this.moisture = moisture;
		this.natural_gas = natural_gas;
		this.diesel = diesel;
		this.light_fuel_oil = light_fuel_oil;
	}

	public EnergyData() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getMoisture() {
		return moisture;
	}

	public void setMoisture(double moisture) {
		this.moisture = moisture;
	}

	public double getNatural_gas() {
		return natural_gas;
	}

	public void setNatural_gas(double natural_gas) {
		this.natural_gas = natural_gas;
	}

	public double getDiesel() {
		return diesel;
	}

	public void setDiesel(double diesel) {
		this.diesel = diesel;
	}

	public double getLight_fuel_oil() {
		return light_fuel_oil;
	}

	public void setLight_fuel_oil(double light_fuel_oil) {
		this.light_fuel_oil = light_fuel_oil;
	}

}
