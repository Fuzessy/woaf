package woaf.controller.main;

import woaf.controller.subject.contract.ContractViewHandler;
import woaf.controller.subject.customer.CustomerViewHandler;
import woaf.core.functions.SubjectType;

/**
 * Subject alapján létrehozza akliens oldali subject kezelő osztály példányát
 * @author fuzessy
 *
 */
public class ViewHandlerFactory {
	
	public ViewHandler getFormCreator(SubjectType subjectType){
		if(subjectType == SubjectType.CONTRACT){
			return new ContractViewHandler();
		}else if(subjectType == SubjectType.CUSTOMER){
			return new CustomerViewHandler();
		}
		throw new java.lang.IllegalArgumentException("SubjectType not supported: " + subjectType);
	}
}
