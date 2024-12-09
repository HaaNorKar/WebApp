package no.hvl.dat108.Oblig4.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.hvl.dat108.Oblig4.model.Deltager;
import no.hvl.dat108.Oblig4.repository.DeltagerRepo;
import jakarta.servlet.http.HttpSession;


@Service 
public class DeltagerService {

@Autowired
private DeltagerRepo deltagerRepo;
@Autowired 
PassordService pService; 


public List<Deltager> finnAlleDeltagere() {
	return deltagerRepo.findAll(); 
}



public Deltager FinnMedId(String tlf) {
	
	return deltagerRepo.findById(tlf).get(); 
	
}
public List<Deltager>sorterDeltagere(){
	Comparator<Deltager> sammenliknFornavnOgEtternavn = Comparator.comparing(Deltager::getFornavn).thenComparing(Deltager::getEtternavn);
	return finnAlleDeltagere().stream().sorted(sammenliknFornavnOgEtternavn).toList();
	
}


public Deltager addDeltager(Deltager deltager) {
	return deltagerRepo.save(deltager);
}


public Optional<Deltager> finnTlf(String tlf){
    
	return deltagerRepo.findById(tlf); 
}


public void loggUtBruker(HttpSession session) {
	
	session.invalidate(); 
}


}
