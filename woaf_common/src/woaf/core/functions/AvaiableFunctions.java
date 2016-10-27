package woaf.core.functions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class AvaiableFunctions implements Serializable{
	
	private String functionName;
		
	public abstract boolean isSimpleFunction();

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	
	public AvaiableFunctionList getFunctionList(){
		if(this.getClass().equals(AvaiableFunctionList.class)){
			return (AvaiableFunctionList) this; 
		}else{
			return null;
		}
	}
	
	public AvaiableSimpleFunction getSimpleFunction(){
		if(this.getClass().equals(AvaiableSimpleFunction.class)){
			return (AvaiableSimpleFunction) this; 
		}else{
			return null;
		}
	}
	
	
		
}
