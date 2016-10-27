package woaf.core.functions;

import java.io.Serializable;

public class AvaiableSimpleFunction extends AvaiableFunctions  implements Serializable{
	private AvaiableFunctionCommand command;
	private SubjectType subjectType;
	private int stateId;
	
	@Override
	public boolean isSimpleFunction() {
		return true;
	}

	public AvaiableFunctionCommand getCommand() {
		return command;
	}

	public void setCommand(AvaiableFunctionCommand command) {
		this.command = command;
	}

	
	public SubjectType getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(SubjectType subjectType) {
		this.subjectType = subjectType;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	
	
}
