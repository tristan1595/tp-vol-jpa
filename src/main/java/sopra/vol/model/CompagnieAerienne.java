package sopra.vol.model;

import java.util.ArrayList;
import java.util.List;

public class CompagnieAerienne {
	private String code;
	private String nom;
	private List<CompagnieAerienneVol> compagnieAerienneVol;
	
	public CompagnieAerienne() {
		this(null, null);
	}

	public CompagnieAerienne(String code, String nom) {
		super();
		this.code = code;
		this.nom = nom;
		compagnieAerienneVol = new ArrayList<CompagnieAerienneVol>();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return nom;
	}

	public void setName(String name) {
		this.nom = name;
	}	
	
	public List<CompagnieAerienneVol> getCompagnieAerienneVol() {
		return this.compagnieAerienneVol;
	}
	
	public void ajouterCompagnieAerienneVol(CompagnieAerienneVol compagnieAerienneVol) {
		this.compagnieAerienneVol.add(compagnieAerienneVol);
	}
	
//	public void setCompagnieAerienneVol(List<CompagnieAerienneVol> compagnieAerienneVol) {
//		this.compagnieAerienneVol = compagnieAerienneVol;
//  }
}
