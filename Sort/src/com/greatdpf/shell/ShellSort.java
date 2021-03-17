package com.greatdpf.shell;

import java.util.Arrays;

/**
 * 希尔排序
 * 类似插入排序，但比插入排序效率高
 * 效率高的原因是因为跨度大，移动距离短
 *
 * @author : dpf
 * @version : V1.0
 * @date : 2021/3/16
 */
public class ShellSort {
    /**
     * 程序的入口
     */
    public static void main(String[] args){
        System.out.println("希尔排序");
        // 数组最大长度
        int maxSize = 100;
        // 数组中最大值
        int maxValue = 100;
        // 测试多少次数据
        int testTime = 5000;
        // 测试开始
        for (int i = 1; i <= testTime; i++) {
            // 生成随机数组
            int[] array = generateArray(maxSize, maxValue);
            // 复制数组，用于对比
            int[] copyArray = copyArray(array);
            // shell 排序
            shellSort(array);
            // 系统排序，百分百正确
            Arrays.sort(copyArray);
            // 如果两个数组不同，则退出循环，并打印错误信息
            if (!isEquals(array, copyArray)) {
                System.out.println("错误！！！");
                printResult(array);
                printResult(copyArray);
                break;
            }
        }
        // 重新生成数据进行排序，然后展示
        int[] arr = generateArray(maxSize, maxValue);
        System.out.println("原数组：");
        printResult(arr);
        shellSort(arr);
        System.out.println("排序后数组：");
        printResult(arr);
    }

    /**
     * 生成随机数组
     * @param maxSize 最大长度
     * @param maxValue 最大数值
     * @return 返回随机数组
     */
    public static int[] generateArray(int maxSize, int maxValue) {
        // randomSize 最终的范围：[0, 1) --> [1, maxSize + 1) --> [1, maxSize] 取整数
        // 获取随机数组大小
        int randomSize = (int) (Math.random() * (maxSize + 1));
        // 创建 randomSize 大小的数组
        int[] array = new int[randomSize];
        // 赋值
        for (int i = 0 ; i < array.length; i++) {
            // [0, +-maxValue)
            // 为每一个数组下标赋值，值为两个随机数相减，即：可正可负
            array[i] =  (int) (Math.random() * (maxValue + 1)) - ((int)Math.random() * (maxValue + 1));
        }
        return array;
    }

    /**
     * 复制数组，用于比对结果
     * @param array 随机数组
     * @return 复制后的数组，两个数组一样
     */
    public static int[] copyArray(int[] array) {
        // 新建数组，大小和原数组相同
        int[] copyArray = new int[array.length];
        // 给新数组赋值，值和原数组相同
        for (int i = 0; i < array.length;i++) {
            copyArray[i] = array[i];
        }
        return copyArray;
    }


    /**
     * 希尔排序
     * 将各数进行分组，然后组内进行排序，重复这个过程，直到分组为 1
     * @param array
     */
    public static void shellSort(int[] array) {
        // 分组，先将数组中的数，两两分组
        for (int group = array.length / 2;group > 0;group /= 2) {
            // 分组完成后，组内数据进行比较，按照插入排序进行比较
            // 循环各个小组
            for (int i = group; i < array.length; i++) {
                // 循环小组内各个数
                for (int j = i; j >= group; j = j - group) {
                    if (array[j - group] > array[j]) {
                        swap(array, j - group, j);
                    }
                }
            }
        }
    }

    /**
     * 两数交换
     * @param array 数组
     * @param a 下标 a
     * @param b 下标 b
     */
    public static void swap(int[] array, int a, int b) {
        int t = array[a];
        array[a] = array[b];
        array[b] = t;
    }

    /**
     * 比较两个数组是否大小相同，元素值，位置是否相同
     * @param array shell 排序后的结果 array
     * @param copyArray 系统 排序后的结果 copyArray
     * @return 相同返回 true ，不同返回 false
     */
    public static boolean isEquals(int[] array, int[] copyArray) {
        for (int i = 0; i < copyArray.length;i++) {
            if (array[i] != copyArray[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印输出数组值
     * @param array 需打印的数组
     */
    public static void printResult(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }



}
