package woaf.test;

import java.io.Serializable;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
public class TestLocalBean implements Serializable, ServerClass{
	public void test(){
		System.out.println("local bean test");
	}
}
