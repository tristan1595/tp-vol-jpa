package sopra.vol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "airline_company_flight")
public class CompagnieAerienneVol {
	@Id
	@GeneratedValue
	private long id;
	@Column(name = "flight_number")
	private String numeroVol;
	@ManyToOne
	@JoinColumn(name = "airline_company_id")
	private CompagnieAerienne compagnieAerienne;
	@ManyToOne
	@JoinColumn(name = "flight_id")
	private Vol vol;

	public CompagnieAerienneVol() {
		super();
	}
	
	public CompagnieAerienneVol(String numeroVol) {
		super();
		this.numeroVol = numeroVol;
	}

	public CompagnieAerienneVol(Long id, String numeroVol) {
		super();
		this.id = id;
		this.numeroVol = numeroVol;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
