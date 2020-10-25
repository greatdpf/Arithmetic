package com.greatdpf.select;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author : staring
 * @date : 2020/10/21
 * @version : V1.0
 */
public class SelectSort {
    /**
     * 程序的入口
     */
    public static void main(String[] args) {
        System.out.println("选择排序算法");
        // 数组的最大长度
        int maxSize = 100;
        // 数组中数的最大值
        int maxValue = 100;
        // 测试 500000 数据
        int testTime = 50000;
        for (int i = 0;i < testTime;i++) {
            // 传入最大长度和最大值，生成随机数组 arr1
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            // 复制 arr1 数组
            int[] arr2 = copyArray(arr1);
            // 将两个数组分别进行排序，一个采用自己写的排序，一个采用jdk自带的排序
            // 随后将两个数组进行对比，如果排序后结果不一样，则自己写的排序有问题
            // 自己写的选择排序
            selectSort(arr1);
            // Arrays 工具类中的 sort(int[] array) 排序
            Arrays.sort(arr2);
            // 比对两个排序后的数组是否相同，不同则打印数据并且停止循环
            if (!isEquals(arr1, arr2)) {
                // 将排序出现问题的数据打印在控制台
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        // 在生成一组数据
        int[] arr = generateRandomArray(maxSize, maxValue);
        System.out.println("生成的随机数组如下，长度：" + arr.length);
        // 打印
        printArray(arr);
        // 排序
        selectSort(arr);
        System.out.println("排序后结果：");
        // 打印
        printArray(arr);
    }

    /**
     * 产生随机数组
     * 使用 Math 中的静态方法 random() 产生随机数组
     * 随机数组：长度随机，值随机。
     * random() 解释如下
     * Math.random() [0, 1)  表示 0 ~ 1 范围的浮点数，1不取
     * Math.random() * N [0, N)  表示 0 ~ N 范围的浮点数，N不取
     * (int) (Math.random() * N) [0, N-1]  表示 0 ~ N-1 范围的整数，0和N都取，且都是整数
     *
     * @param maxSize 数组最大长度
     * @param maxValue 数组最大值
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // 数组的具体长度，[1, maxSize]，maxSize + 1，防止数组长度为 0 ,且能够取到 maxSize
        int size = (int) (Math.random() * (maxSize+1));
        // 定义数组,长度为 size
        int[] array = new int[size];
        // 为数组赋值
        for (int i = 0;i < array.length;i++) {
            // 两个随机数相减，目的产生负整数
            array[i] = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * maxValue);
        }
        return array;
    }

    /**
     * 复制数组
     * @param array 随机产生的数组
     */
    public static int[] copyArray(int[] array) {
        if (array == null) {
            return null;
        }
        int[] res = new int[array.length];
        for (int i = 0;i < res.length;i++) {
            res[i] = array[i];
        }
        return res;
    }

    /**
     * 选择排序
     * 每次都找到最小值，然后交换，直到结束。
     *
     * @param arr 排序的数组
     */
    public static void selectSort(int[] arr) {
        // 第一重循环，第 i 次在第 arr - i 个数中找最小值
        for (int i = 0;i < arr.length;i++) {
            // 定义最小值在 i 这个位置上
            int minIndex = i;
            // 第二重循环，遍历数组，寻找最小值
            for (int j = i;j < arr.length;j++) {
                // 如果 j 位置上的数 比 minIndex 上的位置数小，就记录最小值位置
                if (arr[minIndex] >= arr[j]) {
                    minIndex = j;
                }
            }
            // 找到最小值后，交换。
            swap(arr, i, minIndex);
        }
    }

    /**
     * 数组间的两个数进行交换
     * ps：这是数组，可以这样交换；如果是数，这种交换没意义
     * @param array 数组
     * @param a     需要交换的数 a
     * @param b     需要交换的数 b
     */
    public static void swap(int[] array, int a, int b) {
        int t = array[a];
        array[a] = array[b];
        array[b] = t;
    }

    /**
     * 判断两个数组是否是一样的
     * @param arr1 数组1
     * @param arr2 数组2
     * @return 返回 boolean 类型值 true 为相同，false 为不同
     */
    public static boolean isEquals(int[] arr1, int[] arr2) {
        // 如果两个数组有一个为空。则不等
        if (arr1 != null && arr2 == null) {
            return false;
        }
        if (arr1 == null && arr2!=null) {
            return false;
        }
        // 如果两个数组都为空，则相同
        if (arr1 == null && arr2 == null) {
            return true;
        }
        // 如果两个数组长度不同，则不同
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0;i < arr1.length;i++) {
            //如果两个数组在同一个位置的数不同，则不同
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 将数组打印在控制台
     * @param arr 需要打印的数组
     */
    public static void printArray(int[] arr) {
        if (arr == null) {
            System.out.println("数组为空");
            return;
        }
        // 循环打印数组
        for (int i = 0;i < arr.length;i++) {
            // 注意不换行
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


}
