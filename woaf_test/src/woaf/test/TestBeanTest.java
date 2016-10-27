package woaf.test;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

public class TestBeanTest {
	@Test
	public void testMe() throws NamingException{
		 TestFuz tf = (TestFuz) new InitialContext().lookup("java:global/woaf_ee/woaf_ejb/TestBean!woaf.test.TestFuz");
		 
		 ClientClass cl = new ClientClass();
		 tf.test(cl).test();
	}
}
