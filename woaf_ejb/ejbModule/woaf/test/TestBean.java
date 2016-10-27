package woaf.test;

import java.io.Serializable;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Stateful
@Remote(TestFuz.class)
public class TestBean implements TestFuz, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7785980428789054606L;
	


	@Override
	public ServerClass test(ClientClass clientClass) {
		clientClass.test();
		try {
			return (ServerClass) new InitialContext().lookup("java:global/woaf_ee/woaf_ejb/TestLocalBean!woaf.test.ServerClass");
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}

	
	
}
