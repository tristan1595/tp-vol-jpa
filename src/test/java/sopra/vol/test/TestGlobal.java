package sopra.vol.test;

import org.junit.Test;

public class TestGlobal {
	
	@Test 
	public void globalTest() {
		TestFlorian t1 = new TestFlorian();
		TestTristanBis t2 = new TestTristanBis();
		
		t1.test1();
		t1.test2();
		
		t2.adresseCreate();
		t2.adresseFindAllAndDelete();
		t2.adresseUpdate();
	}
}
