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
	
}
