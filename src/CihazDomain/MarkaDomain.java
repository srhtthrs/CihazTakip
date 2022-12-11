package CihazDomain;

public class MarkaDomain {
	
	
	
	private int id;
	
	private String marka;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	@Override
	public String toString() {
		return marka;
	}
	
	

}
