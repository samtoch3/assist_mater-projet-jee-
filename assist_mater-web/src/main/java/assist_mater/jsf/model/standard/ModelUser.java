package assist_mater.jsf.model.standard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import assist_mater.commun.dto.DtoUser;
import assist_mater.commun.exception.ExceptionValidation;
import assist_mater.commun.service.IServiceUser;
import assist_mater.jsf.data.Userr;
import assist_mater.jsf.data.mapper.IMapper;
import assist_mater.jsf.util.UtilJsf;


@SuppressWarnings("serial")
@Named
@ViewScoped
public class ModelUser implements Serializable {

	
	// Champs
	
	private List<Userr>	liste;
	
	private Userr			courant;
	
	@EJB
	private IServiceUser	serviceUserr;
	
	@Inject
	private IMapper			mapper;

	
	// Getters 
	
	public List<Userr> getListe() {
		if ( liste == null ) {
			liste = new ArrayList<>();
			for ( DtoUser dto : serviceUserr.listerTout() ) {
				liste.add( mapper.map( dto ) );
			}
		}
		return liste;
	}
	
		public Userr getCourant() {
			if ( courant == null ) {
				courant = new Userr();
			}
			return courant;
		}
	
	
	// Initialisaitons
	
	public String actualiserCourant() {
		if ( courant != null ) {
			DtoUser dto = serviceUserr.retrouver( courant.getId_user() ); 
			if ( dto == null ) {
				UtilJsf.messageError( "Le Userr demandé n'existe pas" );
				return "test/liste";
			} else {
				courant = mapper.map( dto );
			}
		}
		return null;
	}
	
	
	// Actions
	
	public String validerMiseAJour() {
		try {
			if ( courant.getId_user() == null) {
				serviceUserr.inserer( mapper.map(courant) );
			} else {
				serviceUserr.modifier( mapper.map(courant) );
			}
			UtilJsf.messageInfo( "Mise à jour effectuée avec succès." );
			return "liste";
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return null;
		}
	}
	
	public String supprimer( Userr item ) {
		try {
			serviceUserr.supprimer( item.getId_user() );
			liste.remove(item);
			UtilJsf.messageInfo( "Suppression effectuée avec succès." );
		} catch (ExceptionValidation e) {
			UtilJsf.messageError( e ); 
		}
		return null;
	}
	
}
