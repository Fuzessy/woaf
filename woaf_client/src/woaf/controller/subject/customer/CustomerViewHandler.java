package woaf.controller.subject.customer;

import java.util.List;

import woaf.controller.main.ViewHandler;
import woaf.core.LookupManager;
import woaf.core.functions.AvaiableSimpleFunction;
import woaf.core.functions.Transition;
import woaf.dto.DTOCustomer;
import woaf.subject.customer.CustomerViewControllerWeaver;
import woaf.subject.customer.ACustomerController;

public class CustomerViewHandler implements ViewHandler{

	@Override
	public String getCreateFormForSubject() {
		return "/woaf/view/subject/customer/Customer.fxml";
	}
	
	@Override
	public String getDoFunctionForSubjectState(int stateId) {
		return "/woaf/view/subject/customer/Customer.fxml";
	}

	@Override
	public <T> List<Transition> getTransitions(T controller, AvaiableSimpleFunction function) {
		CustomerViewControllerWeaver viewHandler = 
				new CustomerViewControllerWeaver(
						(ACustomerController) controller,
						LookupManager.getInstance().getCustomerTHandler(),
						LookupManager.getInstance().getAvaiableTransitionsHandler(),
						function);
		return viewHandler.weaveTransitions();
	}

	@Override
	public Class<?> getDTOForChooseDTOClass() {
		return DTOCustomer.class;
	}


}
