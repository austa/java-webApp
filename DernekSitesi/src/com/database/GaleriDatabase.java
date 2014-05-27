package com.database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class GaleriDatabase {
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
	
	public boolean galeriEkleme(String isim) throws ClassNotFoundException, SQLException {
		Statement statement = connectDatabase();
		int kontrol =statement.executeUpdate("INSERT INTO galeri(`isim`) VALUES ('" + isim + "')");
		
		if (kontrol == 1) {
			return true;
		}else {
			return false;
		}
	}
	public Galeri galeriGoruntule(String id) throws ClassNotFoundException, SQLException {
		Galeri galeri = new Galeri();
		Statement statement = connectDatabase();
		ResultSet result = statement.executeQuery("SELECT * FROM `galeri` WHERE `id` = " + id);
		while (result.next()) {
			galeri.setId(result.getString("id"));
			galeri.setName(result.getString("isim"));
		}
		return galeri;
	}
	public List<Galeri> tumGaleriler() throws ClassNotFoundException, SQLException {
		List<Galeri> galeriler = new ArrayList<Galeri>();
		Statement statement = connectDatabase();
		ResultSet result = statement.executeQuery("SELECT * FROM `galeri` order by isim asc");
		while (result.next()) {
			Galeri galeri = new Galeri(result.getString("id"), result.getString("isim"));
			galeriler.add(galeri);
		}
		return galeriler;
	}
	public List<Galeri> tumDuyurular(int limit) throws ClassNotFoundException, SQLException {
		List<Galeri> galeriler = new ArrayList<Galeri>();
		Statement statement = connectDatabase();
		ResultSet result = statement.executeQuery("SELECT * FROM `duyuru` order by name asc limit 0," + limit);
		while (result.next()) {
			Galeri galeri = new Galeri(result.getString("id"), result.getString("isim"));
			galeriler.add(galeri);
		}
		return galeriler;
	}
	public List<Galeri> tumDuyurular(int baslangic,int limit) throws ClassNotFoundException, SQLException {
		List<Galeri> galeriler = new ArrayList<Galeri>();
		Statement statement = connectDatabase();
		ResultSet result = statement.executeQuery("SELECT * FROM `duyuru` order by name asc limit " + baslangic + "," + limit);
			while (result.next()) {
			Galeri galeri = new Galeri(result.getString("id"), result.getString("isim"));
			galeriler.add(galeri);
		}
		return galeriler;
	}
	public boolean galeriDuzenle(String id,String isim) throws ClassNotFoundException, SQLException{
		Statement statement = connectDatabase();
		int kontrol =statement.executeUpdate("UPDATE `galeri` SET `isim` = '" + isim + " WHERE `id` = "+ id);

		if (kontrol == 1) {
			return true;
		}else {
			return false;
		}
	}
	public boolean galeriSil(String id) throws ClassNotFoundException, SQLException{
		Statement statement = connectDatabase();
		int kontrol =statement.executeUpdate("DELETE FROM `galeri` WHERE id=" + id);
		if (kontrol == 1) {
			return true;
		}else {
			return false;
		}
	}
}
