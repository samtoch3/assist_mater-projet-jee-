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
import assist_mater.jsf.data.Userr;

import assist_mater.jsf.util.UtilJsf;


@RequestScoped
@Named
public class ModelConnexion {

	// Champs

	private Userr			courant;

	@Inject
	private Userr		UserrActif;
	@Inject
	private ModelInfo		modelInfo;
	@EJB
	private IServiceConnexion serviceConnexion;


	// Getters 
	
	public Userr getCourant() {
		if ( courant == null ) {
			courant = new Userr();
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
	        
	    	modelInfo.setTitre( "Bienvenue" );
	    	modelInfo.setTexte( "Vous êtes connecté en tant que '" + courant.getFirstname() +"'.");
		    return "info";

	    } else {
	        UtilJsf.messageError( "Pseudo ou mot de passe invalide." );
	    	return null;
	    }
	}	
}
