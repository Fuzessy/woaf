package woaf.subject.contract;

public enum ContractState {
	RECORDED(1),CHECKED(2),APPROVED(3),TERMINATED(4),
	REFUSED(5), RENUNCED(5);
	
	private int id;
	private ContractState(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	
}
