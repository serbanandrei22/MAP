public class A1 {
    public static int[] notemici(int[] noten){
        int c=0;
        for(int i=0;i<noten.length;i++){
            if (noten[i]<40){
                c++;
        }
        }
        int rez[]=new int[c];
        int index=0;
        for(int j=0;j<noten.length;j++){
            if(noten[j]<40){
                rez[index]=noten[j];
                index++;
            }
        }
        return rez;
    }
    public static double medianote(int[] noten){
            double rezu=0;
            for(int i=0;i<noten.length;i++){
                rezu=noten[i]+rezu;
            }
                return rezu / noten.length;

    }
    public static int[] rotunjire(int[] noten){

    }
}
