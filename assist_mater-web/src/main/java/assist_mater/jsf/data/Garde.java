package assist_mater.jsf.data;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import java.util.Objects;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@SuppressWarnings("serial")
public class Garde implements Serializable {

	// Champs

	private Integer id_garde;

	@NotBlank(message = "La date de garde doit etre renseignée ")
	@Future(message = "La date de naissance ne peut pas etre une date du passé")
	private Date date_garde;

	@NotNull(message = "Les horaires sont obligatoires")
	private Time heure_deb;

	@NotNull(message = "Les horaires sont obligatoires")
	private Time heure_fin;

	@NotNull(message = " Case obligatoire a cocher")
	private boolean isRepasPris;

	// Constructeurs

	public Garde() {
	}

	public Garde(Integer id_garde, Date date_garde, Time heure_deb, Time heure_fin, boolean isRepasPris) {
		super();
		this.id_garde = id_garde;
		this.date_garde = date_garde;
		this.heure_deb = heure_deb;
		this.heure_fin = heure_fin;
		this.isRepasPris = isRepasPris;
	}

	// Getters & setters
	
	public Integer getId_garde() {
		return id_garde;
	}

	public void setId_garde(Integer id_garde) {
		this.id_garde = id_garde;
	}

	public Date getDate_garde() {
		return date_garde;
	}

	public void setDate_garde(Date date_garde) {
		this.date_garde = date_garde;
	}

	public Time getHeure_deb() {
		return heure_deb;
	}

	public void setHeure_deb(Time heure_deb) {
		this.heure_deb = heure_deb;
	}

	public Time getHeure_fin() {
		return heure_fin;
	}

	public void setHeure_fin(Time heure_fin) {
		this.heure_fin = heure_fin;
	}

	public boolean isRepasPris() {
		return isRepasPris;
	}

	public void setRepasPris(boolean isRepasPris) {
		this.isRepasPris = isRepasPris;
	}


	// hashCode() & equals()
	@Override
	public int hashCode() {
		return Objects.hash(id_garde);
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		var other = (Garde) obj;
		return Objects.equals(id_garde, other.id_garde);
	}

}
