package com.database;

public class Galeri {
	private String id;
	private String isim;
	
	public Galeri(){
	}
	public Galeri(String isim){
		this.isim = isim;
	}
	public Galeri(String id,String isim){
		this.id = id;
		this.isim = isim;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return isim;
	}
	public void setName(String name) {
		this.isim = name;
	}
}
