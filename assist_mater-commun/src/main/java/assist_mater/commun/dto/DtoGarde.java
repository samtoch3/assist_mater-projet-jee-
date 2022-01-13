package assist_mater.commun.dto;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;



@SuppressWarnings("serial")
public class DtoGarde implements Serializable {
	
	
	// Champs
	
	private int				id_garde;
	
	private Date date_garde;
	
	private Time heure_deb;
	
	private Time heure_fin;
	
	private boolean isRepasPris;
	
	// Constructeurs
	
	public DtoGarde() {
	}
	public DtoGarde(int id_garde, Date date_garde, Time heure_deb, Time heure_fin, boolean isRepasPris) {
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






}
