package assist_mater.ejb.data.mapper;

import assist_mater.commun.dto.DtoContrat;
import assist_mater.commun.dto.DtoGarde;
import assist_mater.commun.dto.DtoUser;
import assist_mater.ejb.data.Contrat;
import assist_mater.ejb.data.Garde;
import assist_mater.ejb.data.User;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-17T12:09:48+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.3.1300.v20210419-1022, environment: Java 15.0.2 (Oracle Corporation)"
)
@ApplicationScoped
public class IMapperEjbImpl implements IMapperEjb {

    @Override
    public User map(DtoUser source) {
        if ( source == null ) {
            return null;
        }

        User user = new User();

        if ( source.getId_user() != null ) {
            user.setId_user( source.getId_user() );
        }
        user.setLastname( source.getLastname() );
        user.setFirstname( source.getFirstname() );
        user.setLogin( source.getLogin() );
        user.setPassword( source.getPassword() );
        user.setAdress( source.getAdress() );
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
        dtoUser.setPassword( source.getPassword() );
        List<String> list = source.getRoles();
        if ( list != null ) {
            dtoUser.setRoles( new ArrayList<String>( list ) );
        }

        return dtoUser;
    }

    @Override
    public Garde map(DtoGarde source) {
        if ( source == null ) {
            return null;
        }

        Garde garde = new Garde();

        if ( source.getId_garde() != null ) {
            garde.setId_garde( source.getId_garde() );
        }
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

        if ( source.getDate_garde() != null ) {
            dtoGarde.setDate_garde( new Date( source.getDate_garde().getTime() ) );
        }
        if ( source.getHeure_deb() != null ) {
            dtoGarde.setHeure_deb( new Time( source.getHeure_deb().getTime() ) );
        }
        if ( source.getHeure_fin() != null ) {
            dtoGarde.setHeure_fin( new Time( source.getHeure_fin().getTime() ) );
        }
        dtoGarde.setId_garde( source.getId_garde() );
        dtoGarde.setRepasPris( source.isRepasPris() );

        return dtoGarde;
    }

    @Override
    public Contrat map(DtoContrat source) {
        if ( source == null ) {
            return null;
        }

        Contrat contrat = new Contrat();

        if ( source.getId_contrat() != null ) {
            contrat.setId_contrat( source.getId_contrat() );
        }
        contrat.setLastname( source.getLastname() );
        contrat.setFirstname( source.getFirstname() );
        contrat.setDate_naiss( source.getDate_naiss() );
        contrat.setDate_deb( source.getDate_deb() );
        contrat.setDate_fin( source.getDate_fin() );
        if ( source.getTarif_horaire() != null ) {
            contrat.setTarif_horaire( source.getTarif_horaire().floatValue() );
        }
        if ( source.getIndemn_repas() != null ) {
            contrat.setIndemn_repas( source.getIndemn_repas().floatValue() );
        }
        if ( source.getIndemn_entretien() != null ) {
            contrat.setIndemn_entretien( source.getIndemn_entretien().floatValue() );
        }

        return contrat;
    }

    @Override
    public DtoContrat map(Contrat source) {
        if ( source == null ) {
            return null;
        }

        DtoContrat dtoContrat = new DtoContrat();

        if ( source.getDate_deb() != null ) {
            dtoContrat.setDate_deb( new Date( source.getDate_deb().getTime() ) );
        }
        if ( source.getDate_fin() != null ) {
            dtoContrat.setDate_fin( new Date( source.getDate_fin().getTime() ) );
        }
        if ( source.getDate_naiss() != null ) {
            dtoContrat.setDate_naiss( new Date( source.getDate_naiss().getTime() ) );
        }
        dtoContrat.setFirstname( source.getFirstname() );
        dtoContrat.setId_contrat( source.getId_contrat() );
        if ( source.getIndemn_entretien() != null ) {
            dtoContrat.setIndemn_entretien( BigDecimal.valueOf( source.getIndemn_entretien() ) );
        }
        if ( source.getIndemn_repas() != null ) {
            dtoContrat.setIndemn_repas( BigDecimal.valueOf( source.getIndemn_repas() ) );
        }
        dtoContrat.setLastname( source.getLastname() );
        if ( source.getTarif_horaire() != null ) {
            dtoContrat.setTarif_horaire( BigDecimal.valueOf( source.getTarif_horaire() ) );
        }

        return dtoContrat;
    }

    @Override
    public DtoContrat mapMinimal(Contrat source) {
        if ( source == null ) {
            return null;
        }

        DtoContrat dtoContrat = new DtoContrat();

        if ( source.getDate_deb() != null ) {
            dtoContrat.setDate_deb( new Date( source.getDate_deb().getTime() ) );
        }
        if ( source.getDate_fin() != null ) {
            dtoContrat.setDate_fin( new Date( source.getDate_fin().getTime() ) );
        }
        if ( source.getDate_naiss() != null ) {
            dtoContrat.setDate_naiss( new Date( source.getDate_naiss().getTime() ) );
        }
        dtoContrat.setFirstname( source.getFirstname() );
        dtoContrat.setId_contrat( source.getId_contrat() );
        if ( source.getIndemn_entretien() != null ) {
            dtoContrat.setIndemn_entretien( BigDecimal.valueOf( source.getIndemn_entretien() ) );
        }
        if ( source.getIndemn_repas() != null ) {
            dtoContrat.setIndemn_repas( BigDecimal.valueOf( source.getIndemn_repas() ) );
        }
        dtoContrat.setLastname( source.getLastname() );
        if ( source.getTarif_horaire() != null ) {
            dtoContrat.setTarif_horaire( BigDecimal.valueOf( source.getTarif_horaire() ) );
        }

        return dtoContrat;
    }
}
