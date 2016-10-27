package woaf.controller.subject.contract;

import java.util.List;

import woaf.controller.main.ViewHandler;
import woaf.core.LookupManager;
import woaf.core.functions.AvaiableSimpleFunction;
import woaf.core.functions.Transition;
import woaf.dto.DTOContract;
import woaf.subject.contract.ContractViewControllerWeaver;
import woaf.subject.contract.AContractController;

public class ContractViewHandler implements ViewHandler {
	
	@Override
	public String getCreateFormForSubject() {
		return "/woaf/view/subject/contract/Contract.fxml";
	}
	
	@Override
	public String getDoFunctionForSubjectState(int stateId) {
		return "/woaf/view/subject/contract/Contract.fxml";
	}

	@Override
	public <T> List<Transition> getTransitions(T controller, AvaiableSimpleFunction function){
		
		ContractViewControllerWeaver viewHandler = 
				new ContractViewControllerWeaver(
						(AContractController) controller,
						LookupManager.getInstance().getContractTHandler(),
						LookupManager.getInstance().getAvaiableTransitionsHandler(),
						function);
		return viewHandler.weaveTransitions();
	}

	@Override
	public Class<?> getDTOForChooseDTOClass() {
		return DTOContract.class;
	}

	


	


}
