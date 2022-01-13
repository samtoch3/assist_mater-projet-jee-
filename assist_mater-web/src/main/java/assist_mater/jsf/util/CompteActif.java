package assist_mater.jsf.util;

import static assist_mater.commun.dto.Roles.NOUNOU;
import static assist_mater.commun.dto.Roles.PARENT;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


import assist_mater.jsf.data.User;

@SuppressWarnings("serial")
@SessionScoped
@Named
public class CompteActif extends User {
	
	public boolean isLoggedIn() {
		return getLogin() != null;
	}	
	
	public boolean isUtilisateur() {
		return isLoggedIn() && isInRole( PARENT );
	}
	
	public boolean isAdmininstrateur() {
		return isLoggedIn() && isInRole( NOUNOU );
	}

	public String disconnect() {
	    UtilJsf.sessionInvalidate();
        UtilJsf.messageInfo( "Vous avez été déconnecté" );
	    return "connexion";
	}

}
