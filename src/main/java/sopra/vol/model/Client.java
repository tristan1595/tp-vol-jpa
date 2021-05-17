package sopra.vol.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="client")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type")
public abstract class Client {
	
	@Id
	@GeneratedValue
	private long id;
	@Column(name="name", length=100)
	private String name;
	@OneToMany(mappedBy = "client")
	private List<Adresse> adresses;
	@OneToMany(mappedBy = "client")
	private List<Reservation> reservations;
	
	public Client() {
		super();
	}

	public Client(long id, String name) {
		this.id = id;
		this.name = name;
		adresses = new ArrayList<Adresse>();
		reservations = new ArrayList<Reservation>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Adresse> getAdresses() {
		return adresses;
	}
	
	public void ajouterAdresses(Adresse adresse) {
		adresses.add(adresse);
	}
	
	public List<Reservation> getReservations() {
		return reservations;
	}
	
	public void ajouterReservation(Reservation reservation) {
		reservations.add(reservation);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("##########################\n");
		builder.append("### INFORMATION CLIENT ###\n");
		builder.append("##########################\n");
		builder.append("id = " + id + "\n");
		builder.append("nom = " + name + "\n");
		return builder.toString();
	}
	
	public String adressesString() {
		StringBuilder builder = new StringBuilder();
		if(adresses.size() != 0) {
			for(Adresse a : adresses) {
				builder.append(a.toString());
			}
		}
		else {
			builder.append("Pas d'adresses associées\n");
		}
		return builder.toString();
	}
	
//	public void setReservations(List<Reservation> reservations) {
//		this.reservations = reservations;
//	}
	
//	public void setAdresses(List<Adresse> adresses) {
//	this.adresses = adresses;
//}
}
