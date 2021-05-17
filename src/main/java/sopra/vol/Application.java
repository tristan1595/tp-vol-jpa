package sopra.vol;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sopra.vol.repository.IAdresseRepository;
import sopra.vol.repository.IAeroportRepository;
import sopra.vol.repository.IBilletRepository;
import sopra.vol.repository.IClientRepository;
import sopra.vol.repository.ICompagnieAerienneRepository;
import sopra.vol.repository.ICompagnieAerienneVolRepository;
import sopra.vol.repository.IPassagerRepository;
import sopra.vol.repository.IReservationRepository;
import sopra.vol.repository.IVilleRepository;
import sopra.vol.repository.IVolRepository;
import sopra.vol.repository.jpa.AdresseRepositoryJpa;
import sopra.vol.repository.jpa.AeroportRepositoryJpa;
import sopra.vol.repository.jpa.BilletRepositoryJpa;
import sopra.vol.repository.jpa.ClientRepositoryJpa;
import sopra.vol.repository.jpa.CompagnieAerienneRepositoryJpa;
import sopra.vol.repository.jpa.CompagnieAerienneVolRepositoryJpa;
import sopra.vol.repository.jpa.PassagerRepositoryJpa;
import sopra.vol.repository.jpa.ReservationRepositoryJpa;
import sopra.vol.repository.jpa.VilleRepositoryJpa;
import sopra.vol.repository.jpa.VolRepositoryJpa;

public class Application {
	private static Application instance = null;
	
	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp-vol-jpa");
	
	private final IAdresseRepository adresseRepo = new AdresseRepositoryJpa();
	private final IAeroportRepository aeroportRepo = new AeroportRepositoryJpa();
	private final IBilletRepository billetRepo = new BilletRepositoryJpa();
	private final IClientRepository clientRepo = new ClientRepositoryJpa();
	private final ICompagnieAerienneRepository compagnieAerienneRepo = new CompagnieAerienneRepositoryJpa();
	private final ICompagnieAerienneVolRepository compagnieAerienneVolRepo = new CompagnieAerienneVolRepositoryJpa();
	private final IPassagerRepository passagerRepo = new PassagerRepositoryJpa();
	private final IReservationRepository reservationRepo = new ReservationRepositoryJpa();
	private final IVilleRepository villeRepo = new VilleRepositoryJpa();
	private final IVolRepository volRepo = new VolRepositoryJpa();
	
	private Application() {
		
	}
	
	public static Application getInstance() {
		if(instance == null) {
			instance = new Application();
		}
		
		return instance;
	}
	
	public EntityManagerFactory getEmf() {
		return emf;
	}

	public IAdresseRepository getAdresseRepo() {
		return adresseRepo;
	}

	public IAeroportRepository getAeroportRepo() {
		return aeroportRepo;
	}

	public IBilletRepository getBilletRepo() {
		return billetRepo;
	}

	public IClientRepository getClientRepo() {
		return clientRepo;
	}

	public ICompagnieAerienneRepository getCompagnieAerienneRepo() {
		return compagnieAerienneRepo;
	}

	public ICompagnieAerienneVolRepository getCompagnieAerienneVolRepo() {
		return compagnieAerienneVolRepo;
	}

	public IPassagerRepository getPassagerRepo() {
		return passagerRepo;
	}

	public IReservationRepository getReservationRepo() {
		return reservationRepo;
	}

	public IVilleRepository getVilleRepo() {
		return villeRepo;
	}

	public IVolRepository getVolRepo() {
		return volRepo;
	}
}
