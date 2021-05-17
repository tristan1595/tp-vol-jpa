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
	
}
