package com.example.Reservation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@org.springframework.stereotype.Controller
public class Controller {
	private int i;
	List<Materiel> materiels = new ArrayList<Materiel>();
	private ReservationMateriel reservationMateriel = new ReservationMateriel(materiels);
	private List<Materiel> malek = new ArrayList<Materiel>();
	Materiel arduino = new Materiel("arduino");
	Materiel rasberry_PI = new Materiel("rasberry PI");
	Materiel stm = new Materiel("stm");
	Materiel bluetooth = new Materiel("bluetooth");
	Materiel batterie = new Materiel("batterie");
	Materiel ultrason = new Materiel("ultrason");

	@GetMapping("/")
	public ModelAndView getindex() {
		if (i == 0) {
			malek.add(arduino);
			malek.add(rasberry_PI);
			malek.add(stm);
			malek.add(bluetooth);
			malek.add(ultrason);
			malek.add(batterie);

			i++;
		}
		Map<String, Object> khaled = new HashMap<String, Object>();
		khaled.put("mouhamed", malek);
		return new ModelAndView("projet", khaled);

	}

	@GetMapping("/reservation")
	public ModelAndView postReservation(@RequestParam int id) {
		for (Materiel materiel : malek) {
			if (materiel.getId() == id) {
				reservationMateriel.ajouter(materiel);
			}
		}

		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("/");

		return new ModelAndView(redirectView);
	}

	@GetMapping("/reservationlist")
	public ModelAndView reservation() {
		Map<String, Object> khaled = new HashMap<String, Object>();
		khaled.put("mouhamed", reservationMateriel);
		return new ModelAndView("panier", khaled);
	}

	@GetMapping("/delete")
	public ModelAndView delete(@RequestParam int id) {
		List<Materiel> list = reservationMateriel.getMateriels();
		//list.remove(id-1);
		
		for (Materiel materiel : list) {
			if (materiel.getId()==id) {

				reservationMateriel.supprimer(materiel);
				break;

			}
		}
		
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("/reservationlist");
		return new ModelAndView(redirectView);
	}

}
