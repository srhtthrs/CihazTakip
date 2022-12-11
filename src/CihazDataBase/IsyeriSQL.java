package CihazDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import CihazDomain.IsyeriDomain;





 



public class IsyeriSQL {
	
	public static void tabloOlustur() {		
		Connection baglanti= CihazDataBaseCon.baglantiAl();
		try {
			PreparedStatement sorguStatement=
					baglanti.prepareStatement("CREATE TABLE isyerleri (id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1), isyeri VARCHAR(50))");		
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

	public static void ekle_isyeri(IsyeriDomain eklenecekIsyeri) {	
		Connection baglanti=CihazDataBaseCon.baglantiAl();
		tabloOlustur();
		PreparedStatement sorguPreparedStatement;
		try {		
			sorguPreparedStatement = baglanti.prepareStatement("INSERT INTO isyerleri (isyeri) VALUES (?)");
			sorguPreparedStatement.setString(1, eklenecekIsyeri.getIsyeri().toUpperCase());			
			sorguPreparedStatement.executeUpdate();				
		} catch (SQLException e) {	
			e.printStackTrace();
		}		
	}
 
	public static ArrayList<IsyeriDomain> isyeriListele(){	
		ArrayList<IsyeriDomain> isyeri= new ArrayList<IsyeriDomain>();
		Connection baglanti = CihazDataBaseCon.baglantiAl();
		try {
			PreparedStatement sorgu2 =baglanti.prepareStatement("SELECT * FROM isyerleri WHERE isyeri IS NOT NULL ORDER BY isyeri ASC");	
			ResultSet rs2=sorgu2.executeQuery();		
			while(rs2.next()) {			
				IsyeriDomain siradakiDomain2=new IsyeriDomain();					
				siradakiDomain2.setId(rs2.getInt("id"));
				siradakiDomain2.setIsyeri(rs2.getString("isyeri"));											
				isyeri.add(siradakiDomain2);			
			}				
		} catch (SQLException e) {	
			e.printStackTrace();
		}		
		return isyeri;	
	}

	public static void isyeriSil(IsyeriDomain silinecekIsyeri) {
		Connection baglanti=CihazDataBaseCon.baglantiAl();	
		try {
			PreparedStatement sorgu= baglanti.prepareStatement("DELETE FROM isyerleri WHERE id=?");
			sorgu.setInt(1, silinecekIsyeri.getId());
			sorgu.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}