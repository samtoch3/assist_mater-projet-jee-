package assist_mater.ejb.service.standard;

import static assist_mater.commun.dto.Roles.NOUNOU;
import static assist_mater.commun.dto.Roles.PARENT;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import assist_mater.commun.dto.DtoGarde;
import assist_mater.commun.exception.ExceptionValidation;
import assist_mater.commun.service.IServiceGarde;
import assist_mater.ejb.dao.IDaoGarde;
import assist_mater.ejb.dao.IDaoContrat;
import assist_mater.ejb.data.Garde;
import assist_mater.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
@RolesAllowed(NOUNOU)
public class ServiceGarde implements IServiceGarde {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoGarde daoGarde;
	@Inject
	private IDaoContrat daoContrat;

	// Actions

	@Override
	public int inserer(DtoGarde dtoGarde) throws ExceptionValidation {
		verifierValiditeDonnees(dtoGarde);
		int id = daoGarde.inserer(mapper.map(dtoGarde));
		return id;
	}

	@Override
	public void modifier(DtoGarde dtoGarde) throws ExceptionValidation {
		verifierValiditeDonnees(dtoGarde);
		daoGarde.modifier(mapper.map(dtoGarde));
	}

	@Override
	public void supprimer(int idGarde) throws ExceptionValidation {
		/*if (daoContrat.compterPourGarde(idGarde) != 0) {
			throw new ExceptionValidation("La garde n'est pas vide");
		}
		daoGarde.supprimer(idGarde);*/
	}

	@Override
	@RolesAllowed({ NOUNOU, PARENT })
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoGarde retrouver(int idGarde) {
		return mapper.map(daoGarde.retrouver(idGarde));
	}

	@Override
	@RolesAllowed({ NOUNOU, PARENT })
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoGarde> listerTout() {
		List<DtoGarde> liste = new ArrayList<>();
		for (Garde categorie : daoGarde.listerTout()) {
			liste.add(mapper.map(categorie));
		}
		return liste;
	}

	// Méthodes auxiliaires

	private void verifierValiditeDonnees(DtoGarde dtoGarde) throws ExceptionValidation {

		StringBuilder message = new StringBuilder();

		/*if (dtoGarde.getLibelle() == null || dtoGarde.getLibelle().isEmpty()) {
			message.append("\nLe libellé est absent.");
		} else if (dtoGarde.getLibelle().length() < 3) {
			message.append("\nLe libellé est trop court.");
		} else if (dtoGarde.getLibelle().length() > 25) {
			message.append("\nLe libellé est trop long.");
		}*/

		//TO DO
		//Ajouter la validité sur les autres champs
		
		if (message.length() > 0) {
			throw new ExceptionValidation(message.toString().substring(1));
		}
	}

}
