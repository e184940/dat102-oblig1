package impl;

import impl.Film;
import impl.Sjanger;

public class Filmarkiv implements adt.FilmarkivADT{
	
	String[] filmTabell;
	int antall;	
	
	@Override
	public Film finnFilm(int nr) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void leggTilFilm(Film nyFilm) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean slettFilm(int filmnr) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Film[] soekTittel(String delstreng) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Film[] soekProdusent(String delstreng) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int antall(Sjanger sjanger) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int antall() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	Filmarkiv[] nyttArkiv = new Filmarkiv[antall];
}
