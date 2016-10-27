package woaf.core.functions;

import java.io.Serializable;

public class SimpleTransition implements Serializable{
	private String name;
	private Runnable function;
	
	public Runnable getFunction() {
		return function;
	}

	public void setFunction(Runnable function) {
		this.function = function;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
