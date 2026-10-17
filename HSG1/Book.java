public class Book {
    private String titel;
    private String autor;
    private double preis;
    private int seiten;

    public Book(String titel,String autor,double preis,int seiten){
        this.titel=titel;
        this.autor=autor;
        this.preis=preis;
        this.seiten=seiten;
    }
    public String getTitel(){
        return titel;
    }
    public String getAutor(){
        return autor;
    }
    public double getPreis(){
        return preis;
    }
    public int getAnzahlseiten(){
        return seiten;

    }
    @Override
    public String toString(){
        return titel + ", " + autor + ", " + preis + " Euro, " + seiten + " Seiten ";
    }
}
