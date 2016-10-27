package woaf.subject.address;

import woaf.dto.DTOAddress;

public interface AddressTHandler {

	DTOAddress createNewAddress(DTOAddress dto);
	void modifyAddress(DTOAddress dto);

}
