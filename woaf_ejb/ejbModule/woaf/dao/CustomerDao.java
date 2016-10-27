package woaf.dao;

import javax.persistence.EntityManager;

import woaf.dto.DTOCustomer;
import woaf.entities.Customer;

public class CustomerDao {
	
	private EntityManager em;
	
	public CustomerDao(EntityManager em){
		this.em = em;
	}
	
	public static DTOCustomer getDTOCustomer(Customer customer){
		DTOCustomer dto = new DTOCustomer();
		dto.setFirstName(customer.getFirstName());
		dto.setLastName(customer.getLastName());
		dto.setCustomerId(customer.getCustomerId());
		return dto;
	}
}
