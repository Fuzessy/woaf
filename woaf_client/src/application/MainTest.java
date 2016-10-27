package application;

import javax.ejb.EJB;

import woaf.core.functions.AvaiableFunctionsHandler;

public class MainTest {
	public static void main(String[] args) {
		MainTest mt = new MainTest();
		mt.doIt();
	}
	
	@EJB
	AvaiableFunctionsHandler afh;

	private void doIt() {
		afh.getAvaiableFunctions();
	}
}
