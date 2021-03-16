package com.greatdpf.insert;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author : dpf
 * @version : V1.0
 * @date : 2020/10/25
 */
public class InsertSort {
    /**
     * 程序的入口
     */
    public static void main(String[] args){
        // 测试次数
        int testTime = 50000;
        // 数组最大长度
        int maxSize = 100;
        // 数组最大值
        int maxValue = 100;
        // 测试开始
        for (int i = 0;i < testTime;i++) {
            // 生成随机数组
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            // 复制生成的数组，用以做对比
            int[] arr2 = copyArray(arr1);
            // 插入排序
            insertSort(arr1);
            // 工具类排序
            Arrays.sort(arr2);
            // 判断两个数组是否一致，不一致打印并退出。
            if (!isEquals(arr1, arr2)) {
                print(arr1);
                print(arr2);
                break;
            }
        }
        // 查看一组正确结果
        int[] arr = generateRandomArray(maxSize, maxValue);
        System.out.println("生成的随机数组如下，长度：" + arr.length);
        print(arr);
        insertSort(arr);
        System.out.println("排序后结果：");
        print(arr);

    }

    /**
     * 生成随机数组
     * @param maxSize 最大长度
     * @param maxValue 最大值
     * @return 返回随机数组
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // [1, maxSize]
        int size = (int)(Math.random() * (maxSize + 1));
        // 创建数组
        int[] array = new int[size];
        // 赋值
        for (int i = 0;i < size;i++) {
            array[i] = (int)(Math.random() * (maxValue + 1)) - (int)(Math.random() * (maxValue + 1));
        }
        return array;
    }

    /**
     * 复制随机数组
     * @param arr 传入的数组
     * @return 返回新的数组
     */
    public static int[] copyArray(int[] arr) {
        // 创建数组
        int[] array = new int[arr.length];
        // 赋值
        for (int i = 0;i < arr.length;i++) {
            array[i] = arr[i];
        }
        return array;
    }

    /**
     * 插入排序
     * @param array 需要排序的数组
     */
    public static void insertSort(int[] array) {
        // 如果数组为空，或者数组的长度为2，则直接返回，因为天然有序。
        if (array == null || array.length < 2) {
            return;
        }
        // 先判断 0~i，是否有序，在判断 1 ~ i + 1是否有序......
        for (int i = 1;i < array.length;i++) {
            // array[i] > array[i+1],就向后移动（插入），直到位于 0 位置。
            for (int j = i - 1;j >= 0;j--) {
                if (array[j] > array[j+1]) {
                    swap(array, j, j+1);
                }
            }
        }
    }

    /**
     * 两数交换
     * @param arr 需要交换的数组
     * @param i 需要交换的位置 i
     * @param j 需要交换的位置 j
     */
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /**
     * 判断两数组是否一致
     * @param arr1 数组 1
     * @param arr2 数组 2
     * @return true 为相同，false 为不同
     */
    public static boolean isEquals(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 != null) {
            return false;
        }
        if (arr1 != null && arr2 == null) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        for (int i = 0; i < arr1.length;i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印
     * @param arr 数组
     */
    public static void print(int[] arr) {
        for (int i = 0;i < arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
