package com.database;

public class Duyuru {
	String id;
	String baslik;
	String icerik;
	String zaman;
	String resim;
	
	public String getResim() {
		return resim;
	}

	public void setResim(String resim) {
		this.resim = resim;
	}

	public Duyuru(String id, String baslik, String icerik, String zaman,String resim) {
		this.id = id;
		this.baslik = baslik;
		this.icerik = icerik;
		this.zaman = zaman;
		this.resim = resim;
	}

	public Duyuru() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBaslik() {
		return baslik;
	}

	public void setBaslik(String baslik) {
		this.baslik = baslik;
	}

	public String getIcerik() {
		return icerik;
	}

	public void setIcerik(String icerik) {
		this.icerik = icerik;
	}

	public String getZaman() {
		return zaman;
	}

	public void setZaman(String zaman) {
		this.zaman = zaman;
	}
	
	

}