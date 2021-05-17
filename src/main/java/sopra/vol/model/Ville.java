package sopra.vol.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class Ville {
	@Id
	@GeneratedValue
	private long id;
	@Column(name = "name")
	private String nom;
	@ManyToMany(mappedBy = "villes")
	private List<Aeroport> aeroports;
	
	
}
