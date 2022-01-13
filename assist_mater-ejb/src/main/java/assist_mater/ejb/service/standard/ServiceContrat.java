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

import assist_mater.commun.dto.DtoContrat;
import assist_mater.commun.exception.ExceptionValidation;
import assist_mater.commun.service.IServiceContrat;
import assist_mater.ejb.dao.IDaoContrat;
import assist_mater.ejb.data.Contrat;
import assist_mater.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
@RolesAllowed({ NOUNOU, PARENT })
public class ServiceContrat implements IServiceContrat {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoContrat daoContrat;

	// Actions

	@Override
	public int inserer(DtoContrat dtoContrat) throws ExceptionValidation {
		verifierValiditeDonnees(dtoContrat);
		int id = daoContrat.inserer(mapper.map(dtoContrat));
		return id;
	}

	@Override
	public void modifier(DtoContrat dtoContrat) throws ExceptionValidation {
		verifierValiditeDonnees(dtoContrat);
		daoContrat.modifier(mapper.map(dtoContrat));
	}

	@Override
	public void supprimer(int idContrat) throws ExceptionValidation {
		daoContrat.supprimer(idContrat);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoContrat retrouver(int idContrat) {
		Contrat personne = daoContrat.retrouver(idContrat);
		return mapper.map(personne);

	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoContrat> listerTout() {
		List<DtoContrat> liste = new ArrayList<>();
		for (Contrat c : daoContrat.listerTout()) {
			liste.add( mapper.mapMinimal(c) );
		}
		return liste;
	}

	// Méthodes auxiliaires

	private void verifierValiditeDonnees(DtoContrat dtoContrat) throws ExceptionValidation {

		StringBuilder message = new StringBuilder();

		if (dtoContrat.getLastname() == null || dtoContrat.getLastname().isEmpty()) {
			message.append("\nLe nom est absent.");
		} else if (dtoContrat.getLastname().length() > 25) {
			message.append("\nLe nom est trop long.");
		}

		if (dtoContrat.getFirstname() == null || dtoContrat.getFirstname().isEmpty()) {
			message.append("\nLe prénom est absent.");
		} else if (dtoContrat.getFirstname().length() > 25) {
			message.append("\nLe prénom est trop long.");
		}

		//TO DO
		//Ajouter la validité sur les autres champs

		if (message.length() > 0) {
			throw new ExceptionValidation(message.toString().substring(1));
		}
	}

}
