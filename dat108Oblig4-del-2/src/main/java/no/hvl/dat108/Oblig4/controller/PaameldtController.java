package no.hvl.dat108.Oblig4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import no.hvl.dat108.Oblig4.service.DeltagerService;
import no.hvl.dat108.Oblig4.util.LoginUtil;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/paameldt")
public class PaameldtController {

	@Autowired
	DeltagerService dService; 
	
	@GetMapping
	public String hentPaameldtSkjema(HttpSession session) {
		
	
		/**
		 * Hvis brukeren ikke er påmeldt sendes brukereren til paameldingssiden: 
		 */
		
		
		if(!LoginUtil.erBrukerInnlogget(session)) {								
			return("redirect:paamelding");
		} else {
		
		return "paameldt"; 
	}
		
}
	
}
	

	