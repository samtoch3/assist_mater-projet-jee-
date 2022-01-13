package assist_mater.ejb.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import assist_mater.commun.dto.DtoContrat;
import assist_mater.commun.dto.DtoGarde;
import assist_mater.commun.dto.DtoUser;
import assist_mater.ejb.data.Contrat;
import assist_mater.ejb.data.Garde;
import assist_mater.ejb.data.User;


 
@Mapper( componentModel = "cdi" )
public interface IMapperEjb {  
	
	static final IMapperEjb INSTANCE = Mappers.getMapper( IMapperEjb.class );
	
	
	// User
	
	User map( DtoUser source );
	
	DtoUser map( User source );

	
	// Garde
	
	Garde map( DtoGarde source );
	
	DtoGarde map( Garde source );

	
	// Contrat
	
	Contrat map( DtoContrat source );
	
	DtoContrat map( Contrat source );

	@Mapping( target="categorie", ignore = true )
	@Mapping( target="telephones", ignore = true )
	DtoContrat mapMinimal( Contrat source );
		
	
}
