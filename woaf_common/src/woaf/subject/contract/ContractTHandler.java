package woaf.subject.contract;

import woaf.dto.DTOContract;

public interface ContractTHandler {
	public void doRecordContract(DTOContract dtoContract);
	public void doCheck(DTOContract dtoContract);
	public void doApplication(DTOContract dtoContract);
	public void doRenuncation(DTOContract dtoContract);
}
