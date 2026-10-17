import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
public class Bibliothekapp {
    public void run() {
        Bibliothek bibliothek = new Bibliothek();

        Book b1 = new Book("Clean Code", "Robert Martin", 45, 464);
        Book b2 = new Book("1984", "George Orwell", 18, 328);
        Book b3 = new Book("Animal Farm", "George Orwell", 12, 112);
        Book b4 = new Book("Java Basics", "Max Müller", 35, 520);
        Book b5 = new Book("The Hobbit", "J. R. R. Tolkien", 28, 310);

        bibliothek.BookHinzufugen(b1);
        bibliothek.BookHinzufugen(b2);
        bibliothek.BookHinzufugen(b3);
        bibliothek.BookHinzufugen(b4);
        bibliothek.BookHinzufugen(b5);

        List<Book> alleBucher = bibliothek.getBucher();
        //1.
        System.out.println("Autor: George Orwell");
        System.out.println("Ergebnis:");
        List<Book> orwellBucher = bibliothek.getBucherVonAutor("George Orwell");
        for (int i = 0; i < orwellBucher.size(); i++) {
            System.out.println(orwellBucher.get(i).getTitel());
        }

        System.out.println();

        //2.
        List<Book> teilListe2 = new ArrayList<>();
        teilListe2.add(b1);
        teilListe2.add(b2);
        teilListe2.add(b3);

        for (int i = 0; i < teilListe2.size(); i++) {
            Book b = teilListe2.get(i);
            System.out.println(b.getTitel() + " -> " + b.getAnzahlseiten() + " Seiten");
        }
        System.out.println("Ergebnis:");
        double durchschnitt = bibliothek.DurchschnittSeitenAnzahl(teilListe2);
        double gerundet = Math.round(durchschnitt * 100.0) / 100.0;
        System.out.println(gerundet);

        //3.
        System.out.println("Maximaler Preis: 30 Euro");
        System.out.println("Ergebnis:");
        List<Book> bis30Euro = bibliothek.getPreislimit(alleBucher, 30);
        for (int i = 0; i < bis30Euro.size(); i++) {
            Book b = bis30Euro.get(i);
            System.out.println(b.getTitel() + " -> " + (int) b.getPreis() + " Euro");
        }

        System.out.println();

        //4.
        List<Book> teilListe4 = new ArrayList<>();
        teilListe4.add(b2);
        teilListe4.add(b3);
        teilListe4.add(b5);

        for (int i = 0; i < teilListe4.size(); i++) {
            Book b = teilListe4.get(i);
            System.out.println(b.getTitel() + " -> " + (int) b.getPreis() + " Euro");
        }
        System.out.println("Ergebnis:");
        Book t = bibliothek.getTeuersteBook(teilListe4);
        if (t != null) {
            System.out.println(t.getTitel() + " (" + (int) t.getPreis() + " Euro)");
        }

        System.out.println();

        //5.
        System.out.println("Mindestanzahl: 300 Seiten");
        System.out.println("Ergebnis:");
        List<Book> ab300Seiten = bibliothek.getBucherMindenstenSeiten(alleBucher, 300);
        for (int i = 0; i < ab300Seiten.size(); i++) {
            System.out.println(ab300Seiten.get(i).getTitel());
        }

        System.out.println();

        //6.
        System.out.println("Budget: 55 Euro");
        System.out.println("Ergebnis:");
        List<Book> paar = bibliothek.getZweiBucher(alleBucher, 55);
        if (paar.size() == 2) {
            Book bA = paar.get(0);
            Book bB = paar.get(1);
            System.out.println(bA.getTitel() + " + " + bB.getTitel());
            System.out.println("Gesamtpreis: " + (int) (bA.getPreis() + bB.getPreis()) + " Euro");
        }
    }
}
