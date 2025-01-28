package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import impl.Film;
import impl.Filmarkiv;
import impl.Sjanger;

class FilmarkivTest {

    private Filmarkiv arkiv;

    @BeforeEach
    void setUp() {
        // Opprette et Filmarkiv med startkapasitet: 10
        arkiv = new Filmarkiv(10); 
    }

    @Test
    void testLeggTilOgFjernFilm() {
        Film film1 = new Film(1, "Produsent1", "Tittel1", 2020, "Filmselskap1", Sjanger.ACTION);
        arkiv.leggTilFilm(film1);
        
        // Sjekk at film ble lagt til
        assertEquals(1, arkiv.antall(), "Antall filmer bør være 1 etter å ha lagt til en film.");
        
        // Sjekk at film finnes
        Film funnetFilm = arkiv.finnFilm(1);
        assertNotNull(funnetFilm, "Fant ikke film med nummer 1.");
        
        // Fjern film og sjekk igjen
        boolean slettet = arkiv.slettFilm(film1.getFilmnr());
        assertTrue(slettet, "Filmen burde ha blitt slettet.");
        assertNull(arkiv.finnFilm(film1.getFilmnr()), "Film med nummer 1 bør ikke lenger finnes.");
        assertEquals(0, arkiv.antall(), "Antall filmer bør være 0 etter å ha fjernet filmen.");
    }

    @Test
    void testSoekTittel() {
        Film film1 = new Film(1, "Produsent1", "Tittel1", 2020, "Filmselskap1", Sjanger.ACTION);
        Film film2 = new Film(2, "Produsent2", "En annent tittel", 2021, "Filmselskap2", Sjanger.ROMANTIC);
        arkiv.leggTilFilm(film1);
        arkiv.leggTilFilm(film2);
        
        // Søk etter delstreng i tittelen
        Film[] result = arkiv.soekTittel("tittel");
        
        // Verifiser at begge filmer ble funnet
        assertEquals(2, result.length, "Skal finne to filmer som matcher delstrengen i tittelen.");
    }

    @Test
    void testSoekProdusent() {
        Film film1 = new Film(1, "Produsent1", "Tittel1", 2020, "Filmselskap1", Sjanger.ACTION);
        Film film2 = new Film(2, "Annent Produsent", "Tittel2", 2019, "Filmselskap2", Sjanger.ROMANTIC);
        arkiv.leggTilFilm(film1);
        arkiv.leggTilFilm(film2);
        
        // Søk etter delstreng i produsenten
        Film[] result = arkiv.soekProdusent("produsent");
        
        // Verifiser at begge filmer ble funnet
        assertEquals(2, result.length, "Skal finne to filmer som matcher delstrengen i produsent.");
    }

    @Test
    void testAntallSjanger() {
        Film film1 = new Film(1, "Produsent1", "Tittel1", 2020, "Filmselskap1", Sjanger.ACTION);
        Film film2 = new Film(2, "Produsent2", "Tittel2", 2019, "Filmselskap2", Sjanger.ACTION);
        Film film3 = new Film(3, "Produsent3", "Tittel3", 2018, "Filmselskap3", Sjanger.ROMANTIC);
        arkiv.leggTilFilm(film1);
        arkiv.leggTilFilm(film2);
        arkiv.leggTilFilm(film3);
        
        // Sjekk antall filmer per sjanger
        assertEquals(2, arkiv.antall(Sjanger.ACTION), "Skal være 2 actionfilmer.");
        assertEquals(1, arkiv.antall(Sjanger.ROMANTIC), "Skal være 1 romantisk film.");
    }

    @Test
    void testUtvidKapasitet() {
        // Sjekk hvis kapasitet utvides da antall filmer når max kapasitet
        for (int i = 0; i < 10; i++) {
            arkiv.leggTilFilm(new Film(i + 1, "Produsent" + (i + 1), "Tittel" + (i + 1), 2020, "Filmselskap" + (i + 1), Sjanger.ACTION));
        }
        
        assertEquals(10, arkiv.antall(), "Antall filmer bør være 10 etter å ha lagt til 10 filmer.");
        
        // Legg til ny film og sjekk at kapasiteten har blitt utvid
        arkiv.leggTilFilm(new Film(11, "Produsent11", "Tittel11", 2020, "Filmselskap11", Sjanger.SCIFI));
        assertEquals(11, arkiv.antall(), "Antall filmer bør være 11 etter å ha lagt til en film etter kapasiteten er utvidet.");
    }
}
