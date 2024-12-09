package no.hvl.dat108.Oblig4.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(schema = "dat108Oblig4del2")
public class Deltager {

    @Id
    @Pattern(regexp = "\\d{8}", message = "Telefonnummer må være eksakt 8 siffer")
    private String tlf;

    @NotNull
    @Size(min = 2, max = 20, message = "Fornavn må ha minst 2 tegn og maks 20 tegn")
    @Pattern(regexp = "^[A-ZÆØÅ][a-zA-ZæøåÆØÅ\\-\\s]*$", message = "Fornavn må starte med stor bokstav og kan inneholde bokstaver, bindestrek og mellomrom")
    private String fornavn;

    @NotNull
    @Size(min = 2, max = 20, message = "Etternavn må ha minst 2 tegn og maks 20 tegn")
    @Pattern(regexp = "^[A-ZÆØÅ][a-zA-ZæøåÆØÅ\\-]*$", message = "Etternavn må starte med stor bokstav og kan kun inneholde bokstaver og bindestrek")
    private String etternavn;

    @NotNull
    @Pattern(regexp = "^(mann|kvinne)$", message = "Kjønn må være 'mann' eller 'kvinne'")
    private String kjonn;

    private String hash;
    private String salt;

    public Deltager() {
    }

    public Deltager(String fornavn, String etternavn, String tlf, String kjonn) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.tlf = tlf;
        this.kjonn = kjonn;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getKjonn() {
        return kjonn;
    }

    public void setKjonn(String kjonn) {
        this.kjonn = kjonn;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "<br/>" + fornavn + "<br/>" + etternavn + "<br/>" + tlf + "<br/>" + kjonn;
    }
}
