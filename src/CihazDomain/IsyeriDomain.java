package CihazDomain;

public class IsyeriDomain {
	
	private int id;
	
	private String isyeri;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsyeri() {
		return isyeri;
	}

	public void setIsyeri(String isyeri) {
		this.isyeri = isyeri;
	}

	@Override
	public String toString() {
		return isyeri;
	}
	
		
	

}