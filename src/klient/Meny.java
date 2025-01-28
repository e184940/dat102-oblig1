package klient;

import adt.FilmarkivADT;
import impl.Film;
import impl.Sjanger;

public class Meny {
    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;

    public Meny(FilmarkivADT filmarkiv) {
        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }

    public void start() {
        // Legg inn noen forhåndsdefinerte filmer
        filmarkiv.leggTilFilm(new Film(1, "Christopher Nolan", "Inception", 2010, "Legendary Pictures Syncopy Films", Sjanger.SCIFI));
        filmarkiv.leggTilFilm(new Film(2, "Steven Spielberg", "Jaws", 1975, "Universal Pictures", Sjanger.HORROR));
        filmarkiv.leggTilFilm(new Film(3, "Quentin Tarantino", "Pulp Fiction", 1994, "A Band Apart", Sjanger.DRAMA));
        filmarkiv.leggTilFilm(new Film(4, "James Cameron", "Avatar", 2009, "20th Century Studios", Sjanger.SCIFI));
        filmarkiv.leggTilFilm(new Film(5, "Ridley Scott", "Gladiator", 2000, "Universal Pictures", Sjanger.ACTION));

        // Start hovedmenyen
        while (true) {
            visMeny();
            int valg = tekstgr.lesInt("Velg et alternativ: ");
            behandleValg(valg);
        }
    }

    private void visMeny() {
    	System.out.println();
        System.out.println("Velkommen til Filmarkiv!");
        System.out.println("1. Finn en film etter nummer");
        System.out.println("2. Legg til en ny film");
        System.out.println("3. Slett en film");
        System.out.println("4. Søk etter filmer basert på tittel");
        System.out.println("5. Søk etter filmer basert på produsent");
        System.out.println("6. Vis antall filmer av en bestemt sjanger");
        System.out.println("7. Vis totalt antall filmer");
        System.out.println("0. Avslutt");
    }

    private void behandleValg(int valg) {
        switch (valg) {
            case 1:
                finnFilm();
                break;
            case 2:
                leggTilFilm();
                break;
            case 3:
                slettFilm();
                break;
            case 4:
                soekTittel();
                break;
            case 5:
                soekProdusent();
                break;
            case 6:
                visAntallAvSjanger();
                break;
            case 7:
                visTotaltAntallFilmer();
                break;
            case 0:
                avsluttProgram();
                break;
            default:
                System.out.println("Ugyldig valg. Prøv igjen.");
        }
    }

    private void finnFilm() {
        int nr = tekstgr.lesInt("Skriv inn filmnummer: ");
        System.out.println();
        Film film = filmarkiv.finnFilm(nr);
        tekstgr.skrivUtFilm(film);
    }

    private void leggTilFilm() {
        Film nyFilm = tekstgr.lesFilm();
        filmarkiv.leggTilFilm(nyFilm);
        System.out.println("Filmen ble lagt til.");
    }

    private void slettFilm() {
        int nr = tekstgr.lesInt("Skriv inn filmnummer som skal slettes: ");
        boolean slettet = filmarkiv.slettFilm(nr);
        if (slettet) {
            System.out.println("Filmen ble slettet.");
        } else {
            System.out.println("Fant ingen film med nummer " + nr);
        }
    }

    private void soekTittel() {
        String delstreng = tekstgr.lesString("Skriv inn del av tittel for å søke: ");
        tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, delstreng);
    }

    private void soekProdusent() {
        String delstreng = tekstgr.lesString("Skriv inn del av produsent for å søke: ");
        tekstgr.skrivUtFilmProdusent(filmarkiv, delstreng);
    }

    private void visAntallAvSjanger() {
        Sjanger sjanger = tekstgr.lesSjanger();
        int antall = filmarkiv.antall(sjanger);
        System.out.println("Antall filmer av sjanger " + sjanger + ": " + antall);
    }

    private void visTotaltAntallFilmer() {
        System.out.println("Totalt antall filmer: " + filmarkiv.antall());
    }

    private void avsluttProgram() {
        System.out.println("Takk for nå! Avslutter programmet.");
        System.exit(0);
    }
}
