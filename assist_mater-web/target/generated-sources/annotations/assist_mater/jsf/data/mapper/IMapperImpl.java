package assist_mater.jsf.data.mapper;

import assist_mater.commun.dto.DtoContrat;
import assist_mater.commun.dto.DtoGarde;
import assist_mater.commun.dto.DtoUser;
import assist_mater.jsf.data.Contrat;
import assist_mater.jsf.data.Garde;
import assist_mater.jsf.data.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-17T13:16:52+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.3.1300.v20210419-1022, environment: Java 15.0.2 (Oracle Corporation)"
)
@ApplicationScoped
public class IMapperImpl implements IMapper {

    @Override
    public User map(DtoUser source) {
        if ( source == null ) {
            return null;
        }

        User user = new User();

        user.setAdress( source.getAdress() );
        user.setFirstname( source.getFirstname() );
        user.setId_user( source.getId_user() );
        user.setLastname( source.getLastname() );
        user.setLogin( source.getLogin() );
        user.setNumero( source.getNumero() );
        user.setPassword( source.getPassword() );
        List<String> list = source.getRoles();
        if ( list != null ) {
            user.setRoles( new ArrayList<String>( list ) );
        }

        return user;
    }

    @Override
    public DtoUser map(User source) {
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
    public User duplicate(User source) {
        if ( source == null ) {
            return null;
        }

        User user = new User();

        user.setAdress( source.getAdress() );
        user.setFirstname( source.getFirstname() );
        user.setId_user( source.getId_user() );
        user.setLastname( source.getLastname() );
        user.setLogin( source.getLogin() );
        user.setNumero( source.getNumero() );
        user.setPassword( source.getPassword() );
        List<String> list = source.getRoles();
        if ( list != null ) {
            user.setRoles( new ArrayList<String>( list ) );
        }

        return user;
    }

    @Override
    public User update(User target, User source) {
        if ( source == null ) {
            return null;
        }

        target.setAdress( source.getAdress() );
        target.setFirstname( source.getFirstname() );
        target.setId_user( source.getId_user() );
        target.setLastname( source.getLastname() );
        target.setLogin( source.getLogin() );
        target.setNumero( source.getNumero() );
        target.setPassword( source.getPassword() );
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

        return target;
    }

    @Override
    public Contrat map(DtoContrat source) {
        if ( source == null ) {
            return null;
        }

        Contrat contrat = new Contrat();

        contrat.setDate_deb( source.getDate_deb() );
        contrat.setDate_fin( source.getDate_fin() );
        contrat.setDate_naiss( source.getDate_naiss() );
        contrat.setFirstname( source.getFirstname() );
        contrat.setId_contrat( source.getId_contrat() );
        contrat.setIndemn_entretien( source.getIndemn_entretien() );
        contrat.setIndemn_repas( source.getIndemn_repas() );
        contrat.setLastname( source.getLastname() );
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
        dtoContrat.setIndemn_entretien( source.getIndemn_entretien() );
        dtoContrat.setIndemn_repas( source.getIndemn_repas() );
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

        contrat.setDate_deb( source.getDate_deb() );
        contrat.setDate_fin( source.getDate_fin() );
        contrat.setDate_naiss( source.getDate_naiss() );
        contrat.setFirstname( source.getFirstname() );
        contrat.setId_contrat( source.getId_contrat() );
        contrat.setIndemn_entretien( source.getIndemn_entretien() );
        contrat.setIndemn_repas( source.getIndemn_repas() );
        contrat.setLastname( source.getLastname() );
        contrat.setParent( duplicate( source.getParent() ) );
        contrat.setTarif_horaire( source.getTarif_horaire() );

        return contrat;
    }

    @Override
    public Garde map(DtoGarde source) {
        if ( source == null ) {
            return null;
        }

        Garde garde = new Garde();

        garde.setDate_garde( source.getDate_garde() );
        garde.setHeure_deb( source.getHeure_deb() );
        garde.setHeure_fin( source.getHeure_fin() );
        garde.setId_garde( source.getId_garde() );
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

        garde.setDate_garde( source.getDate_garde() );
        garde.setHeure_deb( source.getHeure_deb() );
        garde.setHeure_fin( source.getHeure_fin() );
        garde.setId_garde( source.getId_garde() );
        garde.setRepasPris( source.isRepasPris() );

        return garde;
    }
}
