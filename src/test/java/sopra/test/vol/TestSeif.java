package sopra.test.vol;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestSeif {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp-vol-jpa");
		
		emf.close();

	}

}
