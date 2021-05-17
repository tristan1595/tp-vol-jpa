package sopra.vol.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import sopra.vol.Application;
import sopra.vol.model.Adresse;
import sopra.vol.model.Aeroport;
import sopra.vol.model.CompagnieAerienne;
import sopra.vol.model.CompagnieAerienneVol;
import sopra.vol.model.Entreprise;
import sopra.vol.model.Particulier;
import sopra.vol.model.Passager;
import sopra.vol.model.Reservation;
import sopra.vol.model.StatutJuridique;
import sopra.vol.model.StatutReservation;
import sopra.vol.model.StatutVol;
import sopra.vol.model.TypeIdentite;
import sopra.vol.model.Ville;
import sopra.vol.model.Vol;
import sopra.vol.repository.IAdresseRepository;
import sopra.vol.repository.IAeroportRepository;
import sopra.vol.repository.IBilletRepository;
import sopra.vol.repository.IClientRepository;
import sopra.vol.repository.ICompagnieAerienneRepository;
import sopra.vol.repository.ICompagnieAerienneVolRepository;
import sopra.vol.repository.IPassagerRepository;
import sopra.vol.repository.IReservationRepository;
import sopra.vol.repository.IVilleRepository;
import sopra.vol.repository.IVolRepository;

public class TestTristan {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		IAdresseRepository adresseRepo 								= Application.getInstance().getAdresseRepo();
		IAeroportRepository aeroportRepo 							= Application.getInstance().getAeroportRepo();
		IBilletRepository billetRepo 								= Application.getInstance().getBilletRepo();
		IClientRepository clientRepo 								= Application.getInstance().getClientRepo(); 
		ICompagnieAerienneRepository compagnieAerienneRepo 			= Application.getInstance().getCompagnieAerienneRepo();
		ICompagnieAerienneVolRepository compagnieAerienneVolRepo 	= Application.getInstance().getCompagnieAerienneVolRepo();
		IPassagerRepository passagerRepo 							= Application.getInstance().getPassagerRepo();
		IReservationRepository reservationRepo 						= Application.getInstance().getReservationRepo();
		IVilleRepository villeRepo 									= Application.getInstance().getVilleRepo();
		IVolRepository volRepo 										= Application.getInstance().getVolRepo();
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// CREATION OBJETS /////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// ADRESSES
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

		// CLIENTS
		Particulier tristan = new Particulier();
		tristan.setName("Poul");
		tristan.setPrenom("Tristan");

		Entreprise sopraSteria = new Entreprise();
		sopraSteria.setName("Sopra Steria");
		sopraSteria.setSiret("32682006500083");
		sopraSteria.setNumeroTVA("FR18326820065");
		sopraSteria.setStatutJuridique(StatutJuridique.SA);

		// PASSAGERS
		Passager p1 = new Passager();
		p1.setNom("Poul");
		p1.setPrenom("Tristan");
		p1.setNumeroIdentite("110533500305");
		p1.setTypeIdentite(TypeIdentite.CARTE_IDENTITE);

		Passager p2 = new Passager();
		p2.setNom("Lalane");
		p2.setPrenom("Francis");
		p2.setNumeroIdentite("123486894948");
		p2.setTypeIdentite(TypeIdentite.PASSEPORT);

		Passager p3 = new Passager();
		p3.setNom("Macron");
		p3.setPrenom("Brigitte");
		p3.setNumeroIdentite("016358596320");
		p3.setTypeIdentite(TypeIdentite.CARTE_IDENTITE);

		// RESERVATIONS
		Reservation resaP1 = new Reservation();
		resaP1.setNumero(461865);
		resaP1.setDtReservation(sdf.parse("25/06/2021"));
		resaP1.setStatut(StatutReservation.CONFIRMER);

		Reservation resaP2 = new Reservation();
		resaP2.setNumero(985467);
		resaP2.setDtReservation(sdf.parse("02/09/2021"));
		resaP2.setStatut(StatutReservation.ANNULER);

		Reservation resaP3 = new Reservation();
		resaP3.setNumero(800012);
		resaP3.setDtReservation(sdf.parse("13/01/2022"));
		resaP3.setStatut(StatutReservation.CONFIRMER);

		// VILLES
		Ville bordeaux = new Ville();
		bordeaux.setNom("Bordeaux");

		Ville paris = new Ville();
		paris.setNom("Paris");

		Ville newYork = new Ville();
		newYork.setNom("New-York");

		Ville london = new Ville();
		london.setNom("London");

		// AEROPORTS
		Aeroport aeroportBordeaux = new Aeroport("BOD");
		aeroportBordeaux.setNom("Aéroport de Bordeaux");

		Aeroport aeroportParisOrly = new Aeroport("ORL");
		aeroportParisOrly.setNom("Aéroport de Paris-Orly");

