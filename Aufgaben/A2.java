public class A2 {
    public static int max(int[] n){
        int maxim=n[0];
        for(int i=0;i<n.length;i++){
            if(maxim<n[i])
                maxim=n[i];
        }
        return maxim;
    }
    public static int min(int[] n){
        int minim=n[0];
        for (int i=0;i<n.length;i++){
            if(minim>n[i]){
                minim=n[i];
            }
        }
        return minim;
    }
    public static int sumamax(int[] n){
        int min=min(n);
        int suma=0;
        for (int i=0;i<n.length;i++){
            if(min<n[i]){
                suma=suma+n[i];
            }
        }
        return suma;
    }
    public static int sumamin(int[] n){
        int suma=0;
        int max=max(n);
        for(int i=0;i<n.length;i++){
            if(max>n[i]){
                suma=suma+n[i];
            }
        }
        return suma;
    }
    public static void main(String[] arg){
        int[] n={4,8,3,10,17};
        System.out.println("1.Maximul este:" + max(n));
        System.out.println("2.Min este: " + min(n));
        System.out.println("3.Sumamaxima este: " + sumamax(n));
        System.out.println("4.Sumaminima este: " + sumamin(n));
    }

}
