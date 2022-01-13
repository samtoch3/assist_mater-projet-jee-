package assist_mater.commun.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("serial")
public class DtoUser implements Serializable  {

	
	// Champs
	
	private int			id_user;
	
	private String lastname;
	
	private String firstname;
	
	private String login;
	
	private String password;
	
	private List<String> roles = new ArrayList<>();
	
	private String adress;
	
	private String	numero;
	
	// Constructeurs
	
	public DtoUser() {
	}
	
	public DtoUser(int id_user, String lastname, String firstname, String login, String password, List<String> roles,
			String adress, String numero) {
		super();
		this.id_user = id_user;
		this.lastname = lastname;
		this.firstname = firstname;
		this.login = login;
		this.password = password;
		this.roles = roles;
		this.adress = adress;
		this.numero = numero;
	}




	// Getters & setters

	public Integer getId_user() {
		return id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
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

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	
	public boolean isInRole( String role ) {
		
		if ( role != null ) {
			for ( String r : roles ) {
				if ( r.equals(role) ) {
					return true;
				}
			}
		}
		return false;
	}
}
