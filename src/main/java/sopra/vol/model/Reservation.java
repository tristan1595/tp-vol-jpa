package sopra.vol.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reservation {
	private int numero;
	private Date dtReservation;
	private StatutReservation confirme;
	private Passager passager;
	private List<Billet> billets;
	private Client client;
	
	public Reservation() {
		this(0, null, null, null, null);
	}

	public Reservation(int numero, Date dtReservation, StatutReservation confirme, Passager passager, Client client) {
		this.numero = numero;
		this.dtReservation = dtReservation;
		this.confirme = confirme;
		this.passager = passager;
		this.billets = new ArrayList<Billet>();
		this.client = client;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getDtReservation() {
		return dtReservation;
	}

	public void setDtReservation(Date dtReservation) {
		this.dtReservation = dtReservation;
	}

	public StatutReservation getConfirme() {
		return confirme;
	}

	public void setConfirme(StatutReservation confirme) {
		this.confirme = confirme;
	}
	
	public Passager getPassager() {
		return passager;
	}

	public void setPassager(Passager passager) {
		this.passager = passager;
	}
	
	public List<Billet> getBillets() {
		return billets;
	}
	
	public void ajouterBillet(Billet billet) {
		billets.add(billet);
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public float prixTotal() {
		float prixTot = 0;
		for(Billet b : billets) {
			prixTot += b.getPrix();
		}
		return prixTot;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("###############################\n");
		builder.append("### INFORMATION RESERVATION ###\n");
		builder.append("###############################\n");
		builder.append("numero = " + numero + "\n");
		builder.append("Date de réservation = " + dtReservation + "\n");
		builder.append("Statue réservation = " + confirme + "\n");
		builder.append(client.toString());
		builder.append(passager.toString());
		return builder.toString();
	}
	
	
	
//	public void setVols(List<Vol> vols) {
//		this.vols = vols;
//	}
}
