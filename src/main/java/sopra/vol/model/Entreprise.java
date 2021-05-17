package sopra.vol.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("company")
public class Entreprise extends Client {
	@Column(name="siret_number", length=100)
	private String siret;
	@Column(name="tva_rate", length=100)
	private String numeroTva;
	@Column(name="legal_status", length=100)
	@Enumerated(EnumType.STRING)
	private StatutJuridique statutJuridique;
	
	public Entreprise() {
		super();
	}
	
	public Entreprise(long id, String name, String siret, String numeroTva, StatutJuridique statutJuridique) {
		super(id, name);
		this.siret = siret;
		this.numeroTva = numeroTva;
		this.statutJuridique = statutJuridique;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public String getNumeroTva() {
		return numeroTva;
	}

	public void setNumeroTva(String numeroTva) {
		this.numeroTva = numeroTva;
	}

	public StatutJuridique getStatutJuridique() {
		return statutJuridique;
	}

	public void setStatutJuridique(StatutJuridique statutJuridique) {
		this.statutJuridique = statutJuridique;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("Siret = " + siret + "\n");
		builder.append("Numéro de TVA = " + numeroTva + "\n");
		builder.append("Statut juridique = " + statutJuridique + "\n");
		builder.append(super.adressesString());
		return builder.toString();
	}
	
	
}
