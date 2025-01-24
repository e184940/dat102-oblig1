package oppgave2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import impl.Film;
import impl.Sjanger;

class oppgave2Test {
	
	Filmarkiv2 arkiv = new Filmarkiv2();
	Film film1 = new Film(1, "Produsent1", "Tittel1", 2020, "Filmselskap1", Sjanger.ACTION);
    Film film2 = new Film(2, "Produsent2", "Tittel2", 2019, "Filmselskap2", Sjanger.ACTION);
    Film film3 = new Film(3, "Produsent3", "Tittel3", 2018, "Filmselskap3", Sjanger.ROMANTIC);
	
	@Test
	void testAntall() {
		assertEquals(0, arkiv.antall());
		arkiv.leggTilFilm(film1);
		assertEquals(1, arkiv.antall());
	}
	
	@Test
	void testLeggTilFilm() {
		arkiv.leggTilFilm(film1);
		assertEquals(film1, arkiv.start.data);
		assertEquals(null, arkiv.start.neste);
		assertEquals(1, arkiv.antall());
	}
	
	@Test
	void testFinnFilm() {
		assertEquals(null, arkiv.finnFilm(1));
		arkiv.leggTilFilm(film1);
		arkiv.leggTilFilm(film2);
		assertEquals(film1, arkiv.finnFilm(1));
		assertEquals(film2, arkiv.finnFilm(2));
	}
	
	@Test
	void testSlett() {
		arkiv.leggTilFilm(film1);
		arkiv.leggTilFilm(film2);
		arkiv.leggTilFilm(film3);
		assertEquals(film3, arkiv.finnFilm(3));
		arkiv.slettFilm(3);
		assertNotEquals(film3, arkiv.finnFilm(3));
		assertEquals(null, arkiv.finnFilm(3));
		assertEquals(film2, arkiv.finnFilm(2));
	}
	
	@Test
	void testSoekTittel() {
		arkiv.leggTilFilm(film1);
		arkiv.leggTilFilm(film2);
		arkiv.leggTilFilm(film3);
		
		Film[] result = arkiv.soekTittel("tittel");
		assertEquals(3, result.length);
		result = arkiv.soekTittel("tittel1");
		assertEquals(1, result.length);
	}
	
	@Test
	void testSoekProdusent() {
		arkiv.leggTilFilm(film1);
		arkiv.leggTilFilm(film2);
		arkiv.leggTilFilm(film3);
		
		Film[] result = arkiv.soekProdusent("produsent");
		assertEquals(3, result.length);
		result = arkiv.soekProdusent("produsent2");
		assertEquals(1, result.length);
	}
	
	@Test
	void testAntallSjanger() {
		arkiv.leggTilFilm(film1);
		arkiv.leggTilFilm(film2);
		arkiv.leggTilFilm(film3);
		
		assertEquals(2, arkiv.antall(Sjanger.ACTION));
		assertEquals(1, arkiv.antall(Sjanger.ROMANTIC));
	}

}
