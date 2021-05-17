package sopra.vol.model;

public class Billet {
	private long id;
	private String numeroPlace;
	private String classe;
	private float prix;
	private Reservation reservation;
	private Vol vol;
	
	public Billet() {
		this(0, null, null, 0.0f, null, null);
	}
	
	public Billet(long id, String numeroPlace, String classe, float prix, Reservation reservation, Vol vol) {
		this.id = id;
		this.numeroPlace = numeroPlace;
		this.classe = classe;
		this.prix = prix;
		this.reservation = reservation;
		this.vol = vol;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumeroPlace() {
		return numeroPlace;
	}

	public void setNumeroPlace(String numeroPlace) {
		this.numeroPlace = numeroPlace;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}
}
