package sopra.vol.model;

public class Particulier extends Client {
	private String prenom;
	
	public Particulier() {
		this(0, null, null);
	}

	public Particulier(long id, String name, String prenom) {
		super(id, name);
		this.prenom = prenom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("Prénom = " + prenom + "\n");
		builder.append(super.adressesString());
		return builder.toString();
	}
}
