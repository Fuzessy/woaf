package woaf.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import woaf.entities.User;

@Stateless
public class UserDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public User login(String username, String passwprd){
		try{
			return em.createNamedQuery("User.findWithAuthenticationData",User.class)
				.setParameter("username", username)
				.setParameter("password", passwprd)
				.getSingleResult();
			
		}catch (NoResultException e) {
			return null;
		}
	}
}
