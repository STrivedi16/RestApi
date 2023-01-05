package CRUDUsers.Users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.SQLDelete;

@Entity // --For the table creation

//@Where(clause = "is_active=true")
@SQLDelete(sql = "UPDATE users SET is_active=false WHERE id=?") // -- For override the delete query
//@FilterDef(name = "deletedproductfilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
//@Filter(name = "deletedproductfilter", condition = "is_active = :isDeleted ")
public class Users {

	@Id // To generate primary key on table
	@GeneratedValue(strategy = GenerationType.AUTO) // to add auto increment
	private int id;
	private String name;
	private String city;
	private String email;
	@Column(name = "is_active") // To Set the column name as is_active
	private boolean active = true;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(int id, String name, String city, String email, boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.email = email;
		this.active = active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isActive() {
		return active;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
