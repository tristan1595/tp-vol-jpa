package sopra.test.vol;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.Assert;
import org.junit.Test;

import sopra.vol.Application;
import sopra.vol.model.Client;
import sopra.vol.model.Entreprise;
import sopra.vol.model.Particulier;
import sopra.vol.model.StatutJuridique;
import sopra.vol.repository.IClientRepository;

public class TestSeif {
	
	@Test
	public void clientCreate() {
		
		IClientRepository clientRepo = Application.getInstance().getClientRepo();
		
		Particulier tristan = new Particulier();
		tristan.setName("Poul");
		tristan.setPrenom("Tristan");

		Entreprise sopraSteria = new Entreprise();
		sopraSteria.setName("Sopra Steria");
		sopraSteria.setSiret("32682006500083");
		sopraSteria.setNumeroTVA("FR18326820065");
		sopraSteria.setStatutJuridique(StatutJuridique.SA);
		
		tristan = (Particulier) clientRepo.save(tristan);
		sopraSteria = (Entreprise) clientRepo.save(sopraSteria);
//		try {
//			tristan = (Particulier) clientRepo.save(tristan);
//			Assert.fail("Vérification commentaires obligatoire en erreur");
//		} catch(PersistenceException e) {
//		}
		Particulier tristanFind = (Particulier) clientRepo.findById(tristan.getId());
		Assert.assertEquals("Poul", tristanFind.getName());
		Assert.assertEquals("Tristan", tristanFind.getPrenom());
		
		Entreprise sopraFind = (Entreprise) clientRepo.findById(sopraSteria.getId());
		Assert.assertEquals("Sopra Steria", sopraFind.getName());
		Assert.assertEquals("32682006500083", sopraFind.getSiret());
		Assert.assertEquals("FR18326820065", sopraFind.getNumeroTVA());
		Assert.assertEquals(StatutJuridique.SA, sopraFind.getStatutJuridique());
		
		
		clientRepo.delete(tristan);
		clientRepo.delete(sopraSteria);
		
		
	}
	@Test
	public void clientUpdate() {
		IClientRepository clientRepo = Application.getInstance().getClientRepo();
		
		Particulier tristan = new Particulier();
		tristan.setName("Poul");
		tristan.setPrenom("Tristan");
		
		tristan = (Particulier) clientRepo.save(tristan);
		tristan = (Particulier) clientRepo.findById(tristan.getId());
		tristan.setName("POUL");
		tristan.setPrenom("TRISTAN");
		tristan = (Particulier) clientRepo.save(tristan);
		tristan = (Particulier) clientRepo.findById(tristan.getId());
		
		Assert.assertEquals("POUL", tristan.getName());
		Assert.assertEquals("TRISTAN", tristan.getPrenom());
				

		Entreprise sopraSteria = new Entreprise();
		sopraSteria.setName("Sopra Steria");
		sopraSteria.setSiret("32682006500083");
		sopraSteria.setNumeroTVA("FR18326820065");
		sopraSteria.setStatutJuridique(StatutJuridique.SA);
		
		sopraSteria = (Entreprise) clientRepo.save(sopraSteria);
		sopraSteria = (Entreprise) clientRepo.findById(sopraSteria.getId());
		sopraSteria.setName("SOPRA STERIA");
		sopraSteria.setSiret("000000000000");;
		sopraSteria.setNumeroTVA("FR11111111111");
		sopraSteria.setStatutJuridique(StatutJuridique.SAS);
		sopraSteria = (Entreprise) clientRepo.save(sopraSteria);
		sopraSteria = (Entreprise) clientRepo.findById(sopraSteria.getId());
		Assert.assertEquals("SOPRA STERIA", sopraSteria.getName());
		Assert.assertEquals("000000000000", sopraSteria.getSiret());
		Assert.assertEquals("FR11111111111", sopraSteria.getNumeroTVA());
		Assert.assertEquals(StatutJuridique.SAS, sopraSteria.getStatutJuridique());
		
		clientRepo.delete(tristan);
		clientRepo.delete(sopraSteria);

	}
	
	
	@Test
	public void clientFindAll() {
		
		IClientRepository clientRepo = Application.getInstance().getClientRepo();
		
		Particulier tristan = new Particulier();
		tristan.setName("Poul");
		tristan.setPrenom("Tristan");
		tristan = (Particulier) clientRepo.save(tristan);
		
		Particulier seif = new Particulier();
		seif.setName("BOULKROUN");
		seif.setPrenom("Seif");
		seif = (Particulier) clientRepo.save(seif);
		
		
		Entreprise sopraSteria = new Entreprise();
		sopraSteria.setName("Sopra Steria");
		sopraSteria.setSiret("32682006500083");
		sopraSteria.setNumeroTVA("FR18326820065");
		sopraSteria.setStatutJuridique(StatutJuridique.SA);
		sopraSteria = (Entreprise) clientRepo.save(sopraSteria);
		
		Entreprise gainax = new Entreprise();
		gainax.setName("GAINAX");
		gainax.setSiret("1010101010101");
		gainax.setNumeroTVA("JP6767676767676");
		gainax.setStatutJuridique(StatutJuridique.SAS);
		gainax = (Entreprise) clientRepo.save(gainax);
		
		List<Client> clients = clientRepo.findAll();
		
		clientRepo.delete(seif);
		Assert.assertEquals(4, clients.size());
		
		clientRepo.delete(tristan);
		clientRepo.delete(sopraSteria);
		clientRepo.delete(gainax);
		
		List<Client> clients2 = clientRepo.findAll();
		
		Assert.assertEquals(0, clients2.size());
	}

}
