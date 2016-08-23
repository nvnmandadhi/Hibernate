package one_to_one;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Part {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int part_id;
	private String part_name;

	public Part(String part_name) {
		this.part_name = part_name;
	}

	public String getPart_name() {
		return part_name;
	}

	public void setPart_name(String part_name) {
		this.part_name = part_name;
	}

	public int getPart_id() {
		return part_id;
	}

	@Override
	public String toString() {
		return "Part [part_id=" + part_id + ", part_name=" + part_name + "]";
	}

}
