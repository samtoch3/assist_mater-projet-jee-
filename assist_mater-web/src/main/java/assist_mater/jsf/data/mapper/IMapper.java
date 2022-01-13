package assist_mater.jsf.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import assist_mater.commun.dto.DtoContrat;
import assist_mater.commun.dto.DtoGarde;
import assist_mater.commun.dto.DtoUser;
import assist_mater.jsf.data.Contrat;
import assist_mater.jsf.data.Garde;
import assist_mater.jsf.data.User;


@Mapper( componentModel = "cdi" )
public interface IMapper {
  

	// Userr
	
	User    map( DtoUser source );
	
	DtoUser map( User source );
	
	User duplicate( User source );

	User update( @MappingTarget User target, User source );


	// Contrat
	
	Contrat    map( DtoContrat source );
	
	DtoContrat map( Contrat source );
	
	Contrat duplicate( Contrat source );

	
	// Garde
	
	Garde    map( DtoGarde source );
	
	DtoGarde map( Garde source );
	
    Garde duplicate( Garde source );

	
	// Telephone
	
	/*Telephone    map( DtoTelephone source );
	
	DtoTelephone map( Telephone source );

    // Méthodes nécessaire pour update( Garde )

	Telephone duplicate( Telephone source );

	List<Telephone> duplicate( List<Telephone> source );*/

}
