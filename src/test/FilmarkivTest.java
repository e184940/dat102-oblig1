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
    void setUp() throws Exception {
    	//Opprette en Filmarkiv med startkap: 10
        arkiv = new Filmarkiv(10); 
    }

    @Test
    void testLeggTilOgFjernFilm() {
        Film film1 = new Film(1, "Produsent1", "Tittel1", 2020, "Filmselskap1", Sjanger.ACTION);
        arkiv.leggTilFilm(film1);
        assertEquals(1, arkiv.antall(), "Antall filmer bør være 1 etter å ha lagt til en film.");
        
        //Filmen ble lagt til
        Film funnetFilm = arkiv.finnFilm(1);
        assertNotNull(funnetFilm, "Kunne ikke finne filmen med nummer 1.");
        
        //Fjern filme, sjekk igjen
        boolean slettet = arkiv.slettFilm(film1.getFilmnr());
        assertTrue(slettet, "Filmen burde ha blitt slettet.");
        assertNull(arkiv.finnFilm(film1.getFilmnr()), "Filmen med nummer 1 bør ikke lenger finnes.");
        assertEquals(0, arkiv.antall(), "Antall filmer bør være 0 etter å ha fjernet filmen.");
    }

    @Test
    void testSoekTittel() {
        Film film1 = new Film(1, "Produsent1", "Tittel1", 2020, "Filmselskap1", Sjanger.ACTION);
        Film film2 = new Film(2, "Produsent2", "En annent tittel", 2021, "Filmselskap2", Sjanger.ROMANTIC);
        arkiv.leggTilFilm(film1);
        arkiv.leggTilFilm(film2);
        
        Film[] result = arkiv.soekTittel("tittel");
        assertEquals(2, result.length, "Skal finne to filmer som matcher delstrengen i tittelen.");
    }

    @Test
    void testSoekProdusent() {
        Film film1 = new Film(1, "Produsent1", "Tittel1", 2020, "Filmselskap1", Sjanger.ACTION);
        Film film2 = new Film(2, "Annent Produsent", "Tittel2", 2019, "Filmselskap2", Sjanger.ROMANTIC);
        arkiv.leggTilFilm(film1);
        arkiv.leggTilFilm(film2);
        
        Film[] result = arkiv.soekProdusent("produsent");
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
        
        assertEquals(2, arkiv.antall(Sjanger.ACTION), "Skal være 2 actionfilmer.");
        assertEquals(1, arkiv.antall(Sjanger.ROMANTIC), "Skal være 1 romantisk film.");
    }

}
