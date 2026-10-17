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

}
