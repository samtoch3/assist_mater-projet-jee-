package assist_mater.ejb.data;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table( name = "contrat"  )
public class Contrat {
	
	
	// Champs
	
	@Id
	@GeneratedValue( strategy = IDENTITY )
	@Column( name = "id_contrat" )
	private int				id_contrat;
	
	@Column( name = "lastname" )
	private String			lastname;
	
	@Column( name = "firstname" )
	private String			firstname;
	
	@Column( name = "date_naiss" )
	private Date			date_naiss;
	
	@Column( name = "date_deb" )
	private Date			date_deb;
	
	@Column( name = "date_fin" )
	private Date			date_fin;
	
	@Column( name = "tarif_horaire" )
	private Float			tarif_horaire;
	
	@Column( name = "indemn_repas" )
	private Float		indemn_repas;
	
	@Column( name = "indemn_entretien" )
	private Float			indemn_entretien;
	
	
	/*@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name = "idcategorie" )
	private Categorie		categorie;

	@OneToMany( mappedBy = "personne", cascade = ALL, orphanRemoval = true  )
	@OrderBy( "libelle" )
	private List<Telephone>	telephones = new ArrayList<>();
	*/
	
	// Constructeurs
	
	public Contrat() {
	}

	
	
	
	public Contrat(int id_contrat, String lastname, String firstname, Date date_naiss, Date date_deb, Date date_fin) {
		this.id_contrat = id_contrat;
		this.lastname = lastname;
		this.firstname = firstname;
		this.date_naiss = date_naiss;
		this.date_deb = date_deb;
		this.date_fin = date_fin;
	}




	// Getters & setters

	

	
	// Actions
	
	public int getId_contrat() {
		return id_contrat;
	}




	public void setId_contrat(int id_contrat) {
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




	public Float getTarif_horaire() {
		return tarif_horaire;
	}




	public void setTarif_horaire(Float tarif_horaire) {
		this.tarif_horaire = tarif_horaire;
	}




	public Float getIndemn_repas() {
		return indemn_repas;
	}




	public void setIndemn_repas(Float indemn_repas) {
		this.indemn_repas = indemn_repas;
	}




	public Float getIndemn_entretien() {
		return indemn_entretien;
	}




	public void setIndemn_entretien(Float indemn_entretien) {
		this.indemn_entretien = indemn_entretien;
	}

	
	// hashcode() + equals()
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_contrat;
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
		Contrat other = (Contrat) obj;
		if (id_contrat != other.id_contrat)
			return false;
		return true;
	}
	

}
