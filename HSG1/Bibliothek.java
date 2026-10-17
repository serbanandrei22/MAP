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
    public List<Book> getPreislimit(List<Book> bookListe, double maxPreis){
        List<Book> rez= new ArrayList<>();
        if (bookListe != null){
            for (int i = 0; i<bookListe.size(); i++) {
                Book b = bookListe.get(i);
                if (b.getPreis() <= maxPreis) {
                    rez.add(b);
                }
            }

        }
        return rez;
    }
    public Book getTeuersteBook(List<Book> bookListe){
        if(bookListe == null || bookListe.isEmpty()){
            return null ;
        }
        Book t=bookListe.get(0);
        for(int i=1;i<bookListe.size();i++){
            Book b=bookListe.get(i);
            if(b.getPreis()>t.getPreis()){
                t=b;
            }

        }
        return t;

    }
    public List<Book> getBucherMindenstenSeiten(List<Book> bookListe,int m){
        List<Book> rez=new ArrayList<>();
        if(bookListe != null){
            for(int i=0;i< bookListe.size();i++){
                Book b=bookListe.get(i);
                if(b.getAnzahlseiten()>=m){
                    rez.add(b);
                }
            }
        }
        return rez;
    }
    public List<Book> getZweiBucher(List<Book> bookliste,double buget){
        List<Book> rez=new ArrayList<>();
        if (bookliste == null || bookliste.isEmpty()){
            return rez;
        }
        double maxP=-1.0;
        int maxS=-1;
        Book g1=null;
        Book g2=null;

        for(int i =0; i<bookliste.size();i++){
            for(int j=i+1;j<bookliste.size();j++){
                Book b1=bookliste.get(i);
                Book b2=bookliste.get(j);

                double summeP=b1.getPreis()+b2.getPreis();
                if(summeP<= buget){
                    int summeS=b1.getAnzahlseiten()+b2.getAnzahlseiten();
                    if(summeP> maxP || (summeP == maxP && summeS>maxS)){
                        maxP=summeP;
                        maxS=summeS;
                        g1=b1;
                        g2=b2;
                    }
                }
            }
        }
        if(g1 != null && g2 != null){
            rez.add(g1);
            rez.add(g2);
        }
        return rez;
    }
}