		Aeroport aeroportParisCharlesDeGaulle = new Aeroport("CDG");
		aeroportParisCharlesDeGaulle.setNom("Aéroport de Paris-Charles de Gaulle");

		Aeroport aeroporteNewYorkJFK = new Aeroport("JFK");
		aeroporteNewYorkJFK.setNom("Aéroport international John F. Kennedy");

		Aeroport aeroportLondresHeathrow = new Aeroport("LHR");
		aeroportLondresHeathrow.setNom("Aéroport de Londres Heathrow");

		// COMPAGNIES AERIENNES
		CompagnieAerienne ryanAir = new CompagnieAerienne("RYR");
		ryanAir.setNom("Ryanair");

		CompagnieAerienne airFrance = new CompagnieAerienne("AFR");
		airFrance.setNom("Air France");

		CompagnieAerienne deltaAirLines = new CompagnieAerienne("DAL");
		deltaAirLines.setNom("Delta Air Lines");

		CompagnieAerienne britishAirWays = new CompagnieAerienne("BAW");
		britishAirWays.setNom("British Airways");

		//VOLS
		Vol bordeauxParisCDG = new Vol();
		bordeauxParisCDG.setDtDepart(sdf.parse("25/07/2021"));
		bordeauxParisCDG.setDtArrivee(sdf.parse("26/07/2021"));
		bordeauxParisCDG.setStatutVol(StatutVol.OUVERT);
		bordeauxParisCDG.setNbPlaceDispo(249);

		Vol orlyBordeaux = new Vol();
		orlyBordeaux.setDtDepart(sdf.parse("01/02/2022"));
		orlyBordeaux.setDtArrivee(sdf.parse("01/02/2022"));
		orlyBordeaux.setStatutVol(StatutVol.OUVERT);
		orlyBordeaux.setNbPlaceDispo(123);

		Vol newYorkJFKLondresHeathrow = new Vol();
		newYorkJFKLondresHeathrow.setDtDepart(sdf.parse("13/05/2022"));
		newYorkJFKLondresHeathrow.setDtArrivee(sdf.parse("14/05/2022"));
		newYorkJFKLondresHeathrow.setStatutVol(StatutVol.FERME);
		newYorkJFKLondresHeathrow.setNbPlaceDispo(249);

		Vol parisCDGNewYorkJFK = new Vol();
		parisCDGNewYorkJFK.setDtDepart(sdf.parse("30/07/2021"));
		parisCDGNewYorkJFK.setDtArrivee(sdf.parse("31/07/2021"));
		parisCDGNewYorkJFK.setStatutVol(StatutVol.OUVERT);
		parisCDGNewYorkJFK.setNbPlaceDispo(89);

		Vol LondresHeathrowBordeaux = new Vol();
		LondresHeathrowBordeaux.setDtDepart(sdf.parse("09/09/2021"));
		LondresHeathrowBordeaux.setDtArrivee(sdf.parse("10/09/2021"));
		LondresHeathrowBordeaux.setStatutVol(StatutVol.FERME);
		LondresHeathrowBordeaux.setNbPlaceDispo(32);
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// CREATION BDD ////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// ADRESSES
		adresse1 = adresseRepo.save(adresse1);
		adresse2 = adresseRepo.save(adresse2);
		adresse3 = adresseRepo.save(adresse3);

		// CLIENTS
		tristan = (Particulier) clientRepo.save(tristan);
		sopraSteria = (Entreprise) clientRepo.save(sopraSteria);

		// LIENS CLIENTS ADRESSES
		adresse1.setClient(tristan);
		adresse2.setClient(tristan);
		adresse3.setClient(sopraSteria);

		adresse1 = adresseRepo.save(adresse1);
		adresse2 = adresseRepo.save(adresse2);
		adresse3 = adresseRepo.save(adresse3);

		// PASSAGERS
		p1 = passagerRepo.save(p1);
		p2 = passagerRepo.save(p2);
		p3 = passagerRepo.save(p3);

		// RESERVATION + LIENS PASSAGERS & CLIENTS
		resaP1.setPassager(p1);
		resaP2.setPassager(p2);
		resaP3.setPassager(p3);

		resaP1.setClient(tristan);
		resaP2.setClient(sopraSteria);
		resaP3.setClient(sopraSteria);

		resaP1 = reservationRepo.save(resaP1);
		resaP2 = reservationRepo.save(resaP2);
		resaP3 = reservationRepo.save(resaP3);

		// AEROPORTS
		aeroportBordeaux = aeroportRepo.save(aeroportBordeaux);
		aeroportParisOrly = aeroportRepo.save(aeroportParisOrly);
		aeroportParisCharlesDeGaulle = aeroportRepo.save(aeroportParisCharlesDeGaulle);
		aeroporteNewYorkJFK = aeroportRepo.save(aeroporteNewYorkJFK);
		aeroportLondresHeathrow = aeroportRepo.save(aeroportLondresHeathrow);

