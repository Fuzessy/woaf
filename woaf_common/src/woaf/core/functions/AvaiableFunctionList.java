package woaf.core.functions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AvaiableFunctionList extends AvaiableFunctions implements Serializable{
	private List<AvaiableFunctions> functionList;
	public AvaiableFunctionList(){
		functionList = new ArrayList<AvaiableFunctions>();
	}
	@Override
	public boolean isSimpleFunction() {
		return false;
	}
	
	public void addFunction(AvaiableFunctions funct){
		functionList.add(funct);
	}
	
	public List<AvaiableFunctions> getFunctions(){
		return functionList;
	}
	
	public void setFunctions(List<AvaiableFunctions> functions){
		functionList = functions;
	}
}
