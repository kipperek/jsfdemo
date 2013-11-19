package com.example.jsfdemo.domain;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Building {
	
	double wysokosc;
	int yob;
	String kolor;
	String adres;
	String miasto;
	int iloscOkien;
	boolean mieszkalny;
	
	public Building(){}

	
	@Size(min = 2, max = 30)
	public String getMiasto() {
		return miasto;
	}



	public void setMiasto(String miasto) {
		this.miasto = miasto;
	}


	public double getWysokosc() {
		return wysokosc;
	}

	public void setWysokosc(double wysokosc) {
		this.wysokosc = wysokosc;
	}
	
	public int getYob() {
		return yob;
	}

	public void setYob(int yob) {
		this.yob = yob;
	}

	public String getKolor() {
		return kolor;
	}

	public void setKolor(String kolor) {
		this.kolor = kolor;
	}
	
	@Pattern(regexp = "[A-Za-z]+\\s[0-9]+")
	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public int getIloscOkien() {
		return iloscOkien;
	}

	public void setIloscOkien(int iloscOkien) {
		this.iloscOkien = iloscOkien;
	}

	public boolean getMieszkalny() {
		return mieszkalny;
	}

	public void setMieszkalny(boolean mieszkalny) {
		this.mieszkalny = mieszkalny;
	}

	
	
	

}
