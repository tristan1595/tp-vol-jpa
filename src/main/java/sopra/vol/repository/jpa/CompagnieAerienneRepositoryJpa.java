package sopra.vol.repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import sopra.vol.Application;
import sopra.vol.model.CompagnieAerienne;
import sopra.vol.repository.ICompagnieAerienneRepository;

public class CompagnieAerienneRepositoryJpa implements ICompagnieAerienneRepository {

	@Override
	public List<CompagnieAerienne> findAll() {
		List<CompagnieAerienne> compagnieAeriennes = new ArrayList<CompagnieAerienne>();

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<CompagnieAerienne> query = em.createQuery("select c from CompagnieAerienne c", CompagnieAerienne.class);

			compagnieAeriennes = query.getResultList();

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

		} finally {
			if (em != null) {
				em.close();
			}
		}

		return compagnieAeriennes;
	}

	@Override
	public CompagnieAerienne findById(String id) {
		CompagnieAerienne compagnieAerienne = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			compagnieAerienne = em.find(CompagnieAerienne.class, id);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

		} finally {
			if (em != null) {
				em.close();
			}
		}

		return compagnieAerienne;
	}
	

}
