package woaf.dto;

import java.util.Calendar;

public class DTOContractForManipulation {

	private int contractId;
	private Calendar contractDate;
	private String contractNumber;
	private Integer customerId;
	
	public int getContractId() {
		return contractId;
	}
	public void setContractId(int contractId) {
		this.contractId = contractId;
	}
	public Calendar getContractDate() {
		return contractDate;
	}
	public void setContractDate(Calendar contractDate) {
		this.contractDate = contractDate;
	}
	public String getContractNumber() {
		return contractNumber;
	}
	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	
	
}
