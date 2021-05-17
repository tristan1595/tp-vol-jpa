package sopra.vol.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "airline_company")
public class CompagnieAerienne {
	@Id
	@Column(name = "code")
	private String code;
	@Column(name = "name")
	private String nom;
	@OneToMany(mappedBy = "compagnieAerienne")
	private List<CompagnieAerienneVol> compagnieAerienneVol;
	
}
