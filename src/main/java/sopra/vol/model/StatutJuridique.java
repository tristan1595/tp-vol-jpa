package sopra.vol.model;

public enum StatutJuridique {
	SA("SA"),
	SAS("SAS"),
	SASU("SASU"),
	EURL("EURL"),
	SARL("SARL"),
	EI("EI");
	
	public final String label;
	
	private StatutJuridique(String label) {
		this.label = label;
	}
}
