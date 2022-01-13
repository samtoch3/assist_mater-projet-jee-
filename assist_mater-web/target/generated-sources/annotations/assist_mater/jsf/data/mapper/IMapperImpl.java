package assist_mater.jsf.data.mapper;

import assist_mater.commun.dto.DtoContrat;
import assist_mater.commun.dto.DtoGarde;
import assist_mater.commun.dto.DtoUser;
import assist_mater.jsf.data.Contrat;
import assist_mater.jsf.data.Garde;
import assist_mater.jsf.data.Userr;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-13T15:49:26+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.3.1300.v20210419-1022, environment: Java 15.0.2 (Oracle Corporation)"
)
@ApplicationScoped
public class IMapperImpl implements IMapper {

    @Override
    public Userr map(DtoUser source) {
        if ( source == null ) {
            return null;
        }

        Userr userr = new Userr();

        userr.setId_user( source.getId_user() );
        userr.setLastname( source.getLastname() );
        userr.setFirstname( source.getFirstname() );
        userr.setLogin( source.getLogin() );
        userr.setPassword( source.getPassword() );
        userr.setAdress( source.getAdress() );
        List<String> list = source.getRoles();
        if ( list != null ) {
            userr.setRoles( new ArrayList<String>( list ) );
        }
        userr.setNumero( source.getNumero() );

        return userr;
    }

    @Override
    public DtoUser map(Userr source) {
        if ( source == null ) {
            return null;
        }

        DtoUser dtoUser = new DtoUser();

        dtoUser.setAdress( source.getAdress() );
        dtoUser.setFirstname( source.getFirstname() );
        dtoUser.setId_user( source.getId_user() );
        dtoUser.setLastname( source.getLastname() );
        dtoUser.setLogin( source.getLogin() );
        dtoUser.setNumero( source.getNumero() );
        dtoUser.setPassword( source.getPassword() );
        List<String> list = source.getRoles();
        if ( list != null ) {
            dtoUser.setRoles( new ArrayList<String>( list ) );
        }

        return dtoUser;
    }

    @Override
    public Userr duplicate(Userr source) {
        if ( source == null ) {
            return null;
        }

        Userr userr = new Userr();

        userr.setId_user( source.getId_user() );
        userr.setLastname( source.getLastname() );
        userr.setFirstname( source.getFirstname() );
        userr.setLogin( source.getLogin() );
        userr.setPassword( source.getPassword() );
        userr.setAdress( source.getAdress() );
        List<String> list = source.getRoles();
        if ( list != null ) {
            userr.setRoles( new ArrayList<String>( list ) );
        }
        userr.setNumero( source.getNumero() );

        return userr;
    }

    @Override
    public Userr update(Userr target, Userr source) {
        if ( source == null ) {
            return null;
        }

        target.setId_user( source.getId_user() );
        target.setLastname( source.getLastname() );
        target.setFirstname( source.getFirstname() );
        target.setLogin( source.getLogin() );
        target.setPassword( source.getPassword() );
        target.setAdress( source.getAdress() );
        if ( target.getRoles() != null ) {
            List<String> list = source.getRoles();
            if ( list != null ) {
                target.getRoles().clear();
                target.getRoles().addAll( list );
            }
            else {
                target.setRoles( null );
            }
        }
        else {
            List<String> list = source.getRoles();
            if ( list != null ) {
                target.setRoles( new ArrayList<String>( list ) );
            }
        }
        target.setNumero( source.getNumero() );

        return target;
    }

    @Override
    public Contrat map(DtoContrat source) {
        if ( source == null ) {
            return null;
        }

        Contrat contrat = new Contrat();

        contrat.setLastname( source.getLastname() );
        contrat.setFirstname( source.getFirstname() );
        contrat.setDate_naiss( source.getDate_naiss() );
        contrat.setDate_deb( source.getDate_deb() );
        contrat.setDate_fin( source.getDate_fin() );
        contrat.setTarif_horaire( source.getTarif_horaire() );

        return contrat;
    }

    @Override
    public DtoContrat map(Contrat source) {
        if ( source == null ) {
            return null;
        }

        DtoContrat dtoContrat = new DtoContrat();

        dtoContrat.setDate_deb( source.getDate_deb() );
        dtoContrat.setDate_fin( source.getDate_fin() );
        dtoContrat.setDate_naiss( source.getDate_naiss() );
        dtoContrat.setFirstname( source.getFirstname() );
        if ( source.getId_contrat() != null ) {
            dtoContrat.setId_contrat( source.getId_contrat() );
        }
        dtoContrat.setLastname( source.getLastname() );
        dtoContrat.setTarif_horaire( source.getTarif_horaire() );

        return dtoContrat;
    }

    @Override
    public Contrat duplicate(Contrat source) {
        if ( source == null ) {
            return null;
        }

        Contrat contrat = new Contrat();

        contrat.setLastname( source.getLastname() );
        contrat.setFirstname( source.getFirstname() );
        contrat.setDate_naiss( source.getDate_naiss() );
        contrat.setDate_deb( source.getDate_deb() );
        contrat.setDate_fin( source.getDate_fin() );
        contrat.setTarif_horaire( source.getTarif_horaire() );
        contrat.setParent( duplicate( source.getParent() ) );

        return contrat;
    }

    @Override
    public Garde map(DtoGarde source) {
        if ( source == null ) {
            return null;
        }

        Garde garde = new Garde();

        garde.setId_garde( source.getId_garde() );
        garde.setDate_garde( source.getDate_garde() );
        garde.setHeure_deb( source.getHeure_deb() );
        garde.setHeure_fin( source.getHeure_fin() );
        garde.setRepasPris( source.isRepasPris() );

        return garde;
    }

    @Override
    public DtoGarde map(Garde source) {
        if ( source == null ) {
            return null;
        }

        DtoGarde dtoGarde = new DtoGarde();

        dtoGarde.setDate_garde( source.getDate_garde() );
        dtoGarde.setHeure_deb( source.getHeure_deb() );
        dtoGarde.setHeure_fin( source.getHeure_fin() );
        dtoGarde.setId_garde( source.getId_garde() );
        dtoGarde.setRepasPris( source.isRepasPris() );

        return dtoGarde;
    }

    @Override
    public Garde duplicate(Garde source) {
        if ( source == null ) {
            return null;
        }

        Garde garde = new Garde();

        garde.setId_garde( source.getId_garde() );
        garde.setDate_garde( source.getDate_garde() );
        garde.setHeure_deb( source.getHeure_deb() );
        garde.setHeure_fin( source.getHeure_fin() );
        garde.setRepasPris( source.isRepasPris() );

        return garde;
    }
}
