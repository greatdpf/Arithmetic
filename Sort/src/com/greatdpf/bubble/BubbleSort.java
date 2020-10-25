package com.greatdpf.bubble;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author : dpf
 * @version : V1.0
 * @date : 2020/10/25
 */
public class BubbleSort {
    /**
     * 程序的入口
     */
    public static void main(String[] args){
        // 测试的次数
        int testTime = 50000;
        // 数组的最大长度
        int maxSize = 100;
        // 数组的最大值
        int maxValue = 100;
        for (int i = 0; i < testTime;i++) {
            // 随机生成动态数组
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            // 复制一个数组，用于对比
            int[] arr2 = copyArray(arr1);
            // 选择排序
            bubbleSort(arr1);
            // 工具类排序
            Arrays.sort(arr2);
            // 判断两个排序结束后的数组是否一样，不一样直接打印并退出循环。
            if (!isEquals(arr1, arr2)) {
                print(arr1);
                print(arr2);
                break;
            }
        }
        // 查看一组数据
        int[] arr = generateRandomArray(maxSize, maxValue);
        System.out.println("生成的随机数组如下，长度：" + arr.length);
        print(arr);
        // 排序
        bubbleSort(arr);
        System.out.println("排序后结果：");
        // 打印
        print(arr);

    }

    /**
     * 生成随机数组
     * @param maxSize 数组可取的最大长度
     * @param maxValue 数组可取的最大值
     * @return 返回生成好的数组
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // 确定数组的长度 [1, 100]
        int size = (int) (Math.random() * (maxSize + 1));
        // 创建数组
        int[] arr = new int[size];
        for (int i = 0;i < size;i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * (maxValue + 1));
        }
        return arr;
    }

    /**
     * 复制数组
     * @param arr 数组
     * @return 返回复制好的数组
     */
    public static int[] copyArray(int[] arr) {
        int[] array = new int[arr.length];
        for (int i = 0;i < array.length;i++) {
            array[i] = arr[i];
        }
        return array;
    }

    /**
     * 冒泡排序
     * @param arr 需要排序的数组
     * @return 排序好的数组
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1;i > 0;i--) {
            for (int j = 0;j < i;j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    /**
     * 交换两个数
     * 这边采用的异或运算，不清楚的可以看异或运算章节。
     * 这里一定得记住，单纯交换两个数是不会交换，但是如果交换的是数组中的两个数，就可以
     * 具体可以画内存空间以及弄清楚java值传递
     * @param a
     * @param b
     */
    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }

    /**
     * 比较两个数组是否一样
     * @param arr1 自我实现排序的数组
     * @param arr2 系统功能实现排序的数组
     * @return 相等就返回true，否则false
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
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0;i < arr1.length;i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印数组
     * @param array 需要打印的数组
     */
    public static void print(int[] array) {
        for (int a : array) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

}
