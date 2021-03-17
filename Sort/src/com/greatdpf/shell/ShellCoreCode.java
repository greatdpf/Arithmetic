package com.greatdpf.shell;

/**
 * @author : dpf
 * @version : V1.0
 * @date : 2021/3/17
 */
public class ShellCoreCode {
    /**
     * 程序的入口
     */
    public static void main(String[] args){
        int[] array = {5,10, 7, 1, 1, 5, 1, 9, 6, 3, 1, 4, 3, 3, 7};
        int group = array.length / 2;
        for (int i = group; i < array.length; i++) {
            for (int j = i; j >= group;j = j - group) {
                if (array[j - group] > array[j]) {
                    swap(array, j - group, j);
                }
            }

            if (i + 1 >= array.length) {
                group = group / 2;
                i = group - 1;
                if (group == 0) {
                    break;
                }
            }
        }
        printResult(array);
    }

    public static void printResult(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void swap(int[] array, int a, int b) {
        int t = array[a];
        array[a] = array[b];
        array[b] = t;
    }

}
