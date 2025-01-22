package impl;

import java.util.Objects;

public class Film {
	private int filmnr;
	private String produsent;
	private String tittel;
	private int lansering;
	//private enum SJANGER;
	private String filmselskap;
	
	public Film() {
		this.filmnr = 0;
		this.produsent = null;
		this.tittel = null;
		this.lansering = 0;
		this.filmselskap = null;
	}
	
	public Film(
			int filmnr, String produsent, String tittel, int lansering, String filmselskap) {
		this.filmnr = filmnr;
		this.produsent = produsent;
		this.tittel = tittel;
		this.lansering = lansering;
		this.filmselskap = filmselskap;
	}
	
	public int getFilmnr() {
		return this.filmnr;
	}
	
	public void setFilmnr(int filmnr) {
		this.filmnr = filmnr;
	}
	
	public String getProdusent() {
		return this.produsent;
	}
	
	public void setProdusent(String produsent) {
		this.produsent = produsent;
	}
	
	public String getTittel() {
		return this.tittel;
	}
	
	public void setTittel(String tittel) {
		this.tittel = tittel;
	}
	
	public int getLansering() {
		return this.lansering;
	}
	
	public void setLansering(int lansering) {
		this.lansering = lansering;
	}
	
	public String getFilmselskap() {
		return this.filmselskap;
	}
	
	public void setFilmselskap(String filmselskap) {
		this.filmselskap = filmselskap;
	}

	@Override
	public int hashCode() {
		return Objects.hash(filmnr, filmselskap, lansering, produsent, tittel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return filmnr == other.filmnr && Objects.equals(filmselskap, other.filmselskap) && lansering == other.lansering
				&& Objects.equals(produsent, other.produsent) && Objects.equals(tittel, other.tittel);
	}

}
