package no.hvl.dat108.Oblig4.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.Oblig4.service.PassordService;
import no.hvl.dat108.Oblig4.service.DeltagerService;
import no.hvl.dat108.Oblig4.util.LoginUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import no.hvl.dat108.Oblig4.model.Deltager;
import no.hvl.dat108.Oblig4.service.DeltagerService;
import no.hvl.dat108.Oblig4.service.PassordService;
import no.hvl.dat108.Oblig4.util.LoginUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller 
@RequestMapping("login")
public class LoginController {

	@Autowired 
	DeltagerService dService; 
	 @Autowired
	 PassordService pService; 
	
	 
	@GetMapping
	public String hentLogginnView() {
				
				return "loginView"; 
			
			
	}
	
	@PostMapping
	public String provLoggInn(@RequestParam(value = "tlf") String brukernavn, @RequestParam(value = "passord") String passord, Model model, HttpServletRequest request,
	                          HttpSession session) {

	    Optional<Deltager> optionalDeltager = dService.finnTlf(brukernavn);

	    if (optionalDeltager.isPresent()) {
	        Deltager deltager = optionalDeltager.get();

	        String hash = deltager.getHash();
	        String salt = deltager.getSalt();

	        if (pService.erKorrektPassord(passord, salt, hash)) {
	            LoginUtil.loggInnBruker(request, brukernavn);
	            session.setAttribute("deltager", deltager);
	            return "redirect:deltagerliste";
	        } else {
	            model.addAttribute("tlf", brukernavn);
	            model.addAttribute("feilPassord", "Passordet du oppga er feil");
	            return "loginView";
	        }
	    } else {
	        model.addAttribute("ikkeFunnet", "Deltager med nummer " + brukernavn + " er ikke påmeldt");
	        return "loginView";
	    }
	}
}
