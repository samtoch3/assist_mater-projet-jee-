package assist_mater.ejb.dao;

import java.util.List;

import assist_mater.ejb.data.Garde;


public interface IDaoGarde {

	int			inserer( Garde garde );

	void 		modifier( Garde garde );

	void 		supprimer( int idGarde );

	Garde 	retrouver( int idGarde );

	List<Garde> listerTout();

}
