package assist_mater.commun.service;

import assist_mater.commun.dto.DtoCompte;


public interface IServiceConnexion {

	DtoCompte	sessionUtilisateurOuvrir( String pseudo, String motDePasse );

	void		sessionUtilisateurFermer();

}
