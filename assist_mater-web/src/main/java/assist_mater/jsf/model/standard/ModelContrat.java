package assist_mater.jsf.model.standard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import assist_mater.commun.dto.DtoContrat;
import assist_mater.commun.exception.ExceptionValidation;
import assist_mater.commun.service.IServiceContrat;
import assist_mater.jsf.data.Contrat;
import assist_mater.jsf.data.mapper.IMapper;
import assist_mater.jsf.util.UtilJsf;


@SuppressWarnings("serial")
@Named
@ViewScoped
public class ModelContrat implements Serializable {

	
	// Champs
	
	private List<Contrat>		liste;
	
	private Contrat			courant;
	
	@EJB
	private IServiceContrat	serviceContrat;
	
	@Inject
	private IMapper				mapper;

	
	// Getters 
	
	public List<Contrat> getListe() {
		if ( liste == null ) {
			liste = new ArrayList<>();
			for ( DtoContrat dto : serviceContrat.listerTout() ) {
				liste.add( mapper.map( dto ) );
			}
		}
		return liste;
	}

	public Contrat getCourant() {
		if ( courant == null ) {
			courant = new Contrat();
		}
		return courant;
	}
	
	
	// Initialisaitons
	
	public String actualiserCourant() {
		if ( courant != null ) {
			DtoContrat dto = serviceContrat.retrouver( courant.getId_contrat() ); 
			if ( dto == null ) {
				UtilJsf.messageError( "La catégorie demandée n'existe pas" );
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
			if ( courant.getId_contrat() == null) {
				serviceContrat.inserer( mapper.map(courant) );
			} else {
				serviceContrat.modifier( mapper.map(courant) );
			}
			UtilJsf.messageInfo( "Mise à jour effectuée avec succès." );
			return "liste";
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return null;
		}
	}
	
	public String supprimer( Contrat item ) {
		try {
			serviceContrat.supprimer( item.getId_contrat() );
			liste.remove(item);
			UtilJsf.messageInfo( "Suppression effectuée avec succès." );
		} catch (ExceptionValidation e) {
			UtilJsf.messageError( e );
		}
		return null;
	}
	
}
