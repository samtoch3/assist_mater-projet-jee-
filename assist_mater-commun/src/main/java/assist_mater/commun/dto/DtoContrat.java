package assist_mater.commun.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;




@SuppressWarnings("serial")
public class DtoContrat implements Serializable {
    
    // Champs
    
    private int         id_contrat;
  
    private String lastname;
    private String firstname;
    private Date date_naiss;
    private Date date_deb;
    private Date date_fin;
    private BigDecimal tarif_horaire;
    private BigDecimal indemn_entretien;
    private BigDecimal indemn_repas;
	// Constructeurs
    
    public DtoContrat() {
		super();
	}
    public DtoContrat(int id_contrat, String lastname, String firstname, Date date_naiss, Date date_deb,
			Date date_fin, BigDecimal tarif_horaire, BigDecimal indemn_entretien, BigDecimal indemn_repas) {
		super();
		this.id_contrat = id_contrat;
		this.lastname = lastname;
		this.firstname = firstname;
		this.date_naiss = date_naiss;
		this.date_deb = date_deb;
		this.date_fin = date_fin;
		this.tarif_horaire = tarif_horaire;
		this.indemn_entretien = indemn_entretien;
		this.indemn_repas = indemn_repas;
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
	public BigDecimal getIndemn_entretien() {
		return indemn_entretien;
	}
	public void setIndemn_entretien(BigDecimal indemn_entretien) {
		this.indemn_entretien = indemn_entretien;
	}
	public BigDecimal getIndemn_repas() {
		return indemn_repas;
	}
	public void setIndemn_repas(BigDecimal indemn_repas) {
		this.indemn_repas = indemn_repas;
	}
	public void setId_contrat(int id_contrat) {
		this.id_contrat = id_contrat;
	}

	
	
	

    

}
