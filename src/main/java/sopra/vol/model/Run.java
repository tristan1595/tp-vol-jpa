package sopra.vol.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Run {

	public static void main(String[] args) {
		Client c1 = new Particulier(0, "ValJean", "Jean");
		//System.out.println(c1);
		Client c2 = new Entreprise(0, "Sopra", "123H2JG234", "9998", StatutJuridique.SARL);
		//System.out.println(c2);
		
		Adresse a1 = new Adresse(0, "9 rue Georges Bonnac", "3ème étage", "33000", "Bordeaux", "France", c1);
		Adresse a2 = new Adresse(1, "8 route de Loiseau", null, "33126", "Fronsac", "France", c1);
		//System.out.println(a1);
		
		c1.ajouterAdresses(a1);
		c1.ajouterAdresses(a2);
		System.out.println(c1);
		
		Date resa = new Date();
		String dtResa = "15/03/2021";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //Très utile
		try {
			resa = sdf.parse(dtResa);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	
		Reservation r1 = new Reservation(0, resa, StatutReservation.CONFIRMER, null, c1);
		Passager p1 = new Passager(0, "Maurice", "Mauricette", "0", TypeIdentite.PASSEPORT, r1);
		System.out.println(p1);
		r1.setPassager(p1);
		
		System.out.println(r1);
//		
//		Ville v0 = new Ville(0, "Paris");
//		Ville v1 = new Ville(1, "New-York");
//		Ville v2 = new Ville(2, "Katmandou");
//		Ville v3 = new Ville(3, "Bogota");
//		
//		Aeroport ae0 = new Aeroport("0", "Aéroport de Paris");
//		Aeroport ae1 = new Aeroport("1", "Aéroport de New-York");
//		Aeroport ae2 = new Aeroport("2", "Aéroport de Katmandou");
//		Aeroport ae3 = new Aeroport("3", "Aéroport de Bogota");
//		
//		v0.ajouterAeroport(ae0);
//		v1.ajouterAeroport(ae1);
//		v2.ajouterAeroport(ae2);
//		v3.ajouterAeroport(ae3);
//		
//		ae0.ajouterVille(v1);
//		ae0.ajouterVille(v2);
//		ae0.ajouterVille(v3);
//		
//		ae1.ajouterVille(v0);
//		ae1.ajouterVille(v2);
//		ae1.ajouterVille(v3);
//		
//		ae2.ajouterVille(v0);
//		ae2.ajouterVille(v1);
//		ae2.ajouterVille(v3);
//		
//		ae3.ajouterVille(v0);
//		ae3.ajouterVille(v1);
//		ae3.ajouterVille(v3);
//		
//		System.out.println(ae0);
//		System.out.println(v0);
//		
//		Date dateDepart = new Date();
//		String dateDepartString = "02/06/2021";
//		try {
//			resa = sdf.parse(dateDepartString);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		
//		Date dateArrivee = new Date();
//		String dateArriveeString = "03/06/2021";
//		try {
//			resa = sdf.parse(dateArriveeString);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		
//		Vol vo0 = new Vol(0, dateDepart, dateArrivee, StatutVol.OUVERT, 230, ae0, ae1);
//		Billet b0 = new Billet(0, "45a", "Première", 457.0f, r1, vo0);
//		
//		vo0.ajouterBillet(b0);
//		r1.ajouterBillet(b0);
//		
//		CompagnieAerienne ca0 = new CompagnieAerienne("AXXY234", "Ryanair");
//		CompagnieAerienneVol cav0 = new CompagnieAerienneVol(0,"34BTY", ca0, vo0);
//		
//		vo0.ajouterCompagnieAerienneVol(cav0);
//		ca0.ajouterCompagnieAerienneVol(cav0);
	}
}
