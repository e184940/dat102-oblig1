package klient;

import adt.FilmarkivADT;
import impl.Filmarkiv;

public class FilmarkivMain {

	public static void main(String[] args) {
		FilmarkivADT filma = new Filmarkiv(100);
		Meny meny = new Meny(filma);
		meny.start();
	}
}