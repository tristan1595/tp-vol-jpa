package sopra.vol.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "booking")
public class Reservation {
	@Id
	private Integer numero;
	@Column(name = "booking_date")
	private Date dtReservation;
	@Enumerated(EnumType.STRING)
	@Column(name = "booking_state")
	private StatutReservation statut;
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Client client;
	@OneToOne
	@JoinColumn(name = "passenger_id")
	private Passager passager;
	@OneToMany(mappedBy = "reservation")
	private List<Billet> billets = new ArrayList<>();
	
	public Reservation() {
		super();
	}


	public Reservation(Integer numero) {
		super();
		this.numero = numero;
	}

	public Reservation(Integer numero, Date dtReservation, StatutReservation statut) {
		super();
		this.numero = numero;
		this.dtReservation = dtReservation;
		this.statut = statut;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Date getDtReservation() {
		return dtReservation;
	}

	public void setDtReservation(Date dtReservation) {
		this.dtReservation = dtReservation;
	}

	public StatutReservation getStatut() {
		return statut;
	}

	public void setStatut(StatutReservation statut) {
		this.statut = statut;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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

	public void setBillets(List<Billet> billets) {
		this.billets = billets;
	}

}
