package com.suanfa.example.sort;

/**
 * 快速排序
 */
public class QuickSort {
    private static void show(int[] a){
        for(int v:a){
            System.out.print(v+" ");
        }
        System.out.println("");
    }

    public static void main(String[] args){
        int[] a = {3,4,10,5,6,9,8,2,7,1};
        show(a);
        sort(a,0,9);
        show(a);
    }

    private static void sort(int[] a,int lo,int hi){
        if(hi <= lo)
            return;
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    private static boolean less(int i,int j){
        if(i<j)
            return true;
        return false;
    }

    private static int partition(int[] a,int lo,int hi){
        int i = lo;
        i = i + 1;
        int j = hi;
        int v = a[lo];
        while (true){
            while (less(a[i],v)){
                i = i + 1;
                if(i == hi)
                    break;
            }
            while (less(v,a[j])){
                j = j - 1;
                if(j == lo)
                    break;
            }
            if(i >= j)
                break;
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
    }

    private static void exch(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
