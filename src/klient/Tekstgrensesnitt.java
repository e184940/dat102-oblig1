package klient;

import java.util.Scanner;

import adt.FilmarkivADT;
import impl.Film;
import impl.Sjanger;

public class Tekstgrensesnitt {
    private Scanner scanner;

    public Tekstgrensesnitt() {
        scanner = new Scanner(System.in);
    }

    public Film lesFilm() {
        int nr = lesInt("Skriv inn filmnummer: ");
        String produsent = lesString("Skriv inn produsent: ");
        String tittel = lesString("Skriv inn tittel: ");
        int aar = lesInt("Skriv inn år: ");
        String selskap = lesString("Skriv inn filmselskap: ");
        Sjanger sjanger = lesSjanger();
        return new Film(nr, produsent, tittel, aar, selskap, sjanger);
    }

    public void skrivUtFilm(Film film) {
        if (film == null) {
            System.out.println("Ingen film funnet.");
        } else {
            System.out.println(film);
        }
    }

    public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
        Film[] filmer = arkiv.soekTittel(delstreng);
        if (filmer.length > 0) {
            System.out.println("Filmer som matcher delstreng '" + delstreng + "' i tittelen:");
            for (Film film : filmer) {
                System.out.println(film);
            }
        } else {
            System.out.println("Fant ingen filmer med delstreng '" + delstreng + "' i tittelen.");
        }
    }

    public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
        Film[] filmer = arkiv.soekProdusent(delstreng);
        if (filmer.length > 0) {
            System.out.println("Filmer som matcher delstreng '" + delstreng + "' i produsent:");
            for (Film film : filmer) {
                System.out.println(film);
            }
        } else {
            System.out.println("Fant ingen filmer med delstreng '" + delstreng + "' i produsent.");
        }
    }

    public void skrivUtStatistikk(FilmarkivADT arkiv) {
        int totalFilmer = arkiv.antall();
        System.out.println("Totalt antall filmer: " + totalFilmer);
        
        for (Sjanger sjanger : Sjanger.values()) {
            int antall = arkiv.antall(sjanger);
            System.out.println(sjanger + ": " + antall);
        }
    }

    int lesInt(String melding) {
        System.out.print(melding);
        while (!scanner.hasNextInt()) {
            System.out.print("Vennligst skriv inn et gyldig tall: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    String lesString(String melding) {
        System.out.print(melding);
        scanner.nextLine(); // Fjerner eventuelle linjeskift
        return scanner.nextLine();
    }

    Sjanger lesSjanger() {
        System.out.println("Velg en sjanger:");
        for (Sjanger s : Sjanger.values()) {
            System.out.println("- " + s);
        }
        while (true) {
            String input = lesString("Skriv inn sjanger: ").toUpperCase();
            try {
                return Sjanger.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Ugyldig sjanger. Prøv igjen.");
            }
        }
    }
}
