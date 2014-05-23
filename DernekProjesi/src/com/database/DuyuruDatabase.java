package com.database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class DuyuruDatabase {
	
	static final String HOST = "localhost:3306";
	static final String DBNAME = "dernek";
	static final String URI = "jdbc:mysql://" + HOST + "/" + DBNAME;	
	
	/*public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DuyuruDatabase db = new DuyuruDatabase();
		db.duyuruDuzenle("1", "alaattin", "usta");
	}*/
			
	private Statement connectDatabase() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = (Connection) DriverManager.getConnection(URI,"root","aletbaba53");
		Statement statement = (Statement) con.createStatement();
		return statement;
	}
	
	public boolean duyuruEkleme(String baslik, String icerik) throws ClassNotFoundException, SQLException {
		Statement statement = connectDatabase();
		int kontrol =statement.executeUpdate("INSERT INTO duyuru(`baslik`, `icerik`) VALUES ('" +baslik+ "','" +icerik+"')");
		
		if (kontrol == 1) {
			return true;
		}else {
			return false;
		}
	}
	public Duyuru duyuruGoruntule(String id) throws ClassNotFoundException, SQLException {
		Duyuru	duyuru = new Duyuru();
		Statement statement = connectDatabase();
		ResultSet result = statement.executeQuery("SELECT * FROM `duyuru` WHERE `id` = " + id);
		while (result.next()) {
			duyuru.setId(result.getString("id"));
			duyuru.setBaslik(result.getString("baslik"));
			duyuru.setIcerik(result.getString("icerik"));
			duyuru.setZaman(result.getString("zaman"));
		}
		return duyuru;
	}
	public List<Duyuru> tumDuyurular() throws ClassNotFoundException, SQLException {
		List<Duyuru> baslikListesi = new ArrayList<Duyuru>();
		Statement statement = connectDatabase();
		ResultSet result = statement.executeQuery("SELECT * FROM `duyuru` order by id desc");
		while (result.next()) {
			Duyuru duyuru = new Duyuru(result.getString("id"), result.getString("baslik"), result.getString("icerik"), result.getString("zaman"));
			baslikListesi.add(duyuru);
		}
		return baslikListesi;
	}
	public List<Duyuru> tumDuyurular(int limit) throws ClassNotFoundException, SQLException {
		List<Duyuru> baslikListesi = new ArrayList<Duyuru>();
		Statement statement = connectDatabase();
		ResultSet result = statement.executeQuery("SELECT * FROM `duyuru` order by id desc limit 0," + limit);
		while (result.next()) {
			Duyuru duyuru = new Duyuru(result.getString("id"), result.getString("baslik"), result.getString("icerik"), result.getString("zaman"));
			baslikListesi.add(duyuru);
		}
		return baslikListesi;
	}
	public boolean duyuruDuzenle(String id,String baslik,String icerik) throws ClassNotFoundException, SQLException{
		Statement statement = connectDatabase();
		int kontrol =statement.executeUpdate("UPDATE `duyuru` SET `baslik` = '" + baslik + "', `icerik` = '" + icerik + "' WHERE `id` = "+ id);

		if (kontrol == 1) {
			return true;
		}else {
			return false;
		}
	}
	public boolean duyuruSil(String id) throws ClassNotFoundException, SQLException{
		Statement statement = connectDatabase();
		int kontrol =statement.executeUpdate("DELETE FROM `duyuru` WHERE id=" + id);
		if (kontrol == 1) {
			return true;
		}else {
			return false;
		}
	}
}

