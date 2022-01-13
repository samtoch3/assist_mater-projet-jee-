package assist_mater.ejb.service.standard;

import static assist_mater.commun.dto.Roles.NOUNOU;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import assist_mater.commun.dto.DtoUser;
import assist_mater.commun.exception.ExceptionValidation;
import assist_mater.commun.service.IServiceUser;
import assist_mater.ejb.dao.IDaoUser;
import assist_mater.ejb.data.User;
import assist_mater.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
@RolesAllowed(NOUNOU)
public class ServiceUser implements IServiceUser {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoUser daoUser;

	// Actions

	@Override
	public int inserer(DtoUser dtoUser) throws ExceptionValidation {
		verifierValiditeDonnees(dtoUser);
		int id = daoUser.inserer(mapper.map(dtoUser));
		return id;
	}

	@Override
	public void modifier(DtoUser dtoUser) throws ExceptionValidation {
		verifierValiditeDonnees(dtoUser);
		daoUser.modifier(mapper.map(dtoUser));
	}

	@Override
	public void supprimer(int idUser) throws ExceptionValidation {
		daoUser.supprimer(idUser);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoUser retrouver(int idUser) {
		return mapper.map(daoUser.retrouver(idUser));
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoUser> listerTout() {
		List<DtoUser> liste = new ArrayList<>();
		for (User compte : daoUser.listerTout()) {
			liste.add(mapper.map(compte));
		}
		return liste;
	}

	// Méthodes auxiliaires

	private void verifierValiditeDonnees(DtoUser dtoUser) throws ExceptionValidation {

		StringBuilder message = new StringBuilder();

		/*if (dtoUser.getLogin() == null || dtoUser.getLogin().isEmpty()) {
			message.append("\nLe pseudo est absent.");
		} else if (dtoUser.getLogin().length() < 3) {
			message.append("\nLe pseudo est trop court.");
		} else if (dtoUser.getLogin().length() > 25) {
			message.append("\nLe pseudo est trop long.");
		} else if (!daoUser.verifierUniciteLogin(dtoUser.getLogin(), dtoUser.getId_user())) {
			message.append("\nLe pseudo " + dtoUser.getLogin() + " est déjà utilisé.");
		}*/

		if (dtoUser.getPassword() == null || dtoUser.getPassword().isEmpty()) {
			message.append("\nLe mot de passe est absent.");
		} else if (dtoUser.getPassword().length() < 3) {
			message.append("\nLe mot de passe est trop court.");
		} else if (dtoUser.getPassword().length() > 25) {
			message.append("\nLe mot de passe est trop long.");
		}

		if (dtoUser.getLogin() == null || dtoUser.getLogin().isEmpty()) {
			message.append("\nL'adresse e-mail est absente.");
		} else if (!daoUser.verifierUniciteLogin(dtoUser.getLogin(), dtoUser.getId_user())) {
			message.append("\nL'adresse e-mail " + dtoUser.getLogin() + " est déjà utilisée.");
		}

		if (message.length() > 0) {
			throw new ExceptionValidation(message.toString().substring(1));
		} 
	}

}
