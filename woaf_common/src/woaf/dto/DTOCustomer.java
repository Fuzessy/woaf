package woaf.dto;

import java.io.Serializable;

@DTOName("Ügyfél")
public class DTOCustomer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4514673695927071193L;

	@DTOName("Ügyfélkód")
	private int customerId;

	@DTOName("Vezetéknév")
	private String lastName;
	
	@DTOName("Keresztnév")
	private String firstName;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
}
