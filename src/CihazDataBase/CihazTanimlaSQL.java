package CihazDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import CihazDomain.CihazTanimlaDomain;




public class CihazTanimlaSQL {

	static DefaultTableModel model;
	
	public static void tabloOlustur() {		
		Connection baglanti= CihazDataBaseCon.baglantiAl();
		try {
			PreparedStatement sorguStatement=
					baglanti.prepareStatement("CREATE TABLE cihazlar (id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),isyeri VARCHAR(50), cihazturu VARCHAR(50),marka VARCHAR(50)"
							+ ",model VARCHAR(50)"
							+ ",macadresi VARCHAR(50)"
							+ ",serino VARCHAR(50)"
							+ ",gbtarih VARCHAR(50)"
							+ ",gsuresi VARCHAR(50)"
							+ ",zpsicili VARCHAR(50)"
							+ ",aciklama VARCHAR(50))");		
					sorguStatement.executeUpdate();		
		} catch (SQLException e) {			
			if(e.getSQLState().equals("X0Y32")) {				
				System.out.println("tablo mevcut");
			}else 
			{			
			e.printStackTrace();		
			}
}
}

	public static void ekle_cihaz(CihazTanimlaDomain eklenecekCihaz) {	
		Connection baglanti=CihazDataBaseCon.baglantiAl();
		tabloOlustur();
		PreparedStatement sorguPreparedStatement;
		try {		
			sorguPreparedStatement = baglanti.prepareStatement("INSERT INTO cihazlar (isyeri,cihazturu,marka,model,macadresi,serino,gbtarih,gsuresi,zpsicili,aciklama) VALUES (?,?,?,?,?,?,?,?,?,?)");
			sorguPreparedStatement.setString(1, eklenecekCihaz.getIsyeri().toUpperCase());
			sorguPreparedStatement.setString(2, eklenecekCihaz.getCihazTuru().toUpperCase());
			sorguPreparedStatement.setString(3, eklenecekCihaz.getMarka().toUpperCase());
			sorguPreparedStatement.setString(4, eklenecekCihaz.getModel().toUpperCase());
			sorguPreparedStatement.setString(5, eklenecekCihaz.getMacadresi().toUpperCase());
			sorguPreparedStatement.setString(6, eklenecekCihaz.getSeriNo().toUpperCase());
			sorguPreparedStatement.setString(7, eklenecekCihaz.getgBTarih().toUpperCase());
			sorguPreparedStatement.setString(8, eklenecekCihaz.getgSuresi().toUpperCase());
			sorguPreparedStatement.setString(9, eklenecekCihaz.getzPSicili().toUpperCase());
			sorguPreparedStatement.setString(10, eklenecekCihaz.getAciklama().toUpperCase());
			
			
			
			sorguPreparedStatement.executeUpdate();				
		} catch (SQLException e) {	
			e.printStackTrace();
		}		
	}

	public static ArrayList<CihazTanimlaDomain> cihazListele(){	
		ArrayList<CihazTanimlaDomain> cihaz= new ArrayList<CihazTanimlaDomain>();
		Connection baglanti = CihazDataBaseCon.baglantiAl();
		try {
			PreparedStatement sorgu2 =baglanti.prepareStatement("SELECT * FROM cihazlar WHERE isyeri IS NOT NULL ORDER BY isyeri ASC");	
			ResultSet rs2=sorgu2.executeQuery();		
			while(rs2.next()) {			
				CihazTanimlaDomain siradakiDomain2=new CihazTanimlaDomain();					
				siradakiDomain2.setId(rs2.getInt("id"));
				siradakiDomain2.setIsyeri(rs2.getString("isyeri"));	
				siradakiDomain2.setCihazTuru(rs2.getString("cihazturu"));
				siradakiDomain2.setMarka(rs2.getString("marka"));
				siradakiDomain2.setModel(rs2.getString("model"));
				siradakiDomain2.setMacadresi(rs2.getString("macadresi"));
				siradakiDomain2.setSeriNo(rs2.getString("serino"));
				siradakiDomain2.setgBTarih(rs2.getString("gbtarih"));
				siradakiDomain2.setgSuresi(rs2.getString("gsuresi"));
				siradakiDomain2.setzPSicili(rs2.getString("zpsicili"));
				siradakiDomain2.setAciklama(rs2.getString("aciklama"));
				
				
				cihaz.add(siradakiDomain2);			
			}				
		} catch (SQLException e) {	
			e.printStackTrace();
		}		
		return cihaz;	
	}

