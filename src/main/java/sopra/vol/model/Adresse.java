package sopra.vol.model;

public class Adresse {
	private long id;
	private String rue;
	private String complement;
	private String codePostal;
	private String ville;
	private String pays;
	private Client client;
	
	public Adresse() {
		this(0, null, null, null, null, null, null);
	}
	
	public Adresse(long id, String rue, String complement, String codePostal, String ville, String pays, Client client) {
		this.id = id;
		this.rue = rue;
		this.complement = complement;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
		this.client = client;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("### adresse ### \n");
		builder.append("id = " + id + "\n" );
		builder.append("rue = " + rue + "\n");
		if(complement != null) {
			builder.append("complement = " + complement + "\n");
		}
		builder.append("codePostal = " + codePostal + "\n");
		builder.append("ville = " + ville + "\n");
		builder.append("pays = " + pays + "\n");
		return builder.toString();
	}
}
