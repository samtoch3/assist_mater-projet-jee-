package assist_mater.ejb.data;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "categorie" )
public class Garde {
    
	
    // Champs
    
	@Id
	@GeneratedValue( strategy = IDENTITY )
	@Column( name = "id_garde" )
    private int         	id_garde;
    
	@Column( name = "date_garde" )
    private Date      	date_garde;
	
	@Column( name = "heure_deb" )
    private Date      	heure_deb;
	
	@Column( name = "heure_fin" )
    private Date      	heure_fin;
	
	@Column( name = "isrepaspris" )
    private boolean      	isRepasPris;
	
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name = "id_contrat" )
	private Contrat enfant;
	
	// Constructeurs

	public Garde() {
		
	}
    
    
    
    
    public Garde(int id_garde, Date date_garde, Date heure_deb, Date heure_fin, boolean isRepasPris) {
		this.id_garde = id_garde;
		this.date_garde = date_garde;
		this.heure_deb = heure_deb;
		this.heure_fin = heure_fin;
		this.isRepasPris = isRepasPris;
	}




	// Getters & setters

   
    public int getId_garde() {
		return id_garde;
	}


	public void setId_garde(int id_garde) {
		this.id_garde = id_garde;
	}


	public Date getDate_garde() {
		return date_garde;
	}


	public void setDate_garde(Date date_garde) {
		this.date_garde = date_garde;
	}


	public Date getHeure_deb() {
		return heure_deb;
	}


	public void setHeure_deb(Date heure_deb) {
		this.heure_deb = heure_deb;
	}


	public Date getHeure_fin() {
		return heure_fin;
	}


	public void setHeure_fin(Date heure_fin) {
		this.heure_fin = heure_fin;
	}


	public boolean isRepasPris() {
		return isRepasPris;
	}


	public void setRepasPris(boolean isRepasPris) {
		this.isRepasPris = isRepasPris;
	}


	// hashcode() & equals()

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_garde;
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
		Garde other = (Garde) obj;
		if (id_garde != other.id_garde)
			return false;
		return true;
	}
    
}
