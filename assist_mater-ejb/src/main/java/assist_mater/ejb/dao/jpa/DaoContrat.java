package assist_mater.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import assist_mater.ejb.dao.IDaoContrat;
import assist_mater.ejb.data.Contrat;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoContrat implements IDaoContrat {
	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;

	
	// Actions
	
	@Override
	public int inserer(Contrat contrat) {
		em.persist(contrat);
		em.flush();
		return contrat.getId_contrat();
	}

	@Override
	public void modifier(Contrat contrat) {
		em.merge( contrat );
	}

	@Override
	public void supprimer(int idContrat) {
		em.remove( retrouver(idContrat) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Contrat retrouver(int idContrat) {
		/*var graph = em.createEntityGraph( Contrat.class );
		graph.addAttributeNodes( "categorie" );
		graph.addAttributeNodes( "telephones" );
		var props = new HashMap<String, Object>();
		props.put( "javax.persistence.loadgraph", graph );*/
		return em.find( Contrat.class, idContrat );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Contrat> listerTout() {
		em.clear();
		var jpql = "SELECT c FROM Contrat c ORDER BY c.lastname, c.firstname";
		var query = em.createQuery( jpql, Contrat.class );
		return query.getResultList();
	}

}