		// VILLES
		bordeaux = villeRepo.save(bordeaux);
		paris = villeRepo.save(paris);
		newYork = villeRepo.save(newYork);
		london = villeRepo.save(london);

		// LIENS AEROPORTS & VILLES
		bordeaux.getAeroports().add(aeroportBordeaux);
		paris.getAeroports().add(aeroportParisCharlesDeGaulle);
		paris.getAeroports().add(aeroportParisOrly);
		newYork.getAeroports().add(aeroporteNewYorkJFK);
		london.getAeroports().add(aeroportLondresHeathrow);

		aeroportBordeaux.getVilles().add(newYork);
		aeroportBordeaux.getVilles().add(london);
		aeroportBordeaux.getVilles().add(paris);

		aeroportParisCharlesDeGaulle.getVilles().add(bordeaux);
		aeroportParisCharlesDeGaulle.getVilles().add(newYork);
		aeroportParisCharlesDeGaulle.getVilles().add(london);

		aeroportParisOrly.getVilles().add(bordeaux);
		aeroportParisOrly.getVilles().add(newYork);
		aeroportParisOrly.getVilles().add(london);

		aeroporteNewYorkJFK.getVilles().add(bordeaux);
		aeroporteNewYorkJFK.getVilles().add(paris);
		aeroporteNewYorkJFK.getVilles().add(london);

		aeroportLondresHeathrow.getVilles().add(bordeaux);
		aeroportLondresHeathrow.getVilles().add(paris);
		aeroportLondresHeathrow.getVilles().add(newYork);

		bordeaux = villeRepo.save(bordeaux);
		paris = villeRepo.save(paris);
		newYork = villeRepo.save(newYork);
		london = villeRepo.save(london);

		aeroportBordeaux = aeroportRepo.save(aeroportBordeaux);
		aeroportParisOrly = aeroportRepo.save(aeroportParisOrly);
		aeroportParisCharlesDeGaulle = aeroportRepo.save(aeroportParisCharlesDeGaulle);
		aeroporteNewYorkJFK = aeroportRepo.save(aeroporteNewYorkJFK);
		aeroportLondresHeathrow = aeroportRepo.save(aeroportLondresHeathrow);

		// VOLS
		bordeauxParisCDG.setArrivee(aeroportParisCharlesDeGaulle);
		bordeauxParisCDG.setDepart(aeroportBordeaux);
		bordeauxParisCDG = volRepo.save(bordeauxParisCDG);

		orlyBordeaux.setArrivee(aeroportBordeaux);
		orlyBordeaux.setDepart(aeroportBordeaux);
		orlyBordeaux = volRepo.save(orlyBordeaux);

		newYorkJFKLondresHeathrow.setArrivee(aeroportLondresHeathrow);
		newYorkJFKLondresHeathrow.setDepart(aeroporteNewYorkJFK);
		newYorkJFKLondresHeathrow = volRepo.save(newYorkJFKLondresHeathrow);

		parisCDGNewYorkJFK.setArrivee(aeroporteNewYorkJFK);
		parisCDGNewYorkJFK.setDepart(aeroportParisCharlesDeGaulle);
		parisCDGNewYorkJFK = volRepo.save(parisCDGNewYorkJFK);

		LondresHeathrowBordeaux.setArrivee(aeroportBordeaux);
		LondresHeathrowBordeaux.setDepart(aeroportLondresHeathrow);
		LondresHeathrowBordeaux = volRepo.save(LondresHeathrowBordeaux);

		// COMPAGNIES AERIENNES
		ryanAir = compagnieAerienneRepo.save(ryanAir);
		airFrance = compagnieAerienneRepo.save(airFrance);
		deltaAirLines = compagnieAerienneRepo.save(deltaAirLines);
		britishAirWays = compagnieAerienneRepo.save(britishAirWays);

		// LIEN COMPAGNIES AERIENNES & VOLS
		CompagnieAerienneVol BordeauxCDGRyanAir = new CompagnieAerienneVol();
		BordeauxCDGRyanAir.setCompagnieAerienne(ryanAir);
		BordeauxCDGRyanAir.setVol(bordeauxParisCDG);
		BordeauxCDGRyanAir.setNumeroVol(bordeauxParisCDG.getId().toString());

		List<Ville> villesDesservieAeroportBordeaux = aeroportRepo.findById(aeroportBordeaux.getCode()).getVilles();
		List<Aeroport> aeroportDansBordeaux = villeRepo.findById(bordeaux.getId()).getAeroports();

		System.out.println("VILLES DESSERVIES PAR L'AEROPORT DE BORDEAUX");
		for (Ville v : villesDesservieAeroportBordeaux) {
			System.out.println(v.getNom());
		}

		System.out.println("AEROPORT DESSERVIES PAR LA VILLE DE BORDEAUX");
		for (Aeroport a : aeroportDansBordeaux) {
			System.out.println(a.getNom());
		}

		
	}
}
