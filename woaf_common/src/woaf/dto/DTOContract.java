package woaf.dto;

import java.io.Serializable;

@DTOName("Szerződés")
public class DTOContract implements Serializable{
	@DTOName("Azonosító")
	private int contractId;
	@DTOName("Szerződésszám")
	private String contractNumber;
	private int stateId;
	@DTOName("Státusz")
	private String stateName;
	@DTOName("Ügyfél azonosítója")
	private Integer customerId;
	@DTOName("Ügyfél neve")
	private String customerName;
	
	
	public int getContractId() {
		return contractId;
	}
	public void setContractId(int contractId) {
		this.contractId = contractId;
	}
	public String getContractNumber() {
		return contractNumber;
	}
	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	@Override
	public String toString() {
		return "DTOContract [contractId=" + contractId + ", contractNumber=" + contractNumber + ", stateId=" + stateId
				+ ", stateName=" + stateName + ", customerId=" + customerId + ", customerName=" + customerName + "]";
	}
	
	
	
	
}
