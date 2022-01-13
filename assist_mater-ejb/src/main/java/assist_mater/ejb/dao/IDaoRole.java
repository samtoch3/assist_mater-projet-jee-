package assist_mater.ejb.dao;

import java.util.List;

import assist_mater.ejb.data.User;


public interface IDaoRole {

	void insererPourUser( User user );

	void modifierPourUser( User user );

	void supprimerPourUser( int idUser );

	List<String> listerPourUser( User user );

}
