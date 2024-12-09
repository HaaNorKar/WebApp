package no.hvl.dat108.Oblig4.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import no.hvl.dat108.Oblig4.model.Deltager;
import no.hvl.dat108.Oblig4.service.DeltagerService;

public class LoginUtil {
	
	@Autowired
  DeltagerService dService; 
	
	public static void loggUtBruker(HttpSession session) {
		
		session.invalidate(); 
	}

	public static void loggInnBruker(HttpServletRequest request, String username) {
		
	 
		
		HttpSession session = request.getSession(false);  //henter sessionsdata 
		request.getSession(); 
		session.setMaxInactiveInterval(300); //tid oppgitt i sekunder. Bruker logges ut hvis den har vært innaktiv for lenge.
		session.setAttribute("brukernavn", username);
		session.setAttribute("deltager", new Deltager()); 
		
	
		
	}
	
	public static boolean erBrukerInnlogget(HttpSession session) {
		
		
		
		return session != null&& session.getAttribute("brukernavn") != null && session.getAttribute("deltager") != null; 
		
		
	}

}
