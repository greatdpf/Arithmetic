package com.greatdpf.localMin;

/**
 * 局部最小
 *
 * @author : dpf
 * @version : V1.0
 * @date : 2020/11/19
 */
public class LocalMin {
    /**
     * 程序的入口
     */
    public static void main(String[] args){
        // 测试 5000 次
        int time = 5000;
        // 最大长度
        int maxSize = 10;
        // 最大值
        int maxValue = 10;
        for (int i = 0;i < time;i++) {
            // 生成随机数组
            int[] arr = generateRandomArray(maxSize, maxValue);
            // 查找局部最小
            int min = localMin(arr);
            // 确认是否为局部最小
            if (min == -1 || min == 0 || min == arr.length - 1) {
                continue;
            }
            if (arr[min] > arr[min - 1] || arr[min] > arr[min+1]) {
                System.out.println(min);
                print(arr);
                break;
            }
        }

        int[] arr = generateRandomArray(maxSize, maxValue);
        System.out.println("随机数组");
        print(arr);
        int min = localMin(arr);
        System.out.println("局部最小值：" + arr[min]);
        System.out.println("局部最小位置：" + min);


    }

    /**
     * 生成随机数组
     * @param maxSize 数组最大长度
     * @param maxValue 数组最大值
     * @return 返回随机数组
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int size = (int) (Math.random() * (maxSize + 1));
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * (maxValue + 1));
        }
        return arr;
    }

    /**
     * 查找局部最小值
     * @param arr 数组
     * @return 返回这个局部最小值下标
     */
    public static int localMin(int[] arr) {
        // 如果数组为空，则直接返回 -1 表示无最小
        if (arr == null || arr.length == 0) {
            return -1;
        }
        // 如果数组只有一个值，或者数组的第一个值小于第二个值，则第一个就是局部最小值
        if (arr.length == 1  || arr[0] < arr[1]) {
            return 0;
        }
        // 如果数组中最后一个值小于倒数第二个值，则最后一个值就是局部最小值
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }

        // 第二个数
        int left = 1;
        // 倒数第二个数
        int right = arr.length - 2;
        // 使用二分查找局部最小
        int mid = 0;
        while (left < right) {
            // mid = (left + right) / 2
            mid = left + ((right - left) >> 1);
            if (arr[mid] > arr[mid - 1]){
                right = mid - 1;
            } else if (arr[mid] >= arr[mid + 1]){
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return left;
    }

    /**
     * 打印
     * @param arr 打印数组
     */
    public static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


}
