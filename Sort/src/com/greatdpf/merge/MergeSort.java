package com.greatdpf.merge;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author : dpf
 * @version : V1.0
 * @date : 2021/3/18
 */
public class MergeSort {

    /**
     * 程序的入口
     */
    public static void main(String[] args){
        // 数组最大值
        int maxValue = 100;
        // 数组最大长度
        int maxSize = 100;
        // 测试次数
        int time = 5000;
        for (int i = 0; i < time; i++) {
            // 生成随机数组
            int[] array = generateArray(maxSize, maxValue);
            // 赋值数组，用于对比
            int[] copyArray = copyArray(array);
            // 归并排序
            mergeSort(array);
            // 系统排序
            Arrays.sort(copyArray);
            // 判断两个排序后的数组是否一样，不一样说明 归并有误，查看错误结果并退出循环
            if (!isEquals(array, copyArray)) {
                System.out.println("错误！！！");
                printArray(array);
                break;
            }
        }

        // 输出一组正确结果
        int[] arr = generateArray(maxSize, maxValue);
        System.out.println("归并排序");
        System.out.println("数组：");
        printArray(arr);
        mergeSort(arr);
        System.out.println("结果为：");
        printArray(arr);
    }

    /**
     * 生成随机数组
     * @param maxSize 最大长度
     * @param maxValue 最大值
     * @return 返回生成好的数组
     */
    public static int[] generateArray(int maxSize, int maxValue) {
        // 数组随机长度大小 [1, maxSize]
        int randomSize = (int) ((Math.random() * maxSize) + 1);
        // 创建数组
        int[] array = new int[randomSize];
        // 为数组赋值
        for (int i = 0; i < randomSize; i++) {
            // [-maxValue, +maxValue]
            array[i] = ((int)((Math.random()*maxValue) + 1)) - ((int)((Math.random()*maxValue) + 1));
        }
        return array;
    }

    /**
     * 赋值数组
     * @param array 原数组
     * @return 新数组
     */
    public static int[] copyArray(int[] array) {
        int[] copyArray = new int[array.length];
        for (int i = 0;i < array.length; i++) {
            copyArray[i] = array[i];
        }
        return copyArray;
    }

    /**
     * 开始进行归并排序
     * @param array 数组
     */
    public static void mergeSort(int[] array) {
        // left，right 用于标记数的界限
        int left = 0;
        int right = array.length - 1;
        // 进行递归，将数组中的数分割然后进行排序
        mergeIteration(array, left, right);
    }

    /**
     * 递归排序
     * @param array 数组
     * @param left  左边边界
     * @param right 右边边界
     */
    public static void mergeIteration(int[] array, int left, int right) {
        // 判断数组是否拆分成最小模块
        if (left >= right) {
            return;
        }
        // 如果没有拆分成最小模块，则继续拆分
        // 从中间进行拆分
        int middle = (left + right) >> 1;
        // 继续递归拆分
        mergeIteration(array, left, middle);
        mergeIteration(array, middle + 1, right);
        // 拆分完之后，需要保证同一边的顺序是已排序的，所以将其进行排序
        mergeCore(array, left, right, middle);
    }

    /**
     * 分组后进行排序
     * @param array  数组
     * @param left   左边边界
     * @param right  右边边界
     * @param middle 中间数
     */
    public static void mergeCore(int[] array, int left, int right, int middle) {
        // 新数组的必须包含 left 和 right 之间的数
        int newArrayLength = right - left + 1;
        // 定义新数组，用于将排序好的元素放入
        int[] newArray = new int[newArrayLength];
        // 用于循环计数
        int i = 0;
        // 定义两个标记，分别标记两组中的数据。
        // ml 标记以中间分割的左边第一个数
        // mr 标记以中间分割的右边第一个数
        // 如：1 5 2 7 以中间分割，ml --> 1  mr --> 2
        int ml = left;
        int mr = middle + 1;
        // ml 不能超过中间值，原因是因为以中间划分的两组
        // mr 不能超过最右边的值，否则就不是同组的数据
        while ((ml <= middle) && (mr <= right)) {
            // 将这两组数据进行排序
            // i++ ml++ mr++ 都是神操作，记住，很关键！！！
            // i++ 表示取完 i 值后 加 1 ，保证了 newArray 一直可以向后赋值
            // ml++ 表示同上，但保证了，取值后，才移动下标，否则不动
            // mr++ 同上
            // 如：1 5 2 7 : 1 < 2 取 1 ml --> 5 而 ml --> 2
            newArray[i++] = array[ml] < array[mr] ? array[ml++] : array[mr++];
        }
        // 上述循环有个问题，就是如果当某一方向的数先取完，会导致另外一方向的数，没有取完，循环就结束了，此时 newArray 数据未满
        // 而原本一方的数本身已经排序了，所以如果有一方的数没有取完，另一方取完
        // 则表明了，没取完的一方的数都比已经放入 newArray 中的数 大 !
        // 因为取完的一方的最后一个数，肯定是已经和没取完数的一方中的某个数进行比较，小于才会取，所以取完了
        // 取完的一方 < 没有取完的一方中的某个数，而没取完的一方中的数是有序的，所以，其 < 后面所有数
        // 综上所述：没取完的依次放入即可
        // ml mr 都需要进行判断，是否取完
        while (ml <= middle) {
            newArray[i++] = array[ml++];
        }
        while (mr <= right) {
            newArray[i++] = array[mr++];
        }

        // 经过上述操作后，所以数已经排序在 newArray 中，在将 newArray 中的数重新赋值给 array
        // 注意：这里的下标不是 0 开始，而是 left 开始的，所以下标从 left 开始计算
        for (int k = 0;k < newArrayLength;k++) {
            array[left++] = newArray[k];
        }
    }

    /**
     * 对比数组
     * @param array     原数组
     * @param copyArray 新数组
     * @return 是否相同
     */
    public static boolean isEquals(int[] array, int[] copyArray) {
        for (int i = 0; i < array.length; i++) {
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
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
