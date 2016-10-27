package woaf.core.functions;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import woaf.entities.State;


@Stateless
@Remote(AvaiableFunctionsHandler.class)
public class AvaiableFunctionsHandlerBean implements AvaiableFunctionsHandler, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1343675658070426661L;
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public AvaiableFunctionList getAvaiableFunctions() {
		AvaiableFunctionList rootFunctions = new AvaiableFunctionList();
		// Szerződések
		rootFunctions.addFunction(getContractFunctions());
		// Partnerek
		rootFunctions.addFunction(getCustomerFunctions());
		return rootFunctions;
	}

	private AvaiableFunctions getCustomerFunctions() {
		AvaiableFunctionList customerFunctions = new AvaiableFunctionList();
		customerFunctions.setFunctionName("Ügyfelek");
		AvaiableSimpleFunction createCustomerFunction = new AvaiableSimpleFunction();
		createCustomerFunction.setCommand(AvaiableFunctionCommand.CREATE_NEW);
		createCustomerFunction.setFunctionName("Új ügyfél rögzítése");
		createCustomerFunction.setSubjectType(SubjectType.CUSTOMER);
		customerFunctions.addFunction(createCustomerFunction);
		
		addFunctionsByStase(SubjectType.CUSTOMER,customerFunctions, "getStateByCustomers");
		return customerFunctions;
	}

	private void addFunctionsByStase(SubjectType subjectType, AvaiableFunctionList avaiableFunctionList, String strName) {
		List<State> states = em.createNamedQuery("State." + strName,State.class)
				.setParameter("subjectid", subjectType.getSubjectId())
				.getResultList();
		for(State st : states){
			AvaiableSimpleFunction simpleFunction = new AvaiableSimpleFunction();
			simpleFunction.setCommand(AvaiableFunctionCommand.CHOOSE_AND_DO);
			simpleFunction.setFunctionName(st.getName());
			simpleFunction.setStateId(st.getStateId());
			simpleFunction.setSubjectType(subjectType);
			avaiableFunctionList.addFunction(simpleFunction);
		}
	}

	private AvaiableFunctionList getContractFunctions() {
		AvaiableFunctionList contractFunctions = new AvaiableFunctionList();
		contractFunctions.setFunctionName("Szerződések");
		AvaiableSimpleFunction createContractFunction = new AvaiableSimpleFunction();
		createContractFunction.setCommand(AvaiableFunctionCommand.CREATE_NEW);
		createContractFunction.setFunctionName("Új szerződés rögzítése");
		createContractFunction.setSubjectType(SubjectType.CONTRACT);
		contractFunctions.addFunction(createContractFunction);
		
		List<State> states = em.createNamedQuery("State.getStateByContracts",State.class)
			.setParameter("subjectid", 1)
			.getResultList();
		for(State st : states){
			AvaiableSimpleFunction simpleFunction = new AvaiableSimpleFunction();
			simpleFunction.setCommand(AvaiableFunctionCommand.CHOOSE_AND_DO);
			simpleFunction.setFunctionName(st.getName());
			simpleFunction.setStateId(st.getStateId());
			simpleFunction.setSubjectType(SubjectType.CONTRACT);
			contractFunctions.addFunction(simpleFunction);
		}
		return contractFunctions;
	}

}
