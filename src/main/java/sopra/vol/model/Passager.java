package sopra.vol.model;

public class Passager {
	private long id;
	private String nom;
	private String prenom;
	private String numeroIdentite;
	private TypeIdentite typeIdentite;
	private Reservation reservation;

	public Passager() {
		this(0, null, null, null, null, null);
	}
	
	public Passager(long id, String nom, String prenom, String numeroIdentite, TypeIdentite typeIdentite, Reservation reservation) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.numeroIdentite = numeroIdentite;
		this.typeIdentite = typeIdentite;
		this.reservation = reservation;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNumeroIdentite() {
		return numeroIdentite;
	}

	public void setNumeroIdentite(String numeroIdentite) {
		this.numeroIdentite = numeroIdentite;
	}

	public TypeIdentite getTypeIdentite() {
		return typeIdentite;
	}

	public void setTypeIdentite(TypeIdentite typeIdentite) {
		this.typeIdentite = typeIdentite;
	}
	
	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("### Passager \n");
		builder.append("id = " + id + "\n");
		builder.append("nom = " + nom + "\n");
		builder.append("prenom = " + prenom + "\n");
		builder.append("Numéro d'identité = " + numeroIdentite + "\n");
		builder.append("Type d'identité = " + typeIdentite + "\n");
		return builder.toString();
	}
}
