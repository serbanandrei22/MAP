public class A1 {
    public static int[] notemici(int[] noten) {
        int c = 0;
        for (int i = 0; i < noten.length; i++) {
            if (noten[i] < 40) {
                c++;
            }
        }
        int rez[] = new int[c];
        int index = 0;
        for (int j = 0; j < noten.length; j++) {
            if (noten[j] < 40) {
                rez[index] = noten[j];
                index++;
            }
        }
        return rez;
    }

    public static double medianote(int[] noten) {
        double rezu = 0;
        for (int i = 0; i < noten.length; i++) {
            rezu = noten[i] + rezu;
        }
        return rezu / noten.length;

    }

    public static int[] rotunjire(int[] noten) {
        int rez[] = new int[noten.length];
        int index = 0;
        for (int i = 0; i < noten.length; i++) {
            if (noten[i] < 38) {
                rez[index] = noten[i];
                index++;
            } else {
                int rest = noten[i] % 5;
                if (rest != 0) {
                    int nota = noten[i] + (5 - rest);
                    if (nota - noten[i] < 3) {
                        rez[index] = nota;
                        index++;
                    } else {
                        rez[index] = noten[i];
                        index++;
                    }
                } else {
                    rez[index] = noten[i];
                    index++;
                }
            }
        }
        return rez;
    }

    public static int max(int[] noten) {
        int[] rotunjit = rotunjire(noten);
        int max = rotunjit[0];
        for (int i = 0; i < rotunjit.length; i++) {
            if (max < rotunjit[i])
                max = rotunjit[i];
        }
        return max;
    }

    public static void main(String[] arg) {
        int[] noten = {29, 37, 38, 41, 84, 67};
        int[] picat = notemici(noten);
        System.out.print("1.Notepicate:");
        for (int i = 0; i < picat.length; i++) {
            System.out.print(picat[i] + " ");
        }
        System.out.println();
        System.out.println("2. Durchschnitt: " + medianote(noten));
        int[] rotunjite = rotunjire(noten);
        System.out.print("3. Abgerundete Noten: ");
        for (int i = 0; i < rotunjite.length; i++) {
            System.out.print(rotunjite[i] + " ");
        }
        System.out.println();
        System.out.println("4. Max abgerundet: " + max(noten));
    }

}