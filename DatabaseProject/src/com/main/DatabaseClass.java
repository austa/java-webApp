package com.main;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DatabaseClass {
	
	static final String HOST = "localhost:3306";
	static final String DBNAME = "ogrenciDB";
	static final String URI = "jdbc:mysql://" + HOST + "/" + DBNAME;	
				
	private Statement ConnectDatabase() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = (Connection) DriverManager.getConnection(URI,"root","aletbaba53");
		Statement statement = (Statement) con.createStatement();
		return statement;
	}
	
	protected boolean AddDatabase(String name, String lastname, String username, String email, String password, String authorityID, String birthday, String photo) throws ClassNotFoundException, SQLException {
		Statement statement = ConnectDatabase();
		int kontrol =statement.executeUpdate("INSERT INTO tuser(`isim`, `soyisim`, `kadi`, `email`, `sifre`, `yetkiID`, `dogum_tarihi`, `resim`) VALUES ('" +name+ "','" +lastname+ "','" +username+ "','"  +email+ "','" +password+ "','" +authorityID+ "','" +birthday+ "','" +photo+"')");
		
		if (kontrol == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	protected String QueryDatabase(String email, String password) throws ClassNotFoundException, SQLException {
		String kimlik = null;
		Statement statement = ConnectDatabase();
		ResultSet result = statement.executeQuery("SELECT * FROM `tuser` WHERE `email` LIKE '" +email+ "' AND `sifre` LIKE '" +password+ "'");
		while (result.next()) {
			if (result.getString("email").equals(email) && result.getString("sifre").equals(password) && result.getString("yetkiID").equals("1")) {
				kimlik = "ogretmen";
			}else if (result.getString("email").equals(email) && result.getString("sifre").equals(password) && result.getString("yetkiID").equals("0")) {
				kimlik = "ogrenci";
			}
		}
		return kimlik;
	}

}
