package assist_mater.jsf.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
public class User implements Serializable {

	// Champs

	Integer id_user;

	@NotBlank(message = "Le nom doit être renseigné")
	@Size(max = 25, message = "Valeur trop longue pour le nom : 25 car. maxi")
	private String lastname;

	@NotBlank(message = "Le prénom doit être renseigné")
	@Size(max = 25, message = "Valeur trop longue pour le prénom : 25 car. maxi")
	private String firstname;

	@NotBlank(message = "L'adresse e-mail doit être renseigné")
	@Size(max = 100, message = "Valeur trop longue pour l'adresse e-mail : 100 car. maxi")
	@Email(message = "Adresse e-mail invalide")
	private String login;

	@NotBlank(message = "Le mot de passe doit être renseigné")
	@Size(max = 25, message = "Valeur trop longue pour le mot de passe : 25 car. maxi")
	private String password;

	@NotBlank(message = "L'adresse doit être renseigné")
	@Size(max = 100, message = "Valeur trop longue pour l'addresse : 100 car. maxi")
	private String adress;
	
	
	@NotBlank( message = "Le numéro de téléphone doit être renseigné")
	@Size(max=25, message = "Valeur trop longue pour le numéro de téléphone : 25 car. maxi" )
	private String			numero;
	
	
	

	private List<String> roles = new ArrayList<>();
	
	// Constructeurs

	public User() {
	}

	public User(Integer id_user, String lastname, String firstname, String login, String password, String adress,String numero,
			List<String> roles) {
		super();
		this.id_user = id_user;
		this.lastname = lastname;
		this.firstname = firstname;
		this.login = login;
		this.password = password;
		this.adress = adress;
		this.numero = numero;
		this.roles = roles;
	}

	public boolean isInRole( String role ) {
		return roles.contains( role );
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

	// hashCode() & equals()

	
	
	@Override
	public int hashCode() {
		return Objects.hash(id_user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		var other = (User) obj;
		return Objects.equals(id_user, other.id_user);
	}

}
