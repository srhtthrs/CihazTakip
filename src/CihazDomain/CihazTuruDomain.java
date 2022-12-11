package CihazDomain;

public class CihazTuruDomain {
	
	private int id;
	
	private String cihazturu;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCihazturu() {
		return cihazturu;
	}

	public void setCihazturu(String cihazturu) {
		this.cihazturu = cihazturu;
	}

	@Override
	public String toString() {
		return cihazturu;
	}
	
	

}
