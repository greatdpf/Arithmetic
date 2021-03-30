package com.greatdpf.heap;

/**
 * @author : dpf
 * @version : V1.0
 * @date : 2021/3/30
 */
public class HeapCoreSort {
    /**
     * 程序的入口
     */
    public static void main(String[] args){
        int[] array = {5,10, 7, 1, 9, 6, 3, 0};

        heapSort(array);

        for (int i = 0;i < array.length;i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

    }

    public static void heapSort(int[] array) {
        int heapSize = array.length;
        for (int i = array.length-1; i >= 0 ; i--) {
            heapIfy(array, i, heapSize);
        }

        int maxValue = array[0];
        heapSize--;
        swap(array, 0, heapSize);
        while (heapSize > 0) {
            heapIfy(array, 0, heapSize);
            heapSize--;
            swap(array, 0, heapSize);
        }



    }

    public static void heapIfy(int[] array, int index, int heapSize) {
        int leftChild = index * 2 + 1;
        while (leftChild < heapSize) {
            int maxChildIndex = leftChild + 1 < heapSize && array[leftChild + 1] > array[leftChild] ? leftChild + 1 : leftChild;
            int maxIndex = array[maxChildIndex] > array[index] ? maxChildIndex : index;
            if (maxIndex == index) {
                break;
            }
            swap(array, maxIndex, index);
            index = maxIndex;
            leftChild = index * 2 + 1;
        }
    }

    public static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

}
