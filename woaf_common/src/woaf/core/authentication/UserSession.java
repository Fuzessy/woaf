package woaf.core.authentication;

import woaf.dto.DTOUserData;

public interface UserSession {
	public DTOUserData login(String username, String password) throws WoafAuthenticationException;

	public DTOUserData getUserData();
}
