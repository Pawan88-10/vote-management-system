package entity.classes;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Admin{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String password;
	
	@OneToOne
	private User user;
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", password=" + password + ", user=" + user + "]";
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public int getId() {
		return id;
	}

	public Admin(String name, String password, User user) {
		super();
		this.name = name;
		this.password = password;
		this.user = user;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}