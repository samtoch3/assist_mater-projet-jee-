package assist_mater.ejb.dao;

import java.util.List;

import assist_mater.ejb.data.User;


public interface IDaoUser {

	int			inserer( User user );

	void 		modifier( User user );

	void 		supprimer( int idUser );

	User 		retrouver( int idUser );

	List<User> listerTout();

	User 		validerAuthentification( String login, String password );

	boolean 	verifierUniciteLogin( String login, int idUser );

}
