package com.greatdpf.bubble;

/**
 * @author : dpf
 * @version : V1.0
 * @date : 2021/3/13
 */
public class BubbleSortCoreCode {
    /**
     * 程序的入口
     */
    public static void main(String[] args){
        int[] array = {1, 7, 4, 2, 6, 8, 3, 5, 9};
        int k = 0;
        // 循环未排序数组 [0, i]；
        for (int i = array.length-1;i >= 0;i--) {
            // 将未排序数依次两两之间进行比较，最大/小值置于最右边
            for (int j = 0; j < i;j++) {
                if (array[j] > array[j+1]) {
                    k = array[j];
                    array[j] = array[j+1];
                    array[j+1] = k;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

    }
}
