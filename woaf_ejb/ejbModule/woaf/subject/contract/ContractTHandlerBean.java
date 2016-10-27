package woaf.subject.contract;

import java.io.Serializable;
import java.util.Calendar;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import woaf.dto.DTOContract;
import woaf.entities.Contract;
import woaf.entities.Customer;
import woaf.entities.State;

@Stateless
@Remote(ContractTHandler.class)
public class ContractTHandlerBean implements ContractTHandler, Serializable{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public void doRecordContract(DTOContract dtoContract) {
		Contract c = fillFromDTO(dtoContract, new Contract());
		c.setState(em.find(State.class, ContractState.RECORDED.getId()));
		c.setContractDate(Calendar.getInstance());
		em.persist(c);
	}

	@Override
	public void doCheck(DTOContract dtoContract) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doApplication(DTOContract dtoContract) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doRenuncation(DTOContract dtoContract) {
		// TODO Auto-generated method stub
		
	}
	
	private Contract fillFromDTO(DTOContract dto, Contract e){
		e.setContractNumber(dto.getContractNumber());
		e.setCustomer(em.find(Customer.class, dto.getCustomerId()));
		return e;
	}

}
