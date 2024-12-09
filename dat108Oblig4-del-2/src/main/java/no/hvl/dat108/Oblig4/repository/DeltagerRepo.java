package no.hvl.dat108.Oblig4.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import no.hvl.dat108.Oblig4.model.Deltager;
import no.hvl.dat108.Oblig4.model.Passord;

public interface DeltagerRepo extends JpaRepository <Deltager, String> {	
 
	Deltager findByFornavn(String fornavn);
	Deltager getById(String tlf); 
	
}
