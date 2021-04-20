package Szlachetna;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    int[] tabZwrot;
    int porownan = 0;
    int zmian = 0;
    long czas_wykonania;

    public QuickSort(int[] tab) {

        this.czas_wykonania = System.nanoTime();

        int[] zwrot = tab;

        if (tab.length>1) {
            Random rand = new Random();
            int idxP = rand.nextInt(tab.length);
            int pivot = tab[idxP];
            int i = 0;
            int j = 0;
            tab[idxP] = tab[tab.length-1];
            tab[tab.length-1] = pivot;


            while (i < tab.length-1){

                if (tab[i]<pivot){
                    int temp = tab[j];
                    tab[j] = tab[i];
                    tab[i] = temp;
                    j++;
                    i++;
                    this.zmian++;
                }
                else
                    i++;
                this.porownan++;
            }

            int temp = tab[j];
            tab[j] = pivot;
            tab[tab.length-1] = temp;

            QuickSort cz1 = new QuickSort(Arrays.copyOfRange(tab, 0,j));
            QuickSort cz2 = new QuickSort(Arrays.copyOfRange(tab, j,tab.length));

            int[] tab1 = cz1.getTabZwrot();
            int[] tab2 = cz2.getTabZwrot();

            this.zmian += cz1.getZmian() + cz2.getZmian();
            this.porownan += cz1.getPorownan() + cz2.getPorownan();

            zwrot = new int[tab.length];
            int k = 0;

            if (tab1.length>0)
                for (int i1 = 0; i1<tab1.length; i1++){
                    zwrot[k] = tab1[i1];
                    k++;
                }

            if (tab2.length>0)
                for (int i2 = 0; i2<tab2.length; i2++){
                    zwrot[k] = tab2[i2];
                    k++;
                }

        }

        this.tabZwrot = zwrot;
        this.czas_wykonania = System.nanoTime() - czas_wykonania;

    }

    public int[] getTabZwrot() {
        return tabZwrot;
    }

    public int getPorownan() {
        return porownan;
    }

    public int getZmian() {
        return zmian;
    }

    public long getCzas_wykonania() {
        return czas_wykonania;
    }
}
