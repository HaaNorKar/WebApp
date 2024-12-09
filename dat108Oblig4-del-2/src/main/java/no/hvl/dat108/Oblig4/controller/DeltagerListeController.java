package no.hvl.dat108.Oblig4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import no.hvl.dat108.Oblig4.service.DeltagerService;
import no.hvl.dat108.Oblig4.util.LoginUtil;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("deltagerliste")
public class DeltagerListeController {

	
@Autowired
DeltagerService dService; 
	
	
	@GetMapping
	public String HentDeltagerListe(RedirectAttributes ra, HttpSession session){
	
		
		if(LoginUtil.erBrukerInnlogget(session)) {
			
	session.setAttribute("deltagerListe", dService.sorterDeltagere());
		
			
	return "deltagerliste"; 
	
		} else {
			ra.addFlashAttribute("ugyldig", "du må logge inn før du kan se deltagerlisten"); 
			return "redirect:login"; 
		}
	}
}
	

