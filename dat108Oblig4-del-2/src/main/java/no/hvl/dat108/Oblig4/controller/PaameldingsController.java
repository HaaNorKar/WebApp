package no.hvl.dat108.Oblig4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import no.hvl.dat108.Oblig4.model.Deltager;
import no.hvl.dat108.Oblig4.service.DeltagerService;
import no.hvl.dat108.Oblig4.service.PassordService;
import no.hvl.dat108.Oblig4.util.LoginUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/paamelding")
public class PaameldingsController {

    @Autowired
    private DeltagerService dService;

    @Autowired
    private PassordService pService;

    @GetMapping
    public String hentPaameldingSkjema(Model model) {
        model.addAttribute("deltager", new Deltager());
        return "paameldingView";
    }

    @PostMapping
    public String deltakerInput(
            @Valid @ModelAttribute("deltager") Deltager deltager,
            BindingResult bindingResult, HttpSession session,
            Model model, HttpServletRequest request,
            @RequestParam(name = "passord") String passordKlartekst,
            @RequestParam(name = "passordRepetert") String repetertPassord) {

        // Validerer om det er feil i skjemaet
        if (bindingResult.hasErrors()) {
            model.addAttribute("feilmeldinger", bindingResult.getAllErrors().stream()
                    .map(e -> e.getDefaultMessage())
                    .reduce("", (f, e) -> f + e + "<br>"));
            return "paameldingView";
        }

        // Sjekker om passordene samsvarer
        if (!passordKlartekst.equals(repetertPassord)) {
            model.addAttribute("feilPassord", "Passordene samsvarer ikke");
            return "paameldingView";
        }

        // Sjekker om deltager allerede finnes basert på telefonnummer
        if (dService.finnTlf(deltager.getTlf()).isPresent()) {
            model.addAttribute("finnes", "En deltager med dette mobilnummeret er allerede registrert");
            return "paameldingView";
        }

        // Genererer salt og hash for passordet
        String salt = pService.genererTilfeldigSalt();
        String hash = pService.hashMedSalt(passordKlartekst, salt);
        deltager.setSalt(salt);
        deltager.setHash(hash);

        // Lagrer deltageren i databasen
        dService.addDeltager(deltager);

        // Legger deltagerdata i sesjonen for bruk senere
        LoginUtil.loggInnBruker(request, deltager.getTlf());
        session.setAttribute("deltager", deltager);

        return "redirect:paameldt";
    }
}
