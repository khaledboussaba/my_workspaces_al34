package fr.afcepf.al34.dto;

import java.io.Serializable;

public class ResCalculTva implements Serializable {
	private static final long serialVersionUID = -5781410795464472470L;
	
	private double tva;
	private double ttc;
	
	public ResCalculTva() {
	}
	
	public ResCalculTva(double tva, double ttc) {
		this.tva = tva;
		this.ttc = ttc;
	}

	public double getTva() {
		return tva;
	}
	public void setTva(double tva) {
		this.tva = tva;
	}
	public double getTtc() {
		return ttc;
	}
	public void setTtc(double ttc) {
		this.ttc = ttc;
	}
	
}
