package oppgave2;

import adt.FilmarkivADT;
import impl.Film;
import impl.Sjanger;

public class Filmarkiv2 implements FilmarkivADT {
	
	private int antall;
	public LinearNode<Film> start;

	@Override
	public Film finnFilm(int nr) {
		LinearNode<Film> p = start;
		
		while(p != null) {
			if (p.data.getFilmnr() == nr) {
				return p.data;
			}
			p = p.neste;
		}
		return null;
		
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		LinearNode<Film> ny = new LinearNode<>();
		ny.data = nyFilm;
		ny.neste = start;
		start = ny;
		antall++;
		
	}

	@Override
	public boolean slettFilm(int filmnr) {
		
		LinearNode<Film> p = start;
		
		while (p != null) {
			if (p.data.getFilmnr() == filmnr) {
				p.data = start.data;
				start = start.neste;
				antall--;
				
				return true;
			}
			p = start.neste;
		}
		
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		LinearNode<Film> p = start;
		Film[] treff = new Film[antall];
		int treffAntall = 0;
		
		for (int i = 0; i < antall; i++) {
			if (p.data.getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
				treff[treffAntall] = p.data;
				treffAntall++;
			}
			p = p.neste;
		}
		
		return trimTab(treff, treffAntall);
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		LinearNode<Film> p = start;
		Film[] treff = new Film[antall];
		int treffAntall = 0;
		
		for (int i = 0; i < antall; i++) {
			if (p.data.getProdusent().toLowerCase().contains(delstreng.toLowerCase())) {
				treff[treffAntall] = p.data;
				treffAntall++;
			}
			p = p.neste;
		}
		
		return trimTab(treff, treffAntall);
	}

	@Override
	public int antall(Sjanger sjanger) {
		LinearNode<Film> p = start;
		int antallSjanger = 0;
		
		for (int i = 0; i < antall; i++) {
			if (p.data.getSjanger() == sjanger) {
				antallSjanger++;
			}
			p = p.neste;
		}
		
		return antallSjanger;
	}

	@Override
	public int antall() {
		return this.antall;
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
