package woaf.core.functions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import woaf.entities.StateTransition;

@Stateless
@Remote(AvaiableTransitionsHandler.class)
public class AvaiableTransitionsHandlerBean implements AvaiableTransitionsHandler, Serializable {

	private static final long serialVersionUID = -3664897524002568156L;
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Transition> getAvaiableTransitions(SubjectType subjectType, int actualState) {
		return em.createNamedQuery("StateStransition.findAllByStateFrom",StateTransition.class)
			.setParameter("subjectid", subjectType.getSubjectId())
			.setParameter("stateFrom", actualState)
			.getResultList()
			.stream()
			.map(str -> createTransitionFromStateTransitionEntity(str,subjectType))
			.collect(Collectors.toList());
	}
	
	private Transition createTransitionFromStateTransitionEntity(StateTransition str,SubjectType subjectType) {
		Transition tr = new Transition();
		tr.setSubjectType(subjectType);
		tr.setTransitionId(str.getTransitionId());
		tr.setName(str.getName());
		return tr;
	}

	@Override
	public List<Transition> getAvaiableStartTransitions(SubjectType subjectType) {
		return em.createNamedQuery("StateStransition.findAllStartStateTransition",StateTransition.class)
			.setParameter("subjectid", subjectType.getSubjectId())
			.getResultList().stream()
			.map(str -> createTransitionFromStateTransitionEntity(str,subjectType))
			.collect(Collectors.toList());
		
	}

}
