package woaf.subject.address;

import java.util.ArrayList;
import java.util.List;

import woaf.core.functions.SimpleTransition;
import woaf.dto.DTOAddress;

public class AddressControllerStateCreateNew implements AddressControllerState {

	@Override
	public void actionPerformed(AAddressController addressController) {
		DTOAddress dto = addressController.getDTOAddress();
		AddressTHandler ath = addressController.getAddressTHandler();
		addressController.setDTOAddress(ath.createNewAddress(dto));
	}

	@Override
	public List<SimpleTransition> getTransitions(AAddressController addressController) {
		List<SimpleTransition> tr = new ArrayList<>();
		SimpleTransition st = new SimpleTransition();
		st.setName("Új rögzítése");
		st.setFunction(() ->{
			addressController.okPressed();
		});
		tr.add(st);
		return tr;
	}

}
