package CihazDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import CihazDomain.MarkaDomain;

public class MarkaSQL {

	
	public static void tabloOlustur() {		
		Connection baglanti= CihazDataBaseCon.baglantiAl();
		try {
			PreparedStatement sorguStatement=
					baglanti.prepareStatement("CREATE TABLE markalar (id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1), marka VARCHAR(50))");		
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

	public static void ekle_marka(MarkaDomain eklenecekMarka) {	
		Connection baglanti=CihazDataBaseCon.baglantiAl();
		tabloOlustur();
		PreparedStatement sorguPreparedStatement;
		try {		
			sorguPreparedStatement = baglanti.prepareStatement("INSERT INTO markalar (marka) VALUES (?)");
			sorguPreparedStatement.setString(1, eklenecekMarka.getMarka().toUpperCase());			
			sorguPreparedStatement.executeUpdate();				
		} catch (SQLException e) {	
			e.printStackTrace();
		}		
	}

	public static ArrayList<MarkaDomain> markaListele(){	
		ArrayList<MarkaDomain> marka= new ArrayList<MarkaDomain>();
		Connection baglanti = CihazDataBaseCon.baglantiAl();
		try {
			PreparedStatement sorgu2 =baglanti.prepareStatement("SELECT * FROM markalar WHERE marka IS NOT NULL ORDER BY marka ASC");	
			ResultSet rs2=sorgu2.executeQuery();		
			while(rs2.next()) {			
				MarkaDomain siradakiDomain2=new MarkaDomain();					
				siradakiDomain2.setId(rs2.getInt("id"));
				siradakiDomain2.setMarka(rs2.getString("marka"));											
				marka.add(siradakiDomain2);			
			}				
		} catch (SQLException e) {	
			e.printStackTrace();
		}		
		return marka;	
	}

	public static void markaSil(MarkaDomain silinecekMarka) {
		Connection baglanti=CihazDataBaseCon.baglantiAl();	
		try {
			PreparedStatement sorgu= baglanti.prepareStatement("DELETE FROM markalar WHERE id=?");
			sorgu.setInt(1, silinecekMarka.getId());
			sorgu.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
 	
}
