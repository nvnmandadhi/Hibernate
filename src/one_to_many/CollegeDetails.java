package one_to_many;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class CollegeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int college_id;
	private String college_name;

	@OneToMany(targetEntity = StudentDetails.class, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "college_id")
	private List<StudentDetails> students;

	public CollegeDetails(String college_name, List<StudentDetails> students) {
		this.college_name = college_name;
		this.students = students;
	}

	public CollegeDetails() {
	}

	public int getCollege_id() {
		return college_id;
	}

	public String getCollege_name() {
		return college_name;
	}

	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}

	public List<StudentDetails> getStudents() {
		return students;
	}

	public void setStudents(List<StudentDetails> students) {
		this.students = students;
	}

}
