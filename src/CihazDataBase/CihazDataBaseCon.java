package CihazDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CihazDataBaseCon {
	private static final String YOL ="jdbc:derby:cihazlist2;create=true";
	private static final String KULLANICI ="";
	private static final String PAROLA ="";
		
	public static Connection baglantiAl() {		
		Connection baglanti=null;		
		try {
			baglanti =DriverManager.getConnection(YOL, KULLANICI, PAROLA);			
			System.out.println("baglandi");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}						
		return baglanti;
	}
} 