import java.util.ArrayList;
import java.util.List;
public class Bibliothek {
    private List<Book> bucher;
    public Bibliothek(){
        this.bucher=new ArrayList<>();

    }
    public void BookHinzufugen(Book book){
        this.bucher.add(book);
    }
    public List<Book> getBucher(){
        return this.bucher;
    }

    public List<Book> getBucherVonAutor(String autor){
        List<Book> rez=new ArrayList<>();
        for(int i =0;i<this.bucher.size();i++){
            Book b=this.bucher.get(i);
            if(b.getAutor().equalsIgnoreCase(autor)){
                rez.add(b);
            }
        }
        return rez;
    }
    public double DurchschnittSeitenAnzahl(List<Book> bookListe){
        if(bookListe == null || bookListe.isEmpty()){
            return 0.0;
        }
        int summe=0;
        for(int i=0;i<bookListe.size();i++){
            Book b=bookListe.get(i);
            summe=summe+b.getAnzahlseiten();
        }
        return (double) summe/ bookListe.size();

    }

}


