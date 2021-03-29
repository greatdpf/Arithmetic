package com.greatdpf.quick;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author : dpf
 * @version : V1.0
 * @date : 2021/3/29
 */
public class QuickSort {
    /**
     * 程序的入口
     */
    public static void main(String[] args){
        // 最大长度
        int maxSize = 10;
        // 最大值
        int maxValue = 10;
        // 测试次数
        int time = 10;
        // 开始测试
        for (int i = 0; i < time; i++) {
            // 创建数组
            int[] array = generateArray(maxSize, maxValue);
            int[] copyArray = copyArray(array);
            // 快速排序
            quickSort(array);
            // 系统排序
            Arrays.sort(copyArray);
            // 判断两个排序是否一致，不一致说明我们的快速排序程序有问题
            if (!isEqual(array, copyArray)) {
                System.out.println("错误！！！");
                print(array);
                print(copyArray);
                break;
            }
        }
        // 输出一组正确的排序结果
        int[] array = generateArray(maxSize, maxValue);
        quickSort(array);
        print(array);

    }

    /**
     * 生成随机数组
     * @param maxSize   最大长度
     * @param maxValue  最大值
     * @return  返回随机数组
     */
    public static int[] generateArray(int maxSize, int maxValue) {
        int length = (int) (Math.random() * maxSize + 1);
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * maxValue + 1) - (int)(Math.random() * maxValue + 1);
        }
        return array;
    }

    /**
     * 赋值原来的数组
     * @param array 原数组
     * @return  新数组
     */
    public static int[] copyArray(int[] array) {
        int[] copyArray = new int[array.length];
        for (int i = 0;i < array.length; i++) {
            copyArray[i] = array[i];
        }
        return copyArray;
    }

    /**
     * 快速排序
     * @param array 需要进行排序的数组
     */
    public static void quickSort(int[] array) {
        int left = 0;
        int right = array.length - 1;
        group(array, left, right);
    }

    /**
     * 先排序，在划分组
     * @param array 数组
     * @param left  左边界
     * @param right 右边界
     */
    public static void group(int[] array, int left, int right) {
        // 直到只有一个数
        if (left >= right) {
            return;
        }
        // 排序，找到中间数
        int m = groupSort(array, left, right);
        // 左边找到中间数
        group(array, left, m);
        // 右边找到中间数
        group(array, m + 1, right);
    }

    /**
     * 排序
     * @param array 数组
     * @param left  左边界
     * @param right 右边界
     * @return  中间下标
     */
    public static int groupSort(int[] array, int left, int right) {
        // 小于中间数的下标值
        int minLeft = left - 1;
        // 循环数组元素
        int index = left;
        // 如果循环数组元素到了最左边边界，就可以退出了
        while (index < right) {
            // 如果当前数 小于等于 规定的数值（right这个下标的数），就将其挪到小于中间数的范围内，中间数的下标 + 1
            if (array[index] <= array[right]) {
                swap(array, index, minLeft + 1);
                minLeft++;
            }
            index++;
        }
        // 最后在将right这个数归位
        swap(array, minLeft + 1, right);
        // 返回中间值下标
        return minLeft;
    }

    /**
     * 交换
     * @param array 数组
     * @param i     数组下标 i
     * @param j     数组下标 j
     */
    public static void swap(int[] array , int i, int j) {
        int t = 0;
        t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    /**
     * 对比两个数组
     * @param array     快速排序结果
     * @param copyArray 系统排序结果
     * @return  是否一致
     */
    public static boolean isEqual(int[] array, int[] copyArray) {
        for (int i = 0; i < array.length;i++) {
            if (array[i] != copyArray[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印数组
     * @param array 数组
     */
    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
