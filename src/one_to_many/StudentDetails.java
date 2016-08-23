package one_to_many;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int student_id;
	private String name;

	public StudentDetails() {
	}

	public StudentDetails(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", name=" + name + "]";
	}

	public int getStudent_id() {
		return student_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
