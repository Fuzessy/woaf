package woaf.dto;

import java.io.Serializable;

@DTOName("Ügyfél")
public class DTOUserData implements Serializable{
	@DTOName("Ügyfélazonosító")
	private int userId;
	@DTOName("Felhaszná név")
	private String username;
	@DTOName("Teljes név")
	private String fullname;
	
	
	public DTOUserData(int userId, String username, String fullname) {
		super();
		this.userId = userId;
		this.username = username;
		this.fullname = fullname;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	
}
