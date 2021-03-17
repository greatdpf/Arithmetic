package com.greatdpf.select;

/**
 * @author : dpf
 * @version : V1.0
 * @date : 2021/3/13
 * 选择排序核心代码
 *
 */
public class SelectCoreCode {
    /**
     * 程序的入口
     */
    public static void main(String[] args){
        int[] array = {1, 7, 4, 2, 6, 8, 3, 5, 9};
        // 中间值，用于交换
        int k = 0;
        //
        for (int i = 0; i < array.length; i++) {
            int max = i;
            // 寻找未排序数中的最大值
            for (int j = i;j < array.length; j++) {
                // 如果有比 max 还大的数，就将其传给 max 因为 max 一直是最大的，
                if (array[j] > array[max]) {
                    max = j;
                }
            }
            System.out.println(array[max] + " " + i);
            k = array[i];
            array[i]=array[max];
            array[max] = k;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }
}
