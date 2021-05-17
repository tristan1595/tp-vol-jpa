package sopra.vol.model;

import java.util.ArrayList;
import java.util.List;

public class Ville {
	private long id;
	private String nom;
	private List<Aeroport> aeroports;
	
	public Ville() {
		this(0, null);
	}
	
	public Ville(long id, String nom) {
		this.id = id;
		this.nom = nom;
		aeroports = new ArrayList<Aeroport>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return nom;
	}

	public void setName(String name) {
		this.nom = name;
	}
	
	public List<Aeroport> getAeroports() {
		return this.aeroports;
	}

//	public void setAeroports(List<Aeroport> aeroports) {
//		this.aeroports = aeroports;
//	}
	
	public void ajouterAeroport(Aeroport aeroport) {
		this.aeroports.add(aeroport);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ville id=" + id + ", nom=" + nom + "\n");
		builder.append("Aéroport de la ville : \n");
		int i = 0;
		for(Aeroport a : aeroports) {
			builder.append("Aeroport n°" + (i+1) + "\n" + a.getName());
			builder.append("\n");
			i++;
		}
		return builder.toString();
	}
	
}
