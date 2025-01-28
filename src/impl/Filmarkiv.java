package impl;

import adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {

	private Film[] filmTabell;
	private int antall;

	// Tomt arkiv med plass til et gitt antall filmer
	public Filmarkiv(int startKapasitet) {
		this.filmTabell = new Film[startKapasitet];
		this.antall = 0;
	}

	@Override
	public Film finnFilm(int nr) {
		for (int i = 0; i < antall; i++) {
			if (filmTabell[i].getFilmnr() == nr) {
				return filmTabell[i];
			}
		}
		return null;
	}
	
	@Override
	public void leggTilFilm(Film nyFilm) {
		if (antall == filmTabell.length) {
			utvidKapasitet();
		}
		filmTabell[antall] = nyFilm;
		antall++;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		for (int i = 0; i < antall; i++) {
			if (filmTabell[i].getFilmnr() == filmnr) {
				filmTabell[i] = filmTabell[antall - 1]; // Flytter siste element til "hullet"
				filmTabell[antall - 1] = null; // Fjerner referansen
				antall--;
				return true;
			}
		}
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		Film[] treff = new Film[antall];
		int treffAntall = 0;
		for (int i = 0; i < antall; i++) {
			if (filmTabell[i].getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
				treff[treffAntall] = filmTabell[i];
				treffAntall++;
			}
		}
		return trimTab(treff, treffAntall);
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		Film[] treff = new Film[antall];
		int treffAntall = 0;
		for (int i = 0; i < antall; i++) {
			if (filmTabell[i].getProdusent().toLowerCase().contains(delstreng.toLowerCase())) {
				treff[treffAntall] = filmTabell[i];
				treffAntall++;
			}
		}
		return trimTab(treff, treffAntall);
	}

	@Override
	public int antall(Sjanger sjanger) {
		int antallSjanger = 0;
		for (int i = 0; i < antall; i++) {
			if (filmTabell[i].getSjanger() == sjanger) {
				antallSjanger++;
			}
		}
		return antallSjanger;
	}

	@Override
	public int antall() {
		return antall;
	}

	// Utvide kapasiteten i tabellen
	private void utvidKapasitet() {
		Film[] nyTabell = new Film[filmTabell.length * 2];
		for (int i = 0; i < antall; i++) {
			nyTabell[i] = filmTabell[i];
		}
		filmTabell = nyTabell;
	}

	// Privat metode for å trimme tabellen til riktig størrelse
	private Film[] trimTab(Film[] tab, int n) {
		// n er antall elementer
		Film[] nytab = new Film[n];
		int i = 0;
		while (i < n) {
			nytab[i] = tab[i];
			i++;
		}
		return nytab;
	}

}
