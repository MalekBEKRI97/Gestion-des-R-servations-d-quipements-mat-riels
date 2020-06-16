package com.example.Reservation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class ReservationMateriel {
	private LocalDateTime delais;
	private List<Materiel> materiels;

	public ReservationMateriel(List<Materiel> materiels) {
		super();
		LocalDateTime currentTime = LocalDateTime.now();
		
		this.delais = currentTime.plus(1, ChronoUnit.WEEKS);
		this.materiels=materiels;

	}

	public void ajouter(Materiel materiel) {
		materiels.add(materiel);
	}

	public void supprimer(Materiel materiel) {
		materiels.remove(materiel);
	}

	public LocalDate getDelais() {
		return delais.toLocalDate();
	}


	public List<Materiel> getMateriels() {
		return materiels;
	}

	public void setMateriels(List<Materiel> materiels) {
		this.materiels = materiels;
	}

}
