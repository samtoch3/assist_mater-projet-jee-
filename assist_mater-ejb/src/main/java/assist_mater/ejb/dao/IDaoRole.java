package assist_mater.ejb.dao;

import java.util.List;

import assist_mater.ejb.data.Compte;


public interface IDaoRole {

	void insererPourCompte( Compte compte );

	void modifierPourCompte( Compte compte );

	void supprimerPourCompte( int idCompte );

	List<String> listerPourCompte( Compte compte );

}
