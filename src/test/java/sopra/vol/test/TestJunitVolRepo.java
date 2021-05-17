package sopra.vol.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;
import sopra.vol.Application;
import sopra.vol.model.Aeroport;
import sopra.vol.model.Billet;
import sopra.vol.model.CompagnieAerienne;
import sopra.vol.model.CompagnieAerienneVol;
import sopra.vol.model.StatutVol;
import sopra.vol.model.Vol;
import sopra.vol.repository.IAeroportRepository;
import sopra.vol.repository.IBilletRepository;
import sopra.vol.repository.ICompagnieAerienneVolRepository;
import sopra.vol.repository.IVolRepository;

public class TestJunitVolRepo extends TestCase {
	
	public void testDelete() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		IVolRepository volRepo = Application.getInstance().getVolRepo();
		
		Vol vol1 = new Vol(StatutVol.OUVERT, sdf.parse("11/11/11"), sdf.parse("20/10/20"), 200);
		vol1 = volRepo.save(vol1);
		
		System.out.println("COUCOU + " + volRepo.findAll().size());
		
		Assert.assertEquals(1, volRepo.findAll().size());
		
		volRepo.delete(vol1);
		
		Assert.assertEquals(0, volRepo.findAll().size());
	
	}
	
	public void testFindAll() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		IVolRepository volRepo = Application.getInstance().getVolRepo();
		IAeroportRepository aeroportRepo = Application.getInstance().getAeroportRepo();
		ICompagnieAerienneVolRepository compagnieAerienneVolRepo = Application.getInstance().getCompagnieAerienneVolRepo();
		IBilletRepository billetRepo = Application.getInstance().getBilletRepo();
		
		//--------------------SET--------------------//
		//UN VOL
		Vol bordeauxParisCDG = new Vol();
		
		//DEUX COMPAGNIES AERIENNES VOL
		CompagnieAerienneVol BordeauxCDGRyanAir = new CompagnieAerienneVol();
		compagnieAerienneVolRepo.save(BordeauxCDGRyanAir);
		
		CompagnieAerienneVol BordeauxCDGEasyJet = new CompagnieAerienneVol();
		compagnieAerienneVolRepo.save(BordeauxCDGEasyJet);
		
		List<CompagnieAerienneVol> comp = new ArrayList<CompagnieAerienneVol>();
		comp.add(BordeauxCDGRyanAir);
		
		//DEUX BILLETS
		Billet billet = new Billet("F14", "Eco", 144f, 14478);
		Billet billet2 = new Billet("A25", "Premiere", 401f, 4569);
		billetRepo.save(billet);
		billetRepo.save(billet2);
		List<Billet> billets = new ArrayList<Billet>();
		billets.add(billet);
		
		//DEUX AEROPORTS
		Aeroport aeroportBordeaux = new Aeroport("BOD");
		aeroportBordeaux.setNom("Aéroport de Bordeaux");
		aeroportRepo.save(aeroportBordeaux);
		
		Aeroport aeroportParisCharlesDeGaulle = new Aeroport("CDG");
		aeroportParisCharlesDeGaulle.setNom("Aéroport de Paris-Charles de Gaulle");
		aeroportRepo.save(aeroportParisCharlesDeGaulle);
		
		// SET LE VOL
		bordeauxParisCDG.setDtDepart(sdf.parse("25/07/2021"));
		bordeauxParisCDG.setDtArrivee(sdf.parse("26/07/2021"));
		bordeauxParisCDG.setStatutVol(StatutVol.OUVERT);
		bordeauxParisCDG.setNbPlaceDispo(249);
		bordeauxParisCDG.setCompagnieAeriennesVol(comp);
		bordeauxParisCDG.setBillets(billets);
		bordeauxParisCDG.setDepart(aeroportBordeaux);
		bordeauxParisCDG.setArrivee(aeroportParisCharlesDeGaulle);
		
		bordeauxParisCDG = volRepo.save(bordeauxParisCDG);
		Long id1 = bordeauxParisCDG.getId();
		
		bordeauxParisCDG = volRepo.findById(bordeauxParisCDG.getId());
		Long id2 = bordeauxParisCDG.getId();
		
		//--------------------MODIF--------------------//
		bordeauxParisCDG.setArrivee(aeroportBordeaux);
		bordeauxParisCDG.setDepart(aeroportParisCharlesDeGaulle);
		billets.add(billet2);
		bordeauxParisCDG.setBillets(billets);
		comp.add(BordeauxCDGEasyJet);
		bordeauxParisCDG.setCompagnieAeriennesVol(comp);
		bordeauxParisCDG.setDtDepart(sdf.parse("11/11/2021"));
		bordeauxParisCDG.setDtArrivee(sdf.parse("12/11/2021"));
		bordeauxParisCDG.setNbPlaceDispo(300);
		bordeauxParisCDG.setStatutVol(StatutVol.FERME);
		
		//-------------------ASSERT--------------------//
		Assert.assertEquals(300, bordeauxParisCDG.getNbPlaceDispo());
		Assert.assertEquals("FERME", bordeauxParisCDG.getStatutVol().toString());
		Assert.assertEquals("Aéroport de Bordeaux", bordeauxParisCDG.getArrivee().getNom());
		Assert.assertEquals("Aéroport de Paris-Charles de Gaulle", bordeauxParisCDG.getDepart().getNom());
		Assert.assertEquals(2, bordeauxParisCDG.getBillets().size());
		Assert.assertEquals(2, bordeauxParisCDG.getCompagnieAeriennesVol().size());
		Assert.assertEquals(sdf.parse("11/11/2021"), bordeauxParisCDG.getDtDepart());
		Assert.assertEquals(sdf.parse("12/11/2021"), bordeauxParisCDG.getDtArrivee());
		
		Assert.assertEquals(id1, id2);
		
		volRepo.delete(bordeauxParisCDG);
		compagnieAerienneVolRepo.delete(BordeauxCDGEasyJet);
		compagnieAerienneVolRepo.delete(BordeauxCDGRyanAir);
		aeroportRepo.delete(aeroportParisCharlesDeGaulle);
		aeroportRepo.delete(aeroportBordeaux);
		billetRepo.delete(billet2);
		billetRepo.delete(billet);
		
	}
	
	public void testFindById() throws ParseException {
		IVolRepository volRepo = Application.getInstance().getVolRepo();
		
		Vol vol1 = new Vol();
		vol1 = volRepo.save(vol1);
		
		Vol vol2 = new Vol();
		vol2 = volRepo.findById(vol1.getId());
		vol2 = volRepo.save(vol2);
		
		Assert.assertEquals(vol1.getId(), vol2.getId());
		
		volRepo.delete(vol2);
		volRepo.delete(vol1);
	}

}
