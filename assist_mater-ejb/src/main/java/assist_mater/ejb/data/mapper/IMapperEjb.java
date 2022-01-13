package assist_mater.ejb.data.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import assist_mater.commun.dto.DtoCategorie;
import assist_mater.commun.dto.DtoCompte;
import assist_mater.commun.dto.DtoPersonne;
import assist_mater.commun.dto.DtoTelephone;
import assist_mater.ejb.data.Garde;
import assist_mater.ejb.data.User;
import assist_mater.ejb.data.Contrat;
import assist_mater.ejb.data.Telephone;

 
@Mapper( componentModel = "cdi" )
public interface IMapperEjb {  
	
	static final IMapperEjb INSTANCE = Mappers.getMapper( IMapperEjb.class );
	
	
	// Compte
	
	User map( DtoCompte source );
	
	DtoCompte map( User source );

	
	// Categorie
	
	Garde map( DtoCategorie source );
	
	DtoCategorie map( Garde source );

	
	// Personne
	
	Contrat map( DtoPersonne source );
	
	DtoPersonne map( Contrat source );

	@Mapping( target="categorie", ignore = true )
	@Mapping( target="telephones", ignore = true )
	DtoPersonne mapMinimal( Contrat source );
	
	
	// Telephone
	
	@Mapping( target="personne", ignore=true )
	Telephone map( DtoTelephone source );
	
	DtoTelephone map( Telephone source );
	

	// Méthodes auxiliaires
	
    @AfterMapping
    public default void addBackReference(@MappingTarget Contrat target) {
        for (Telephone telephone : target.getTelephones() ) {
        	telephone.setPersonne( target );
        }
    }	
	
}
