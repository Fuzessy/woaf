package woaf.core.authentication;

import java.io.Serializable;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.inject.Inject;

import woaf.dao.UserDao;
import woaf.dto.DTOUserData;
import woaf.entities.User;

/**
 * Session Bean implementation class UserSessionBean
 */
@Stateful
@Remote(UserSession.class)
public class UserSessionBean implements UserSession,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2961883903233802198L;

	@Inject
	private UserDao userDao;
	
	private User user;
	/**
     * @throws WoafAuthenticationException 
	 * @see UserSession#login(String, String)
     */
    public DTOUserData login(String username, String password) throws WoafAuthenticationException {
		this.user = userDao.login(username, password);
		if(user == null){
			throw new WoafAuthenticationException();
		}else{
			return new DTOUserData(user.getUserId(),user.getUsername(),user.getFullname());
		}
    }
	@Override
	public DTOUserData getUserData() {
		if(user == null) return null;
		return new DTOUserData(user.getUserId(),user.getUsername(),user.getFullname());
	}

}
