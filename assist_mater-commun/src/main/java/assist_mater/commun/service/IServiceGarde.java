package assist_mater.commun.service;

import java.util.List;

import assist_mater.commun.dto.DtoGarde;
import assist_mater.commun.exception.ExceptionValidation;


public interface IServiceGarde {
	
	int				inserer( DtoGarde dtoGarde ) throws ExceptionValidation;
	
	void			modifier( DtoGarde dtoGarde ) throws ExceptionValidation;
	
	void			supprimer( int idGarde ) throws ExceptionValidation;
	
	DtoGarde 	retrouver( int idGarde );
	
	List<DtoGarde> listerTout();
	

}
