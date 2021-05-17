package sopra.vol.test;

import org.junit.Test;

import sopra.test.vol.TestSeif;

public class TestGlobal {
	
	@Test 
	public void globalTest() {
		TestFlorian t1 = new TestFlorian();
		TestTristanBis t2 = new TestTristanBis();
		TestSeif t3 = new TestSeif();
		
		t1.test1();
		t1.test2();
		
		t2.adresseCreate();
		t2.adresseFindAllAndDelete();
		t2.adresseUpdate();
		
		t3.clientCreate();
		t3.clientUpdate();
		t3.clientFindAll();
	}
}
