package sopra.vol.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "airport")
public class Aeroport {
	@Id
	@Column(name = "code")
	private String code;
	@Column(name = "name")
	private String nom;
	@ManyToMany
	@JoinTable(name = "destinations", joinColumns = @JoinColumn(name = "airport_code"), inverseJoinColumns = @JoinColumn(name = "city_id"))
	private List<Ville> villes; 
	
	public Aeroport() {
		this(null, null);
	}

	public Aeroport(String code, String name) {
		this.code = code;
		this.nom = name;
		villes = new ArrayList<Ville>();
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
	
	public List<Ville> getVilles() {
		return this.villes;
	}

//	public void setVilles(List<Ville> villes) {
//		this.villes = villes;
//	}
	
	public void ajouterVille(Ville ville) {
		this.villes.add(ville);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Aeroport : code = " + code + ", nom = " + nom + "\n");
		builder.append("Villes desservies : \n");
		int i = 0;
		for(Ville v : villes) {
			builder.append("Ville n°" + (i+1) + " " + v.getName());
			builder.append("\n");
			i++;
		}
		
		return builder.toString();
	}
}
