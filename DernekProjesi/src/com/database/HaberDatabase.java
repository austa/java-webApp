package com.database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class HaberDatabase {
	
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
	
	public boolean haberEkleme(String baslik, String icerik) throws ClassNotFoundException, SQLException {
		Statement statement = connectDatabase();
		int kontrol =statement.executeUpdate("INSERT INTO haber(`baslik`, `icerik`) VALUES ('" +baslik+ "','" +icerik+"')");
		
		if (kontrol == 1) {
			return true;
		}else {
			return false;
		}
	}
	public Haber haberGoruntule(String id) throws ClassNotFoundException, SQLException {
		Haber haber = new Haber();
		Statement statement = connectDatabase();
		ResultSet result = statement.executeQuery("SELECT * FROM `haber` WHERE `id` = " + id);
		while (result.next()) {
			haber.setId(result.getString("id"));
			haber.setBaslik(result.getString("baslik"));
			haber.setIcerik(result.getString("icerik"));
			haber.setZaman(result.getString("zaman"));
		}
		return haber;
	}
	public List<Haber> tumHaberler() throws ClassNotFoundException, SQLException {
		List<Haber> baslikListesi = new ArrayList<Haber>();
		Statement statement = connectDatabase();
		ResultSet result = statement.executeQuery("SELECT * FROM `haber` order by id desc");
		while (result.next()) {
			Haber haber = new Haber(result.getString("id"), result.getString("baslik"), result.getString("icerik"), result.getString("zaman"));
			baslikListesi.add(haber);
		}
		return baslikListesi;
	}
	public List<Haber> tumHaberler(int limit) throws ClassNotFoundException, SQLException {
		List<Haber> baslikListesi = new ArrayList<Haber>();
		Statement statement = connectDatabase();
		ResultSet result = statement.executeQuery("SELECT * FROM `haber` order by id desc limit 0," + limit);
		while (result.next()) {
			Haber haber = new Haber(result.getString("id"), result.getString("baslik"), result.getString("icerik"), result.getString("zaman"));
			baslikListesi.add(haber);
		}
		return baslikListesi;
	}
	public boolean haberDuzenle(String id,String baslik,String icerik) throws ClassNotFoundException, SQLException{
		Statement statement = connectDatabase();
		int kontrol =statement.executeUpdate("UPDATE `haber` SET `baslik` = '" + baslik + "', `icerik` = '" + icerik + "' WHERE `id` = "+ id);

		if (kontrol == 1) {
			return true;
		}else {
			return false;
		}
	}
	public boolean haberSil(String id) throws ClassNotFoundException, SQLException{
		Statement statement = connectDatabase();
		int kontrol =statement.executeUpdate("DELETE FROM `haber` WHERE id=" + id);
		if (kontrol == 1) {
			return true;
		}else {
			return false;
		}
	}
}

