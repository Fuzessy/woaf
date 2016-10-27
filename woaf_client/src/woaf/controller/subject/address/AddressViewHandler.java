package woaf.controller.subject.address;

import java.util.ArrayList;
import java.util.List;

import woaf.controller.main.ViewHandler;
import woaf.core.functions.AvaiableSimpleFunction;
import woaf.core.functions.Transition;
import woaf.dto.DTOAddress;

public class AddressViewHandler implements ViewHandler{

	@Override
	public String getCreateFormForSubject() {
		return "/woaf/view/subject/address/Address.fxml";
	}

	@Override
	public <T> List<Transition> getTransitions(T controller, AvaiableSimpleFunction function) {
		return new ArrayList<Transition>();
	}

	@Override
	public String getDoFunctionForSubjectState(int stateId) {
		return "/woaf/view/subject/address/Address.fxml";
	}

	@Override
	public Class<?> getDTOForChooseDTOClass() {
		return DTOAddress.class;
	}

}
