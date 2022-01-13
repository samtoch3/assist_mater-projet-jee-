package assist_mater.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import assist_mater.ejb.dao.IDaoUser;
import assist_mater.ejb.data.User;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoUser implements IDaoUser {

	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;
	
	
	// Actions
	
	@Override
	public int inserer(User user) {
		em.persist(user);
		em.flush();
		return user.getId_user();
	}

	@Override
	public void modifier(User user) {
		em.merge( user );
	}

	@Override
	public void supprimer(int idUser) {
		em.remove( retrouver(idUser) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public User retrouver(int idUser) {
		return em.find( User.class, idUser );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<User> listerTout() {
		em.clear();
		var jpql = "SELECT u FROM User u ORDER BY u.lastname, u.firstname";
		var query = em.createQuery( jpql, User.class );
		return query.getResultList();
	}


	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public User validerAuthentification( String login, String password )  {
	    var jpql = "SELECT u FROM User u WHERE u.login = :pseudo AND u.password = :pass ";
	    var query = em.createQuery( jpql, User.class );
	    query.setParameter( "pseudo", login );
	    query.setParameter( "pass", password );
	    try {
	        return query.getSingleResult();
	    } catch ( NoResultException e ) {
	        return null;
	    }
	}


	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public boolean verifierUniciteLogin( String login, int idUser )  {
	    var jpql = "SELECT COUNT(u) FROM User u WHERE u.login = :pseudo AND c.id_user <> :idU ";
	    var query = em.createQuery( jpql, Long.class );
	    query.setParameter( "pseudo", login );
	    query.setParameter( "idU", idUser );
        return query.getSingleResult() == 0;
	}
	
}
