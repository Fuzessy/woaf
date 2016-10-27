package woaf.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import woaf.dto.DTOContract;
import woaf.entities.Contract;

public class ContractDao {

	private EntityManager em;

	public ContractDao(EntityManager entityManager) {
		this.em = entityManager;
	}

	public List<DTOContract> getContractsDTOByState(int stateId) {
		List<Contract> contracts = em.createNamedQuery("Contract.findAllByState", Contract.class)
				.setParameter("stateId", stateId).getResultList();
		List<DTOContract> dtoContracts = new ArrayList<>();
		for (Contract c : contracts) {
			dtoContracts.add(createDTOContract(c));
		}
		return dtoContracts;
	}

	public static DTOContract createDTOContract(Contract c) {
		DTOContract dto = new DTOContract();
		dto.setContractId(c.getContractId());
		dto.setCustomerId(c.getCustomer().getCustomerId());
		dto.setCustomerName(c.getCustomer().getLastName() + " " + c.getCustomer().getFirstName());
		dto.setContractNumber(c.getContractNumber());
		dto.setStateId(c.getState().getStateId());
		dto.setStateName(c.getState().getName());
		return dto;
	}

}
