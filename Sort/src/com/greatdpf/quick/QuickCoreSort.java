package com.greatdpf.quick;

/**
 * @author : dpf
 * @version : V1.0
 * @date : 2021/3/29
 */
public class QuickCoreSort {
    /**
     * 程序的入口
     */
    public static void main(String[] args){
        int[] array = {7 ,7 ,7 ,7, 7 ,7, 7, 7 ,6 ,6};

        int left = 0;
        int right = array.length - 1;
        quickSort(array, left, right);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int m = sort(array, left, right);
        quickSort(array, left, m);
        quickSort(array, m+1, right);
    }

    public static int sort(int[] array, int left, int right) {
        int ml = left - 1;
        int t = 0;
        int index = left;
        while (index < right) {
            if (array[index] <= array[right]) {
                t = array[index];
                array[index] = array[ml+1];
                array[ml+1] = t;
                ml++;
            }
            index++;
        }
        t = array[ml+1];
        array[ml+1] = array[right];
        array[right] = t;

        return ml;
    }

}
