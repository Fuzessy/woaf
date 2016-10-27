package woaf.core.functions;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import woaf.dao.ContractDao;
import woaf.dao.CustomerDao;
import woaf.dao.SubjectByStateDao;
import woaf.dto.DTOContract;
import woaf.dto.DTOCustomer;
import woaf.entities.Customer;

@Stateless
@Remote(DTOCollectorForChoose.class)
public class DTOCollectorForChooseBean implements DTOCollectorForChoose, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8559287371621470856L;
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> getDTOListForChoose(AvaiableSimpleFunction simpleFunction, Class<T> clazz) {
		int stateId = simpleFunction.getStateId();
		List<T> result = null;
		if(clazz.equals(DTOContract.class) && simpleFunction.getSubjectType() == SubjectType.CONTRACT){
			return ((List<T>) (new ContractDao(em)).getContractsDTOByState(stateId));
		}if(clazz.equals(DTOCustomer.class) && simpleFunction.getSubjectType() == SubjectType.CUSTOMER){
			List<Customer> customers = (new SubjectByStateDao(em)).getSubjectByState(stateId,Customer.class);
			return (List<T>) customers.stream().map(customer -> CustomerDao.getDTOCustomer(customer))
			.collect(Collectors.toList());
		}else{
			throw new RuntimeException( simpleFunction.getSubjectType() + "/" + clazz + " is not supported!");
		}
	}

}