package woaf.subject.address;

import org.junit.Test;

import woaf.core.LookupManager;
import woaf.dto.DTOAddress;

public class AddressTHandlerTest {

	@Test
	public void insertDTOAddress(){
		AddressTHandler ath = LookupManager.getInstance().getAddressTHandler();
		DTOAddress address = new DTOAddress();
		address.setAddressId(0);
		address.setCity("Pécel");
		address.setCountry("HUN");
		address.setNumber("10");
		address.setZipCode("2119");
		address.setStreet("BB utca");
		address = ath.createNewAddress(address);
		System.out.println("cím id: " + address.getAddressId());
	}
}
