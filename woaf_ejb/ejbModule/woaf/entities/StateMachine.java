package woaf.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the state_machine database table.
 * 
 */
@Entity
@Table(name="state_machine")
@NamedQuery(name="StateMachine.findAll", query="SELECT s FROM StateMachine s")
public class StateMachine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="state_machine_id")
	private int stateMachineId;

	private String name;

	//bi-directional many-to-one association to State
	@OneToMany(mappedBy="stateMachine")
	private List<State> states;

	//bi-directional many-to-one association to Subject
	@ManyToOne
	@JoinColumn(name="subject_id")
	private Subject subject;

	public StateMachine() {
	}

	public int getStateMachineId() {
		return this.stateMachineId;
	}

	public void setStateMachineId(int stateMachineId) {
		this.stateMachineId = stateMachineId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<State> getStates() {
		return this.states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	public State addState(State state) {
		getStates().add(state);
		state.setStateMachine(this);

		return state;
	}

	public State removeState(State state) {
		getStates().remove(state);
		state.setStateMachine(null);

		return state;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}