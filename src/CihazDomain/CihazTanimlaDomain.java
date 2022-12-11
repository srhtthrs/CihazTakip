package CihazDomain;

public class CihazTanimlaDomain {
	
	private int id;
	
	private String isyeri;
	private String cihazTuru;
	private String marka;
	private String model;
	private String macadresi;
	private String seriNo;
	private String gBTarih;
	private String gSuresi;
	private String zPSicili;
	private String aciklama;
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
	public String getCihazTuru() {
		return cihazTuru;
	}
	public void setCihazTuru(String cihazTuru) {
		this.cihazTuru = cihazTuru;
	}
	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMacadresi() {
		return macadresi;
	}
	public void setMacadresi(String macadresi) {
		this.macadresi = macadresi;
	}
	public String getSeriNo() {
		return seriNo;
	}
	public void setSeriNo(String seriNo) {
		this.seriNo = seriNo;
	}
	public String getgBTarih() {
		return gBTarih;
	}
	public void setgBTarih(String gBTarih) {
		this.gBTarih = gBTarih;
	}
	public String getgSuresi() {
		return gSuresi;
	}
	public void setgSuresi(String gSuresi) {
		this.gSuresi = gSuresi;
	}
	public String getzPSicili() {
		return zPSicili;
	}
	public void setzPSicili(String zPSicili) {
		this.zPSicili = zPSicili;
	}
	public String getAciklama() {
		return aciklama;
	}
	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
	@Override
	public String toString() {
	 	
		return cihazTuru+ "     marka: " + marka
				+ "     model: " + model + "     MAC: " + macadresi + "     Seri: " + seriNo + "     Garanti Baslayisi: " + gBTarih
				+ "     garanti Suresi: " + gSuresi + "     Zimmetli Personel Sicili: " + zPSicili + "     Aciklama: " + aciklama;
	}
	
	
	
	
	

}
