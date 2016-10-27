package woaf.subject.address;

import java.util.List;

import woaf.core.functions.SimpleTransition;

public interface AddressControllerState {

	void actionPerformed(AAddressController aAddressController);

	List<SimpleTransition> getTransitions(AAddressController addressController);

}
