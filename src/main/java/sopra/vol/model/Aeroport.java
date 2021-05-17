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
	
}
