package Szlachetna;

import java.util.Arrays;

public class MergeSort {
    int[] tabZwrot;
    int porownan = 0;
    int zmian = 0;
    long czas_wykonania;

    public MergeSort(int[] tab) {
        this.czas_wykonania = System.nanoTime();

        int[] zwrot = tab;
        if (tab.length>1){
            MergeSort cz1 = new MergeSort(Arrays.copyOfRange(tab,0,tab.length/2));
            MergeSort cz2 = new MergeSort(Arrays.copyOfRange(tab,(tab.length/2),tab.length));

            this.porownan += cz1.getPorownan() + cz2.getPorownan();
            this.zmian += cz1.getZmian() + cz2.getZmian();

            int[] tab1 = cz1.getTabZwrot();
            int[] tab2 = cz2.getTabZwrot();
            zwrot = merge(tab1, tab2);
        }
        tabZwrot = zwrot;

        this.czas_wykonania = System.nanoTime() - czas_wykonania;
    }

    int[] merge(int[] tab1, int[] tab2){

        int[] zwrot = new int[tab1.length + tab2.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i<tab1.length && j< tab2.length){
            if (tab1[i]<tab2[j]) {
                zwrot[k] = tab1[i];
                i++;
                k++;
            }
            else{
                zwrot[k] = tab2[j];
                j++;
                k++;
                this.zmian++;
            }
            this.porownan++;
        }

        while (i < tab1.length) {
            zwrot[k] = tab1[i];
            i++;
            k++;
        }

        while (j < tab2.length) {
            zwrot[k] = tab2[j];
            j++;
            k++;
        }

        return zwrot;
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
