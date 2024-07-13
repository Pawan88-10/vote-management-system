package entity.classes;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Entity
@DynamicInsert
public class User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "your_sequence_generator")
	@SequenceGenerator(name = "your_sequence_generator", sequenceName = "your_sequence_name", allocationSize = 1, initialValue = 1)
	private int id;
	private String name;
	private String email;
	private String password;
	
	//voter card data
	private String address;
	private int age;
	private String gender;
	private String fatherName;
	private String motherName;
	private String date;

	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
 

	

	public User(String name, String email, String password, String address, int age, String gender,
			String fatherName, String motherName, String date) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.age = age;
		this.gender = gender;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.date = date;
	}


	public User(String name2, String email2, String password2) {
		this.name = name2;
		this.email = email2;
		this.password = password2;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getFatherName() {
		return fatherName;
	}


	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}


	public String getMotherName() {
		return motherName;
	}


	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}




	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", address="
				+ address + ", age=" + age + ", gender=" + gender + ", fatherName=" + fatherName + ", motherName="
				+ motherName + ", date=" + date + "]";
	}


}