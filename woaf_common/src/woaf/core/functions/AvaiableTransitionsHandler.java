package woaf.core.functions;

import java.util.List;

public interface AvaiableTransitionsHandler {

	public List<Transition> getAvaiableTransitions(SubjectType subjectType, int actualState);

	public List<Transition> getAvaiableStartTransitions(SubjectType subjectType);
}
