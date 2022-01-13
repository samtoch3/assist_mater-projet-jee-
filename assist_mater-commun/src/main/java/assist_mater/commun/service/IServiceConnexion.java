package assist_mater.commun.service;

import assist_mater.commun.dto.DtoUser;


public interface IServiceConnexion {

	DtoUser	sessionUtilisateurOuvrir( String login, String password );

	void		sessionUtilisateurFermer();

}
