package assist_mater.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import assist_mater.commun.dto.DtoUser;
import assist_mater.commun.service.IServiceConnexion;
import assist_mater.ejb.dao.IDaoUser;
import assist_mater.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceConnexion implements IServiceConnexion {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoUser daoUser;

	// Actions

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoUser sessionUtilisateurOuvrir(String login, String pass) {
		DtoUser user = mapper.map(daoUser.validerAuthentification(login, pass));
		return user;
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public void sessionUtilisateurFermer() {
	}

}
