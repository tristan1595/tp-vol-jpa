package sopra.vol.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flight")
public class Vol {
	@Id
	@GeneratedValue
	private long id;
	private Date dtDepart; 
	private Date dtArrivee; 
	private StatutVol statutVol;
	private int nbPlaceDispo;
	private Aeroport aeroportArrivee;
	private Aeroport aeroportDepart;
	private List<Billet> billets;
	private List<CompagnieAerienneVol> compagnieAerienneVol;
	
	public Vol() {
		this(0, null, null, null, 0, null, null);
	}

	public Vol(long id, Date dtDepart, Date dtArrivee, StatutVol statutVol, int nbPlaceDispo, Aeroport aeroportArrivee, Aeroport aeroportDepart) {
		this.id = id;
		this.dtDepart = dtDepart;
		this.dtArrivee = dtArrivee;
		this.statutVol = statutVol;
		this.nbPlaceDispo = nbPlaceDispo;
		this.aeroportArrivee = aeroportArrivee;
		this.aeroportDepart = aeroportDepart;
		this.billets = new ArrayList<Billet>();
		this.compagnieAerienneVol = new ArrayList<CompagnieAerienneVol>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDtDepart() {
		return dtDepart;
	}

	public void setDtDepart(Date dtDepart) {
		this.dtDepart = dtDepart;
	}

	public Date getDtArrivee() {
		return dtArrivee;
	}

	public void setDtArrivee(Date dtArrivee) {
		this.dtArrivee = dtArrivee;
	}

	public StatutVol getStatutVol() {
		return statutVol;
	}

	public void setStatutVol(StatutVol statutVol) {
		this.statutVol = statutVol;
	}

	public int getNbPlaceDispo() {
		return nbPlaceDispo;
	}

	public void setNbPlaceDispo(int nbPlaceDispo) {
		this.nbPlaceDispo = nbPlaceDispo;
	}

	public Aeroport getAeroportArrivee() {
		return aeroportArrivee;
	}

	public void setAeroportArrivee(Aeroport aeroportArrivee) {
		this.aeroportArrivee = aeroportArrivee;
	}

	public Aeroport getAeroportDepart() {
		return aeroportDepart;
	}

	public void setAeroportDepart(Aeroport aeroportDepart) {
		this.aeroportDepart = aeroportDepart;
	}

	public List<Billet> getBillets() {
		return this.billets;
	}
	
	public void ajouterBillet(Billet billet) {
		this.billets.add(billet);
	}
	
	public List<CompagnieAerienneVol> getCompagnieAerienneVol() {
		return this.compagnieAerienneVol;
	}

	public void ajouterCompagnieAerienneVol(CompagnieAerienneVol compagnieAerienneVol) {
		this.compagnieAerienneVol.add(compagnieAerienneVol);
	}
	
//	public void setCompagnieAerienneVol(List<CompagnieAerienneVol> compagnieAerienneVol) {
//		this.compagnieAerienneVol = compagnieAerienneVol;
//	}

//	public void setBillets(List<Billet> billets) {
//		this.billets = billets;
//	}
}
