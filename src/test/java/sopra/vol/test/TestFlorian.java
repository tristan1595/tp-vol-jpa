package sopra.vol.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestFlorian {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp-vol-jpa");
		
		emf.close();
	}

}
