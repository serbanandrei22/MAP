import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliothekConsole {
    private Bibliothek bibliothek;
    private Scanner scanner;

    public BibliothekConsole() {
        this.bibliothek = new Bibliothek();
        this.scanner = new Scanner(System.in);

        Book b1 = new Book("Clean Code", "Robert Martin", 45, 464);
        Book b2 = new Book("1984", "George Orwell", 18, 328);
        Book b3 = new Book("Animal Farm", "George Orwell", 12, 112);
        Book b4 = new Book("Java Basics", "Max Muller", 35, 520);
        Book b5 = new Book("The Hobbit", "J. R. R. Tolkien", 28, 310);

        bibliothek.BookHinzufugen(b1);
        bibliothek.BookHinzufugen(b2);
        bibliothek.BookHinzufugen(b3);
        bibliothek.BookHinzufugen(b4);
        bibliothek.BookHinzufugen(b5);
    }

    public void start() {
        int opt = -1;

        while (opt != 0) {
            System.out.println("\n--- Menue ---");
            System.out.println("1. Buch hinzufugen");
            System.out.println("2. Alle Bucher anzeigen");
            System.out.println("3. Bucher von Autor");
            System.out.println("4. Durchschnitt Seitenanzahl");
            System.out.println("5. Bucher bis max Preis");
            System.out.println("6. Teuerste Buch");
            System.out.println("7. Bucher mit Mindestseiten");
            System.out.println("8. Zwei Bucher fur Budget");
            System.out.println("0. Exit");
            System.out.print("Option: ");

            opt = scanner.nextInt();
            scanner.nextLine();

            if (opt == 1) {
                System.out.print("Titel: ");
                String titel = scanner.nextLine();
                System.out.print("Autor: ");
                String autor = scanner.nextLine();
                System.out.print("Preis: ");
                double preis = scanner.nextDouble();
                System.out.print("Seiten: ");
                int seiten = scanner.nextInt();
                scanner.nextLine();

                Book b = new Book(titel, autor, preis, seiten);
                bibliothek.BookHinzufugen(b);
                System.out.println("Buch hinzugefugt!");

            } else if (opt == 2) {
                List<Book> liste = bibliothek.getBucher();
                for (int i = 0; i < liste.size(); i++) {
                    System.out.println(liste.get(i).toString());
                }

            } else if (opt == 3) {
                System.out.print("Autor: ");
                String autor = scanner.nextLine();
                List<Book> res = bibliothek.getBucherVonAutor(autor);
                for (int i = 0; i < res.size(); i++) {
                    System.out.println(res.get(i).getTitel());
                }

            } else if (opt == 4) {
                double avg = bibliothek.DurchschnittSeitenAnzahl(bibliothek.getBucher());
                double gerundet = Math.round(avg * 100.0) / 100.0;
                System.out.println("Durchschnitt: " + gerundet);

            } else if (opt == 5) {
                System.out.print("Max Preis: ");
                double maxP = scanner.nextDouble();
                scanner.nextLine();
                List<Book> res = bibliothek.getPreislimit(bibliothek.getBucher(), maxP);
                for (int i = 0; i < res.size(); i++) {
                    Book b = res.get(i);
                    System.out.println(b.getTitel() + " -> " + b.getPreis());
                }

            } else if (opt == 6) {
                Book b = bibliothek.getTeuersteBook(bibliothek.getBucher());
                if (b != null) {
                    System.out.println("Teuerste Buch: " + b.getTitel() + " (" + b.getPreis() + ")");
                }

            } else if (opt == 7) {
                System.out.print("Mindestseiten: ");
                int minS = scanner.nextInt();
                scanner.nextLine();
                List<Book> res = bibliothek.getBucherMindenstenSeiten(bibliothek.getBucher(), minS);
                for (int i = 0; i < res.size(); i++) {
                    Book b = res.get(i);
                    System.out.println(b.getTitel() + " -> " + b.getAnzahlseiten());
                }

            } else if (opt == 8) {
                System.out.print("Budget: ");
                double budget = scanner.nextDouble();
                scanner.nextLine();
                List<Book> res = bibliothek.getZweiBucher(bibliothek.getBucher(), budget);
                if (res.size() == 2) {
                    Book b1 = res.get(0);
                    Book b2 = res.get(1);
                    System.out.println(b1.getTitel() + " + " + b2.getTitel());
                    System.out.println("Gesamtpreis: " + (b1.getPreis() + b2.getPreis()));
                } else {
                    System.out.println("Keine Kombination gefunden.");
                }
            }
        }
    }
}