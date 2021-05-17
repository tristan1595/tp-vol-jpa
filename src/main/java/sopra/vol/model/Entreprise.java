package sopra.vol.model;

public class Entreprise extends Client {
	private String siret;
	private String numeroTva;
	private StatutJuridique statutJuridique;
	
	public Entreprise() {
		this(0, null, null, null, null);
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
