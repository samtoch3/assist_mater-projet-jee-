package assist_mater.jsf.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
public class Contrat implements Serializable {

	// Champs

	private Integer id_contrat;

	@NotBlank(message = "Le nom doit être renseigné")
	@Size(max = 25, message = "Valeur trop longue pour le nom : 25 car. maxi")
	private String lastname;

	@NotBlank(message = "Le prénom doit être renseigné")
	@Size(max = 25, message = "Valeur trop longue pour le prénom : 25 car. maxi")
	private String firstname;

	@NotBlank(message = "La date doit etre renseignée ")
	@Past(message = "La date de naissance ne peut pas etre une date du futur")
	private Date date_naiss;

	@NotBlank(message = "La date doit etre renseignée ")
	@FutureOrPresent(message = "La date de début ne peut pas etre une date du passé")
	private Date date_deb;

	@NotBlank(message = "La date doit etre renseignée ")
	@Future(message = "La date de fin ne peut pas etre une date du passé ou présent")
	private Date date_fin;

	@NotNull
	@Min(value = 0, message = "Le prix ne doit pas etre inférieur a 0 ")
	private BigDecimal tarif_horaire;
	
	@NotNull
	@Min(value = 0, message = "Le prix ne doit pas etre inférieur a 0 ")
	private BigDecimal indemn_entretien;
	
	@NotNull
	@Min(value = 0, message = "Le prix ne doit pas etre inférieur a 0 ")
	private BigDecimal indemn_repas;
	
	private User parent;
	
	

	// Constructeurs

	public Contrat() {
	}

	public Contrat(Integer id_contrat, String lastname, String firstname, Date date_naiss, Date date_deb, Date date_fin,
			BigDecimal tarif_horaire,User parent ) {
		super();
		this.id_contrat = id_contrat;
		this.lastname = lastname;
		this.firstname = firstname;
		this.date_naiss = date_naiss;
		this.date_deb = date_deb;
		this.date_fin = date_fin;
		this.tarif_horaire = tarif_horaire;
		this.parent =parent;
		
	}

	// Getters & setters

	public Integer getId_contrat() {
		return id_contrat;
	}

	public void setId_user(Integer id_contrat) {
		this.id_contrat = id_contrat;
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

	public Date getDate_naiss() {
		return date_naiss;
	}

	public void setDate_naiss(Date date_naiss) {
		this.date_naiss = date_naiss;
	}

	public Date getDate_deb() {
		return date_deb;
	}

	public void setDate_deb(Date date_deb) {
		this.date_deb = date_deb;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public BigDecimal getTarif_horaire() {
		return tarif_horaire;
	}

	public void setTarif_horaire(BigDecimal tarif_horaire) {
		this.tarif_horaire = tarif_horaire;
	}

	public User getParent() {
		return parent;
	}

	public void setParent(User parent) {
		this.parent = parent;
	}
	

	// toString()

	

	@Override
	public String toString() {
		return lastname + " "+ firstname;
	}

	// hashCode() & equals()

	@Override
	public int hashCode() {
		return Objects.hash(id_contrat);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		var other = (Contrat) obj;
		return Objects.equals(id_contrat, other.id_contrat);
	}

}
