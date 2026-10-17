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

    }
}
