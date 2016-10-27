package woaf.subject.address;

import java.util.List;

import woaf.core.dao.DAOAddress;
import woaf.core.functions.SimpleTransition;
import woaf.dto.DTOAddress;

public abstract class AAddressController {
	
	private AddressControllerState acState;
	
	public abstract void setDTOAddress(DTOAddress address);
	public abstract DTOAddress getDTOAddress();
	public abstract DAOAddress getDAOAddress();
	public abstract AddressTHandler getAddressTHandler();
	
	public void setAddressStateNew() {
		acState = new AddressControllerStateCreateNew();
	}


	public void setAddressStateModify() {
		acState = new AddressControllerStateModify();
	}
	
	public void setAddressId(int addressId) {
		DAOAddress daoAddress = getDAOAddress();
		DTOAddress dtoAddress = daoAddress.getAddressById(addressId);
		setDTOAddress(dtoAddress);
	}
	
	public void okPressed(){
		acState.actionPerformed(this);
	}
	public List<SimpleTransition> getTransitions() {
		return acState.getTransitions(this);
	}
	
	
}
