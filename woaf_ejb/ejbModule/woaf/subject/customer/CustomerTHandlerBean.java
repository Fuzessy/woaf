package woaf.subject.customer;

import java.io.Serializable;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import woaf.dto.DTOCustomerForManipulation;
import woaf.entities.Address;
import woaf.entities.Customer;
import woaf.entities.State;

@Stateless
@Remote(CustomerTHandler.class)
public class CustomerTHandlerBean implements CustomerTHandler, Serializable {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public void doRecordCustomer(DTOCustomerForManipulation dtoCustomerForInsert) {
		Customer customer = new Customer();
		customer.setFirstName(dtoCustomerForInsert.getFirstName());
		customer.setLastName(dtoCustomerForInsert.getLastName());
		customer.setState(em.find(State.class, CustomerState.ALIVE.getId()));
		Address address = em.find(Address.class, new Integer(dtoCustomerForInsert.getAddressId()));
		System.out.println("Address :" + dtoCustomerForInsert.getAddressId() + " -> " + address);
		customer.setAddress(address);
		em.persist(customer);
	}

	@Override
	public void doModifyCustomer(DTOCustomerForManipulation dtoCustomer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doBlockCustomer(Integer customerId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doTerminateCustomer(Integer customerId) {
		// TODO Auto-generated method stub

	}

}
