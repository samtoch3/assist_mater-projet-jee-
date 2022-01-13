package assist_mater.ejb.service.standard;

import static assist_mater.commun.dto.Roles.ADMINISTRATEUR;
import static assist_mater.commun.dto.Roles.UTILISATEUR;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import assist_mater.commun.dto.DtoCategorie;
import assist_mater.commun.exception.ExceptionValidation;
import assist_mater.commun.service.IServiceCategorie;
import assist_mater.ejb.dao.IDaoGarde;
import assist_mater.ejb.dao.IDaoContrat;
import assist_mater.ejb.data.Garde;
import assist_mater.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
@RolesAllowed(ADMINISTRATEUR)
public class ServiceGarde implements IServiceCategorie {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoGarde daoCategorie;
	@Inject
	private IDaoContrat daoPersonne;

	// Actions

	@Override
	public int inserer(DtoCategorie dtoCategorie) throws ExceptionValidation {
		verifierValiditeDonnees(dtoCategorie);
		int id = daoCategorie.inserer(mapper.map(dtoCategorie));
		return id;
	}

	@Override
	public void modifier(DtoCategorie dtoCategorie) throws ExceptionValidation {
		verifierValiditeDonnees(dtoCategorie);
		daoCategorie.modifier(mapper.map(dtoCategorie));
	}

	@Override
	public void supprimer(int idCategorie) throws ExceptionValidation {
		if (daoPersonne.compterPourCategorie(idCategorie) != 0) {
			throw new ExceptionValidation("La catégorie n'est pas vide");
		}
		daoCategorie.supprimer(idCategorie);
	}

	@Override
	@RolesAllowed({ ADMINISTRATEUR, UTILISATEUR })
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoCategorie retrouver(int idCategorie) {
		return mapper.map(daoCategorie.retrouver(idCategorie));
	}

	@Override
	@RolesAllowed({ ADMINISTRATEUR, UTILISATEUR })
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoCategorie> listerTout() {
		List<DtoCategorie> liste = new ArrayList<>();
		for (Garde categorie : daoCategorie.listerTout()) {
			liste.add(mapper.map(categorie));
		}
		return liste;
	}

	// Méthodes auxiliaires

	private void verifierValiditeDonnees(DtoCategorie dtoCategorie) throws ExceptionValidation {

		StringBuilder message = new StringBuilder();

		if (dtoCategorie.getLibelle() == null || dtoCategorie.getLibelle().isEmpty()) {
			message.append("\nLe libellé est absent.");
		} else if (dtoCategorie.getLibelle().length() < 3) {
			message.append("\nLe libellé est trop court.");
		} else if (dtoCategorie.getLibelle().length() > 25) {
			message.append("\nLe libellé est trop long.");
		}

		if (message.length() > 0) {
			throw new ExceptionValidation(message.toString().substring(1));
		}
	}

}
