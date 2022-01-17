package assist_mater.jsf.model.standard;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import assist_mater.commun.dto.DtoUser;
import assist_mater.commun.service.IServiceConnexion;
import assist_mater.jsf.data.User;

import assist_mater.jsf.util.UtilJsf;


@RequestScoped
@Named
public class ModelConnexion {

	// Champs

	private User			courant;

	@Inject
	private User		UserrActif;
	@Inject
	private ModelInfo		modelInfo;
	@EJB
	private IServiceConnexion serviceConnexion;


	// Getters 
	
	public User getCourant() {
		if ( courant == null ) {
			courant = new User();
		}
		return courant;
	}

	
	// Actons
	
	public String connect() {
	    
	    DtoUser dto = serviceConnexion.sessionUtilisateurOuvrir( courant.getLogin(), courant.getPassword() );
	    
	    if ( dto != null ){
	    	
		    try {
			    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
				( (HttpServletRequest) ec.getRequest() ).login( courant.getLogin(), courant.getPassword() );
			} catch (ServletException e) {
				throw new RuntimeException( e );
			}

	        UserrActif.setLogin( dto.getLogin() );
	        UserrActif.setRoles( dto.getRoles() );
	        
	    	modelInfo.setTitre( "Bienvenue sur ChildCare App" );
	    	modelInfo.setTexte( "Vous êtes connecté en tant que '" + courant.getLogin() +"'.");
		    return "info";

	    } else {
	        UtilJsf.messageError( "Pseudo ou mot de passe invalide." );
	        
	    	return null;
	    }
	}	
}
