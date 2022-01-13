package assist_mater.commun.service;

import java.util.List;


import assist_mater.commun.dto.DtoUser;
import assist_mater.commun.exception.ExceptionValidation;


public interface IServiceUser {
	
	int				inserer( DtoUser dtoCompte ) throws ExceptionValidation;

	void			modifier( DtoUser dtoCompte ) throws ExceptionValidation; 

	void			supprimer( int idUser ) throws ExceptionValidation;

	DtoUser 		retrouver( int idUser ) ;

	List<DtoUser>	listerTout() ;

}
