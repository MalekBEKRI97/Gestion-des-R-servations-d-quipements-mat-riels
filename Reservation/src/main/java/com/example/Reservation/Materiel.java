package com.example.Reservation;

public class Materiel {
	private int id;
	private String titre;
	private boolean estDisponible=true;
	private static int nb;
	
	public Materiel(String titre) {
		super();
		this.titre = titre;
		estDisponible=false;
		id=nb;
		nb=nb+1;
	}
	public boolean isEstDisponible() {
		return estDisponible;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public static int getNb() {
		return nb;
	}
	public static void setNb(int nb) {
		Materiel.nb = nb;
	}
	public void setEstDisponible(boolean estDisponible) {
		this.estDisponible = estDisponible;
	}
	
	
	

}
