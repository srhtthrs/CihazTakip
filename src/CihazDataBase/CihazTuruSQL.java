package CihazDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import CihazDomain.CihazTuruDomain;


public class CihazTuruSQL {

	public static void tabloOlustur() {		
		Connection baglanti= CihazDataBaseCon.baglantiAl();
	 	try {
			PreparedStatement sorguStatement=
					baglanti.prepareStatement("CREATE TABLE cihazturleri (id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1), cihazturu VARCHAR(50))");		
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

	public static void ekle_cihazTuru(CihazTuruDomain eklenecekCihazTuru) {	
		Connection baglanti=CihazDataBaseCon.baglantiAl();
		tabloOlustur();
		PreparedStatement sorguPreparedStatement;
		try {		
			sorguPreparedStatement = baglanti.prepareStatement("INSERT INTO cihazturleri (cihazturu) VALUES (?)");
			sorguPreparedStatement.setString(1, eklenecekCihazTuru.getCihazturu().toUpperCase());			
			sorguPreparedStatement.executeUpdate();				
		} catch (SQLException e) {	
			e.printStackTrace();
		}		
	}

	public static ArrayList<CihazTuruDomain> cihazTuruListele(){	
		ArrayList<CihazTuruDomain> cihaz= new ArrayList<CihazTuruDomain>();
		Connection baglanti = CihazDataBaseCon.baglantiAl();
		try {
			PreparedStatement sorgu2 =baglanti.prepareStatement("SELECT * FROM cihazturleri WHERE cihazturu IS NOT NULL ORDER BY cihazturu ASC");	
			ResultSet rs2=sorgu2.executeQuery();		
			while(rs2.next()) {			
				CihazTuruDomain siradakiDomain2=new CihazTuruDomain();					
				siradakiDomain2.setId(rs2.getInt("id"));
				siradakiDomain2.setCihazturu(rs2.getString("cihazturu"));											
				cihaz.add(siradakiDomain2);			
			}				
		} catch (SQLException e) {	
			e.printStackTrace();
		}		
		return cihaz;	
	}

	public static void cihazTuruSil(CihazTuruDomain silinecekCihazTuru) {
		Connection baglanti=CihazDataBaseCon.baglantiAl();	
		try {
			PreparedStatement sorgu= baglanti.prepareStatement("DELETE FROM cihazturleri WHERE id=?");
			sorgu.setInt(1, silinecekCihazTuru.getId());
			sorgu.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	
	
	
	
	
}
