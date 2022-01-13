package assist_mater.ejb.dao;

import java.util.List;

import assist_mater.ejb.data.Contrat;


public interface IDaoContrat {

	int			inserer( Contrat contrat );

	void 		modifier( Contrat contrat );

	void 		supprimer( int idContrat );

	Contrat 	retrouver( int idContrat );

	List<Contrat> listerTout();
    

}
