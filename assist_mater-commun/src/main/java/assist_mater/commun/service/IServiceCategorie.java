package assist_mater.commun.service;

import java.util.List;

import assist_mater.commun.dto.DtoCategorie;
import assist_mater.commun.exception.ExceptionValidation;


public interface IServiceCategorie {
	
	int		inserer( DtoCategorie dtoCategorie ) throws ExceptionValidation;

	void	modifier( DtoCategorie dtoCategorie ) throws ExceptionValidation;

	void	supprimer( int idCategorie ) throws ExceptionValidation;

	DtoCategorie	retrouver( int idCategorie );

	List<DtoCategorie>	listerTout();

}
