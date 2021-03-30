package com.greatdpf.heap;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @author : dpf
 * @version : V1.0
 * @date : 2021/3/30
 */
public class HeapSort {
    /**
     * 程序的入口
     */
    public static void main(String[] args){
        int maxSize = 100;
        int maxValue = 100;
        int time = 10000;
        for (int i = 0; i < time; i++) {
            int[] array = generateArray(maxSize, maxValue);
            int[] copyArray = copyArray(array);
            heapSort(array);
            Arrays.sort(copyArray);
            if (!isEquals(array, copyArray)) {
                System.out.println("错误！！！");
                print(array);
                break;
            }
        }
        int[] array = generateArray(maxSize, maxValue);
        heapSort(array);
        print(array);
    }

    public static int[] generateArray(int maxSize, int maxValue) {
        int length = (int) (Math.random() * maxSize + 1);
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = (int) (Math.random() * maxValue + 1) - (int) (Math.random() * maxValue + 1);
        }
        return array;
    }

    public static int[] copyArray(int[] array) {
        int[] copyArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copyArray[i] = array[i];
        }
        return copyArray;
    }

    public static void heapSort(int[] array) {
        int heapSize = array.length;
        for (int i = array.length - 1; i >= 0; i--) {
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
        int leftIndex = index * 2 + 1;
        while (leftIndex < heapSize) {
            int maxChildIndex = leftIndex + 1 < heapSize && array[leftIndex + 1] > array[leftIndex] ? leftIndex + 1 : leftIndex;
            int maxIndex = array[maxChildIndex] > array[index] ? maxChildIndex : index;
            if (maxIndex == index) {
                break;
            }

            swap(array, index, maxIndex);
            index = maxIndex;
            leftIndex = index * 2 + 1;
        }
    }

    public static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static boolean isEquals(int[] array, int[] copyArray) {
        for (int i = 0;i < array.length;i++) {
            if (array[i] != copyArray[i]) {
                return false;
            }
        }
        return true;
    }

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

    }


}
