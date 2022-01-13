package assist_mater.jsf.model.standard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import assist_mater.commun.dto.DtoGarde;
import assist_mater.commun.exception.ExceptionValidation;
import assist_mater.commun.service.IServiceGarde;
import assist_mater.jsf.data.Garde;
import assist_mater.jsf.data.Telephone;
import assist_mater.jsf.data.mapper.IMapper;
import assist_mater.jsf.util.UtilJsf;


@SuppressWarnings("serial")
@ViewScoped
@Named
public class ModelGarde implements Serializable {

	
	// Champs
	
	private List<Garde>		liste;
	
	private Garde			courant;
	
	@EJB
	private IServiceGarde	serviceGarde;

	@Inject
	private IMapper				mapper;

	
	// Getters 
	
	public List<Garde> getListe() {
		if ( liste == null ) {
			liste = new ArrayList<>();
			for ( DtoGarde dto : serviceGarde.listerTout() ) {
				liste.add( mapper.map( dto ) );
			}
		}
		return liste;
	}

	public Garde getCourant() {
		if ( courant == null ) {
			courant = new Garde();
		}
		return courant;
	}
	
	
	// Initialisaitons
	
	public String actualiserCourant() {
		if ( courant != null ) {
			DtoGarde dto = serviceGarde.retrouver( courant.getId_garde() ); 
			if ( dto == null ) {
				UtilJsf.messageError( "La Garde demandée n'existe pas" );
				return "liste";
			} else {
				courant = mapper.map( dto );
			}
		}
		return null;
	}
	
	
	// Actions
	
	public String validerMiseAJour() {
		try {
			if ( courant.getId_garde() == null) {
				serviceGarde.inserer( mapper.map(courant) );
			} else {
				serviceGarde.modifier( mapper.map(courant) );
			}
			UtilJsf.messageInfo( "Mise à jour effectuée avec succès." );
			return "liste";
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return null;
		}
	}
	
	public String supprimer( Garde Garde ) {
		try {
			serviceGarde.supprimer( Garde.getId_garde() );
			liste.remove(Garde);
			UtilJsf.messageInfo( "Suppression effectuée avec succès." );
		} catch (ExceptionValidation e) {
			UtilJsf.messageError( e ); 
		}
		return null;
	}
	
	
	/*public String ajouterTelephone() {
		courant.getTelephones().add( new Telephone() );
		return null;
	}
	
	
	public String supprimerTelephone( Telephone telephone ) {
		for ( int i=0; i < courant.getTelephones().size(); ++i ) {
			if ( courant.getTelephones().get(i) == telephone ) {
				courant.getTelephones().remove( i );
				break;
			}
		}
		return null;
	}*/
	
}
