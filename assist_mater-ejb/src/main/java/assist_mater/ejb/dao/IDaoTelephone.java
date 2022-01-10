package assist_mater.ejb.dao;

import java.util.List;

import assist_mater.ejb.data.Personne;
import assist_mater.ejb.data.Telephone;


public interface IDaoTelephone {

	void insererPourPersonne(Personne personne);

	void modifierPourPersonne(Personne personne);

	void supprimerPourPersonne(int idPersonne);

	List<Telephone> listerPourPersonne( Personne personne );

}