	public static DefaultTableModel isyeriBulDefaultTableModel(String isyeri) {
		 model=new DefaultTableModel();		 	 
		 Object[] kolonlar= {"Cihaz Turu","Markasi","Modeli","Mac","Seri No","Garanti Baslayisi","Garanti Suresi","Zimmetlenen Personel","Aciklama"}; 		 		 
		 Object[] satirlar=new Object[20];
		 Connection baglanti =CihazDataBaseCon.baglantiAl();			 		 
		 model.setColumnIdentifiers(kolonlar);					 		
		try {						
			PreparedStatement sorgu=baglanti.prepareStatement("SELECT * FROM cihazlar WHERE isyeri LIKE ?");			
			sorgu.setString(1,isyeri);			
			ResultSet rs=sorgu.executeQuery();							
			while(rs.next()) {													
				satirlar[0]=rs.getString("cihazturu");
				satirlar[1]=rs.getString("marka");
				satirlar[2]=rs.getString("model");				
				satirlar[3]=rs.getString("macadresi");
				satirlar[4]=rs.getString("serino");
				satirlar[5]=rs.getString("gbtarih");
				satirlar[6]=rs.getString("gsuresi");
				satirlar[7]=rs.getString("zpsicili");
				satirlar[8]=rs.getString("aciklama");
				
				
				model.addRow(satirlar);				
			}												
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;				
	}

	public static DefaultTableModel tumuBulDefaultTableModel(String tumu) {
		 model=new DefaultTableModel();		 	 
		 Object[] kolonlar= {"Isyeri","Cihaz Turu","Markasi","Modeli","Mac","Seri No","Garanti Baslayis","Garanti Suresi","Zimmetlenen Personel","Aciklama"}; 		 		 
		 Object[] satirlar=new Object[20];
		 Connection baglanti =CihazDataBaseCon.baglantiAl();			 		 
		 model.setColumnIdentifiers(kolonlar);					 		
		try {						
			PreparedStatement sorgu=baglanti.prepareStatement("SELECT * FROM cihazlar WHERE isyeri IS NOT NULL ORDER BY isyeri ASC");			
					
			ResultSet rs=sorgu.executeQuery();							
			while(rs.next()) {
				satirlar[0]=rs.getString("isyeri");
				satirlar[1]=rs.getString("cihazturu");
				satirlar[2]=rs.getString("marka");
				satirlar[3]=rs.getString("model");				
				satirlar[4]=rs.getString("macadresi");
				satirlar[5]=rs.getString("serino");
				satirlar[6]=rs.getString("gbtarih");
				satirlar[7]=rs.getString("gsuresi");
				satirlar[8]=rs.getString("zpsicili");
				satirlar[9]=rs.getString("aciklama");
				
				
				model.addRow(satirlar);				
			}												
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;				
	}

	public static void cihazTSil(CihazTanimlaDomain silinecekCihazDomain) {
		Connection baglanti=CihazDataBaseCon.baglantiAl();	
		try {
			PreparedStatement sorgu= baglanti.prepareStatement("DELETE FROM cihazlar WHERE id=?");
			sorgu.setInt(1, silinecekCihazDomain.getId());
			sorgu.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<CihazTanimlaDomain> bulIsyeriCihaz(String isyeriString){		
		ArrayList<CihazTanimlaDomain> bulunanIsyeri= new ArrayList<CihazTanimlaDomain>();
		Connection baglanti = CihazDataBaseCon.baglantiAl();
		try {
			PreparedStatement sorgu =baglanti.prepareStatement("SELECT * FROM cihazlar WHERE isyeri LIKE ? ORDER BY isyeri ASC");	
			sorgu.setString(1, isyeriString);
			ResultSet rs2=sorgu.executeQuery();			
			while(rs2.next()) {				
				
				
				CihazTanimlaDomain siradakiDomain2=new CihazTanimlaDomain();							
				 
								
				siradakiDomain2.setIsyeri(rs2.getString("isyeri"));	
				siradakiDomain2.setCihazTuru(rs2.getString("cihazturu"));
				siradakiDomain2.setMarka(rs2.getString("marka"));
				siradakiDomain2.setModel(rs2.getString("model"));
				siradakiDomain2.setMacadresi(rs2.getString("macadresi"));
				siradakiDomain2.setSeriNo(rs2.getString("serino"));
				siradakiDomain2.setgBTarih(rs2.getString("gbtarih"));
				siradakiDomain2.setgSuresi(rs2.getString("gsuresi"));
				siradakiDomain2.setzPSicili(rs2.getString("zpsicili"));
				siradakiDomain2.setAciklama(rs2.getString("aciklama"));					
				
				
				bulunanIsyeri.add(siradakiDomain2);				
			}			
		} catch (SQLException e) {		
			e.printStackTrace();
		}			
		return bulunanIsyeri;	
	}
	
	
	
	
}
