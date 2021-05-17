package sopra.vol.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("person")
public class Particulier extends Client {
	@Column(name="first_name", length=100)
	private String prenom;
	
	public Particulier() {
		super();
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
