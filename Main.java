package Szlachetna;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        test(8);
        test(32);
        test(128);
        test(512);
        test(1024);


    }

    static void test(int dlg){
        int[] tabTest1 = tabGenLos(dlg);
        int[] tabTest2 = tabGenOdwrotnie(dlg);
        int[] tabTest3 = tabGenZgodnie(dlg);

        System.out.println("["+dlg+"]");

        System.out.println("los:");
        MergeSort testt = new MergeSort(tabTest1.clone());
        QuickSort testt2 = new QuickSort(tabTest1.clone());
        System.out.println(testt.getPorownan() + "p |merge| z" + testt.getZmian() + " | czas: " + testt.getCzas_wykonania());
        System.out.println(testt2.getPorownan() + "p |quick| z" + testt2.getZmian() + " | czas: " + testt2.getCzas_wykonania());

        System.out.println("odwrotnie:");
        testt = new MergeSort(tabTest2.clone());
        testt2 = new QuickSort(tabTest2.clone());
        System.out.println(testt.getPorownan() + "p |merge| z" + testt.getZmian() + " | czas: " + testt.getCzas_wykonania());
        System.out.println(testt2.getPorownan() + "p |quick| z" + testt2.getZmian() + " | czas: " + testt2.getCzas_wykonania());

        System.out.println("zgodnie:");
        testt = new MergeSort(tabTest3.clone());
        testt2 = new QuickSort(tabTest3.clone());
        System.out.println(testt.getPorownan() + "p |merge| z" + testt.getZmian() + " | czas: " + testt.getCzas_wykonania());
        System.out.println(testt2.getPorownan() + "p |quick| z" + testt2.getZmian() + " | czas: " + testt2.getCzas_wykonania());

        System.out.println("");
    }

    static int[] mergeSort(int[] tab){
        int[] zwrot = tab;
        if (tab.length>1){
            int[] tab1 = mergeSort(Arrays.copyOfRange(tab,0,tab.length/2));
            int[] tab2 = mergeSort(Arrays.copyOfRange(tab,(tab.length/2),tab.length));
            zwrot = merge(tab1, tab2);
        }
        return zwrot;
    }

    static int[] merge(int[] tab1, int[] tab2){

        int[] zwrot = new int[tab1.length + tab2.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i<tab1.length && j< tab2.length){
            if (tab1[i]<=tab2[j]) {
                zwrot[k] = tab1[i];
                i++;
                k++;
            }
            else{
                zwrot[k] = tab2[j];
                j++;
                k++;
            }
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

    static int[] quickSort(int[] tab){
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
                if (tab[i]<=pivot){
                    int temp = tab[j];
                    tab[j] = tab[i];
                    tab[i] = temp;
                    j++;
                    i++;
                }
                else
                    i++;
            }

            int temp = tab[j];
            tab[j] = pivot;
            tab[tab.length-1] = temp;

            int[] tab1 = quickSort(Arrays.copyOfRange(tab, 0,j));
            int[] tab2 = quickSort(Arrays.copyOfRange(tab, j,tab.length));

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
        return zwrot;
    }

    static int[] tabGenLos(int dlg){
        int[] wyjscie = new int[dlg];
        ArrayList<Integer> lista = new ArrayList();
        for (int i=0;i<dlg;i++)
            lista.add(i+1);
        Collections.shuffle(lista);

        for (int i = 0;i<dlg;i++){
            wyjscie[i] = lista.get(i);
        }

        return wyjscie;
    }

    static int[] tabGenOdwrotnie(int dlg){
        int[] wyjscie = new int[dlg];
        for (int i=0;i<dlg;i++)
            wyjscie[i] = dlg-i;

        return wyjscie;
    }

    static int[] tabGenZgodnie(int dlg){
        int[] wyjscie = new int[dlg];
        for (int i=0;i<dlg;i++)
            wyjscie[i] = i;

        return wyjscie;
    }
}
