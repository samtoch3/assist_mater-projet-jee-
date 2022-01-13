package assist_mater.commun.service;

import java.util.List;


import assist_mater.commun.dto.DtoContrat;
import assist_mater.commun.exception.ExceptionValidation;


public interface IServiceContrat {
	
	int		inserer( DtoContrat dtoCategorie ) throws ExceptionValidation;

	void	modifier( DtoContrat dtoCategorie ) throws ExceptionValidation;

	void	supprimer( int idContrat ) throws ExceptionValidation;

	DtoContrat	retrouver( int idContrat );

	List<DtoContrat>	listerTout();

}
