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
}


