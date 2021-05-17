package sopra.vol.model;

public class CompagnieAerienneVol {
	private long id;
	private String numeroVol;
	private CompagnieAerienne compagnieAerienne;
	private Vol vol;

	public CompagnieAerienneVol() {
		this(0, null, null, null);
	}
	
	public CompagnieAerienneVol(long id, String numeroVol,CompagnieAerienne compagnieAerienne, Vol vol) {
		this.id = id;
		this.numeroVol = numeroVol;
		this.compagnieAerienne = compagnieAerienne;
		this.vol = vol;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumeroVol() {
		return numeroVol;
	}

	public void setNumeroVol(String numeroVol) {
		this.numeroVol = numeroVol;
	}
	
	public CompagnieAerienne getCompagnieAerienne() {
		return compagnieAerienne;
	}

	public void setCompagnieAerienne(CompagnieAerienne compagnieAerienne) {
		this.compagnieAerienne = compagnieAerienne;
	}

	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}
}
