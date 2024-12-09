package no.hvl.dat108.Oblig4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import no.hvl.dat108.Oblig4.util.LoginUtil;
import jakarta.servlet.http.HttpSession;


@Controller 
@RequestMapping("utlogging")
public class LogutController {

	
	
	@GetMapping 
		public String gåTilLogin(HttpSession session) {
		return("loginView"); 
	}
	
	
	@PostMapping  
	public String loggUt(RedirectAttributes ra, HttpSession session) {
	
		ra.addFlashAttribute("loggetUt", "du er nå logget ut");
		LoginUtil.loggUtBruker(session);
		return("redirect:login"); 
		
		}
		
	
}
