package sopra.vol.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("company")
public class Entreprise extends Client {
	@Column(name = "siret_number")
	private String siret;
	@Column(name = "tva_number")
	private String numeroTVA;
	@Enumerated(EnumType.STRING)
	@Column(name = "legal_status")
	private StatutJuridique statutJuridique;

	public Entreprise() {
		super();
	}
	
	public Entreprise(String nom) {
		super(nom);
	}

	public Entreprise(Long id, String nom) {
		super(id, nom);
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public String getNumeroTVA() {
		return numeroTVA;
	}

	public void setNumeroTVA(String numeroTVA) {
		this.numeroTVA = numeroTVA;
	}

	public StatutJuridique getStatutJuridique() {
		return statutJuridique;
	}

	public void setStatutJuridique(StatutJuridique statutJuridique) {
		this.statutJuridique = statutJuridique;
	}

}
