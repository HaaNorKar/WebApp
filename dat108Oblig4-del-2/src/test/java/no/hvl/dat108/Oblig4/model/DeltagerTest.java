package no.hvl.dat108.Oblig4.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DeltagerTest {

    @Test
    public void testOpprettDeltager() {
        Deltager deltager = new Deltager("Ola", "Nordmann", "12345678", "mann");

        assertEquals("Ola", deltager.getFornavn(), "Fornavnet skal være 'Ola'");
        assertEquals("Nordmann", deltager.getEtternavn(), "Etternavnet skal være 'Nordmann'");
        assertEquals("12345678", deltager.getTlf(), "Telefonnummeret skal være '12345678'");
        assertEquals("mann", deltager.getKjonn(), "Kjønnet skal være 'mann'");
    }

    @Test
    public void testSettUgyldigTelefonnummer() {
        Deltager deltager = new Deltager();
        deltager.setTlf("12345");

        assertFalse(deltager.getTlf().matches("\\d{8}"), "Telefonnummeret skal være eksakt 8 siffer");
    }

    @Test
    public void testSettGyldigFornavn() {
        Deltager deltager = new Deltager();
        deltager.setFornavn("Kari");

        assertTrue(deltager.getFornavn().matches("^[A-ZÆØÅ][a-zA-ZæøåÆØÅ\\-\\s]*$"), "Fornavn må starte med stor bokstav og kan inneholde bokstaver, bindestrek og mellomrom");
        assertEquals("Kari", deltager.getFornavn(), "Fornavnet skal være 'Kari'");
    }

    @Test
    public void testSettUgyldigKjonn() {
        Deltager deltager = new Deltager();
        deltager.setKjonn("annet");

        assertFalse(deltager.getKjonn().equals("mann") || deltager.getKjonn().equals("kvinne"), "Kjønnet skal være 'mann' eller 'kvinne'");
    }

    @Test
    public void testOppdaterEtternavn() {
        Deltager deltager = new Deltager("Ola", "Nordmann", "12345678", "mann");
        deltager.setEtternavn("Hansen");

        assertEquals("Hansen", deltager.getEtternavn(), "Etternavnet skal være 'Hansen'");
    }

    // Flere nye tester

    @Test
    public void testGyldigLogin() {
        Deltager deltager = new Deltager("Ola", "Nordmann", "12345678", "mann");
        deltager.setHash("gyldigHash"); // Simulerer at passordet er satt riktig

        String inputHash = "gyldigHash"; // Passordoppføringen fra brukeren

        assertEquals(inputHash, deltager.getHash(), "Passordet skal være korrekt for innlogging.");
    }

    @Test
    public void testUgyldigLogin() {
        Deltager deltager = new Deltager("Ola", "Nordmann", "12345678", "mann");
        deltager.setHash("riktigHash"); // Riktig passord hash

        String feilInputHash = "feilHash"; // Feil passord oppføring

        assertFalse(feilInputHash.equals(deltager.getHash()), "Passordet er feil, og innlogging skal ikke lykkes.");
    }

    @Test
    public void testOppdaterTelefonnummer() {
        Deltager deltager = new Deltager("Ola", "Nordmann", "12345678", "mann");
        deltager.setTlf("87654321"); // Oppdaterer telefonnummeret

        assertEquals("87654321", deltager.getTlf(), "Telefonnummeret skal være oppdatert til '87654321'.");
    }

    @Test
    public void testSettGyldigKjonn() {
        Deltager deltager = new Deltager();
        deltager.setKjonn("kvinne");

        assertTrue(deltager.getKjonn().equals("kvinne") || deltager.getKjonn().equals("mann"), "Kjønnet skal være 'mann' eller 'kvinne'.");
    }

    @Test
    public void testHashErSatt() {
        Deltager deltager = new Deltager("Ola", "Nordmann", "12345678", "mann");
        deltager.setHash("noeHashVerdi");

        assertNotNull(deltager.getHash(), "Hash-verdien skal ikke være null når den er satt.");
    }
}
