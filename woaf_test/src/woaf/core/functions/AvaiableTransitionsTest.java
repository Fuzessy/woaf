package woaf.core.functions;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import woaf.core.LookupManager;

public class AvaiableTransitionsTest {
	
	@Test
	public void lookupTest(){
		assertNotNull(LookupManager.getInstance().getAvaiableTransitionsHandler());
	}
	
	@Test
	public void avaiableTransitionsTest(){
		List<Transition> transitions = LookupManager.getInstance()
			.getAvaiableTransitionsHandler()
			.getAvaiableTransitions(SubjectType.CONTRACT, 1);
		for(Transition t : transitions){
			System.out.println(t.getTransitionId() + " " + t.getName());
		}
	}
	
	
	@Test
	public void avaiableStartTransitionsTest(){
		List<Transition> transitions = LookupManager.getInstance()
			.getAvaiableTransitionsHandler()
			.getAvaiableStartTransitions(SubjectType.CONTRACT);
		for(Transition t : transitions){
			System.out.println("Start: " + t.getTransitionId() + " " + t.getName());
		}
	}
	

}
