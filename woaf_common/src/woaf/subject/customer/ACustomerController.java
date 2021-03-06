package woaf.subject.customer;

import java.util.List;

import woaf.core.functions.SimpleTransition;
import woaf.dto.DTOAddress;
import woaf.dto.DTOCustomerForManipulation;
import woaf.subject.address.AAddressController;

public abstract class ACustomerController {

	public abstract DTOCustomerForManipulation getCustomerForInsert();

	public abstract DTOCustomerForManipulation getCustomerForModify();
	
	public abstract AAddressController getAddressController();
	
	public abstract void showAddressForm(List<SimpleTransition> transitions);
	
	public DTOAddress chooseOrModifyAddress(int addressId){
		AAddressController addressController = getAddressController();
		if(addressId != 0){
			addressController.setAddressStateModify();
			addressController.setAddressId(addressId);
		}else{
			addressController.setAddressStateNew();
		}
		showAddressForm(addressController.getTransitions());
		return addressController.getDTOAddress();
	}


	

}
