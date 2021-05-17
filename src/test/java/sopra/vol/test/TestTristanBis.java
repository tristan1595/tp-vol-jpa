package sopra.vol.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import sopra.vol.Application;
import sopra.vol.model.Adresse;
import sopra.vol.model.Particulier;
import sopra.vol.repository.IAdresseRepository;
import sopra.vol.repository.IClientRepository;

public class TestTristanBis {
	
	@Test
	public void adresseCreate() {
		IAdresseRepository adresseRepo = Application.getInstance().getAdresseRepo();
		IClientRepository clientRepo = Application.getInstance().getClientRepo();
		
		Adresse adresse = new Adresse();
		adresse.setRue("9 rue Georges Bonnac");
		adresse.setComplement("3ème étage");
		adresse.setCodePostal("33000");
		adresse.setVille("Bordeaux");
		adresse.setPays("France");
		
		Particulier tristan = new Particulier();
		tristan.setName("Poul");
		tristan.setPrenom("Tristan");
		
		tristan = (Particulier)clientRepo.save(tristan);
		
		adresse.setClient(tristan);
		
		adresse = adresseRepo.save(adresse);
		
		Adresse adresseFind = adresseRepo.findById(adresse.getId());
		
		Assert.assertEquals("9 rue Georges Bonnac", adresseFind.getRue());
		Assert.assertEquals("3ème étage", adresseFind.getComplement());
		Assert.assertEquals("33000", adresseFind.getCodePostal());
		Assert.assertEquals("Bordeaux", adresseFind.getVille());
		Assert.assertEquals("France", adresseFind.getPays());
		Assert.assertEquals(tristan.getId(), adresseFind.getClient().getId());
		
		adresseRepo.delete(adresse);
		clientRepo.delete(tristan);
	}
	
	@Test
	public void adresseUpdate() {
		IAdresseRepository adresseRepo = Application.getInstance().getAdresseRepo();
		IClientRepository clientRepo = Application.getInstance().getClientRepo();
		
		Adresse adresse = new Adresse();
		adresse.setRue("9 rue Georges Bonnac");
		adresse.setComplement("3ème étage");
		adresse.setCodePostal("33000");
		adresse.setVille("Bordeaux");
		adresse.setPays("France");
		
		adresse = adresseRepo.save(adresse);
		
		adresse = adresseRepo.findById(adresse.getId());
		
		Particulier tristan = new Particulier();
		tristan.setName("Poul");
		tristan.setPrenom("Tristan");
		
		tristan = (Particulier)clientRepo.save(tristan);
		
		adresse.setRue("8 route de Loiseau");
		adresse.setComplement("5ème sous sol");
		adresse.setCodePostal("33126");
		adresse.setVille("New-York");
		adresse.setPays("USA");
		adresse.setClient(tristan);
		
		adresse = adresseRepo.save(adresse);
		
		Adresse adresseFind = adresseRepo.findById(adresse.getId());
		
		Assert.assertEquals("8 route de Loiseau", adresseFind.getRue());
		Assert.assertEquals("5ème sous sol", adresseFind.getComplement());
		Assert.assertEquals("33126", adresseFind.getCodePostal());
		Assert.assertEquals("New-York", adresseFind.getVille());
		Assert.assertEquals("USA", adresseFind.getPays());
		Assert.assertEquals(tristan.getId(), adresseFind.getClient().getId());
		
		adresseRepo.delete(adresse);
		clientRepo.delete(tristan);
	}
	
	@Test
	public void adresseFindAllAndDelete() {
		IAdresseRepository adresseRepo = Application.getInstance().getAdresseRepo();
		
		Adresse adresse1 = new Adresse();
		adresse1.setRue("9 rue Georges Bonnac");
		adresse1.setComplement("3ème étage");
		adresse1.setCodePostal("33000");
		adresse1.setVille("Bordeaux");
		adresse1.setPays("France");

		Adresse adresse2 = new Adresse();
		adresse2.setRue("8 route de Loiseau");
		adresse2.setCodePostal("33126");
		adresse2.setVille("Fronsac");
		adresse2.setPays("France");

		Adresse adresse3 = new Adresse();
		adresse3.setRue("20 Avenue de Pythagore");
		adresse3.setCodePostal("33700");
		adresse3.setVille("Mérignac");
		adresse3.setPays("France");
		
		adresse1 = adresseRepo.save(adresse1);
		adresse2 = adresseRepo.save(adresse2);
		adresse3 = adresseRepo.save(adresse3);
		
		List<Adresse> adresses = adresseRepo.findAll();
		
		Assert.assertEquals(3, adresses.size());
		
		adresseRepo.delete(adresse1);
		adresseRepo.delete(adresse2);
		adresseRepo.delete(adresse3);
		
		adresses = adresseRepo.findAll();
		
		Assert.assertEquals(0, adresses.size());
	}
}
