package woaf.subject.customer;

import woaf.dto.DTOCustomerForManipulation;

public interface CustomerTHandler {

	public void doRecordCustomer(DTOCustomerForManipulation dtoCustomerForInsert);
	public void doModifyCustomer(DTOCustomerForManipulation dtoCustomer);
	public void doBlockCustomer(Integer customerId);
	public void doTerminateCustomer(Integer customerId);
}
