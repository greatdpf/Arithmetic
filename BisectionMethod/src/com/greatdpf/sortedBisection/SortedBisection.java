package com.greatdpf.sortedBisection;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 排序后二分
 * 1.在某个数组中查找某个数
 *
 * @author : dpf
 * @version : V1.0
 * @date : 2020/10/28
 */
public class SortedBisection {
    /**
     * 程序的入口
     */
    public static void main(String[] args){
        // 测试 50000 组数据
        int testTime = 50000;
        // 最大长度
        int maxSize = 100;
        // 最大值
        int maxValue = 100;
        for (int i = 0;i < testTime;i++) {
            // 随机数
            int num = (int) (Math.random() * (10 + 1));
            // 创建随机数组
            int[] arr = generateRandomArray(maxSize, maxValue);
            // 为随机数组排序
            Arrays.sort(arr);
            // 二分查找
            int index1 = bisection(arr, num);
            ArrayList<Integer> indexes = comparisonBisection(arr, num);
            if (!indexes.contains(index1)) {
                print(arr);
                System.out.println(num);
                System.out.println(index1);
                for (int index : indexes){
                    System.out.println(index + " ");
                }
                System.out.println();
                break;
            }
        }
        int num = (int) (Math.random() * (100 + 1));
        int[] arr = generateRandomArray(maxSize, maxValue);
        System.out.println("生成的随机数组，排序后如下，长度：" + arr.length);
        Arrays.sort(arr);
        print(arr);
        // 二分查找
        int index = bisection(arr, num);
        System.out.println(num + " 所在的数组中的位置：" + index);
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
     * 二分查找法
     * @param arr 排序好的数组
     * @param num 需要查找的数
     * @return 这个数的下标，没有返回 -1
     */
    public static int bisection(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (num == arr[middle]) {
                return middle;
            } else if (num > arr[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    /**
     * 循环遍历查找，对比二分法查找
     * @param arr 数组
     * @param num 需要查找的数
     * @return 返回数的下标
     */
    public static ArrayList comparisonBisection(int[] arr, int num) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0;i < arr.length;i++) {
            if (num == arr[i]) {
                arrayList.add(i);
            }
        }
        if (arrayList.size() == 0) {
            arrayList.add(-1);
        }
        return arrayList;
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
