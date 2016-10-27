package woaf.core.functions;

import java.io.Serializable;

public class Transition extends SimpleTransition implements Serializable{
	private SubjectType subjectType;
	private int transitionId;
	
	
	public SubjectType getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(SubjectType subjectType) {
		this.subjectType = subjectType;
	}

	public int getTransitionId() {
		return transitionId;
	}

	public void setTransitionId(int transitionId) {
		this.transitionId = transitionId;
	}
	
}
