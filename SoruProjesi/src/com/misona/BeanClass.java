package com.misona;

import java.io.Serializable;

public class BeanClass implements Serializable {
	
	private int ogrenciNo;
	private String ogrenciAd;
	private String ogrenciSoyad;
	private String ogrenciDogumTarihi;
	private String ogrenciBolumAd;
	public int getOgrenciNo() {
		return ogrenciNo;
	}
	public void setOgrenciNo(int ogrenciNo) {
		this.ogrenciNo = ogrenciNo;
	}
	public String getOgrenciAd() {
		return ogrenciAd;
	}
	public void setOgrenciAd(String ogrenciAd) {
		this.ogrenciAd = ogrenciAd;
	}
	public String getOgrenciSoyad() {
		return ogrenciSoyad;
	}
	public void setOgrenciSoyad(String ogrenciSoyad) {
		this.ogrenciSoyad = ogrenciSoyad;
	}
	public String getOgrenciDogumTarihi() {
		return ogrenciDogumTarihi;
	}
	public void setOgrenciDogumTarihi(String ogrenciDogumTarihi) {
		this.ogrenciDogumTarihi = ogrenciDogumTarihi;
	}
	public String getOgrenciBolumAd() {
		return ogrenciBolumAd;
	}
	public void setOgrenciBolumAd(String ogrenciBolumAd) {
		this.ogrenciBolumAd = ogrenciBolumAd;
	}

}
