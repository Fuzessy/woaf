package woaf.core;

import woaf.core.authentication.UserSession;

public class ApplicationSession {
	private static ApplicationSession instance;
	public static ApplicationSession getInstance(){
		instance = instance == null ? new ApplicationSession() : instance;
		return instance;
	}
	
	private UserSession userSession;
	
	private ApplicationSession(){
		userSession = LookupManager.getInstance().getUserSession();
	}
	
	public UserSession getUserSession(){
		return userSession;
	}
	
}
