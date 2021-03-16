package com.greatdpf.insert;

/**
 * @author : dpf
 * @version : V1.0
 * @date : 2021/3/16
 *
 * 插入排序核心代码
 *
 */
public class InsertSortCoreCode {
    /**
     * 程序的入口
     */
    public static void main(String[] args){
        int[] array = {4, 7, 4, 2, 6, 8, 3, 5, 9};
        int t = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = i;j > 0 && array[j] < array[j-1];j--) {
                t = array[j];
                array[j] = array[j-1];
                array[j-1] = t;
            }
            for (int k = 0; k < array.length; k++) {
                System.out.print(array[k] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();


    }
}
