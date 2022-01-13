package assist_mater.ejb.data;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;


@Entity
@Table( name = "userr" )
public class User  {

	
	// Champs

	@Id
	@GeneratedValue( strategy = IDENTITY)
	@Column( name = "id_user")
	private int			id_user;
	
	@Column( name = "lastname")
	private String		lastname;
	
	@Column( name = "firstname")
	private String		firstname;
	
	@Column( name = "login")
	private String		login;
	
	@Column( name = "password")
	private String		password;
	
	@Column( name = "adress")
	private String		adress;
	
	@Column( name = "phone")
	private String		phone;
	
	@ElementCollection( fetch = EAGER )
	@CollectionTable( name = "role", joinColumns = @JoinColumn( name = "id_user" ) )
	@Column( name = "role")
	private List<String> roles = new ArrayList<>();	
	
	
	// Constructeurs
	
	public User() {
	}

		
	public User(int id, String lastname, String firstname, String login, String password, String adress, String phone) {
		this.id_user = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.login = login;
		this.password = password;
		this.adress = adress;
		this.phone = phone;
		
	}


	// Getters & setters
	
	public int getId_user() {
		return id_user;
	}


	public void setId_user(int id) {
		this.id_user = id;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAdress() {
		return adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public List<String> getRoles() {
		return roles;
	}


	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

    
	// equals() et hashcode()

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_user;
		return result;
	}

	


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id_user != other.id_user)
			return false;
		return true;
	}
	
}
