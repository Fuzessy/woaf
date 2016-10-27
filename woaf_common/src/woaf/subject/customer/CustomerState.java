package woaf.subject.customer;

public enum CustomerState {
	ALIVE(7),
	TERMINATED(8),
	FORBIDDEN(9);
	
	private int id;
	private CustomerState(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
}
