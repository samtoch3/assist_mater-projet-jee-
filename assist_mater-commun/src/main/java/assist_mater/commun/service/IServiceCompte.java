package assist_mater.commun.service;

import java.util.List;

import assist_mater.commun.dto.DtoCompte;
import assist_mater.commun.exception.ExceptionValidation;


public interface IServiceCompte {
	
	int				inserer( DtoCompte dtoCompte ) throws ExceptionValidation;

	void			modifier( DtoCompte dtoCompte ) throws ExceptionValidation; 

	void			supprimer( int idCompte ) throws ExceptionValidation;

	DtoCompte 		retrouver( int idCompte ) ;

	List<DtoCompte>	listerTout() ;

}
