package com.greatdpf.merge;

/**
 * @author : dpf
 * @version : V1.0
 * @date : 2021/3/18
 */
public class MergeCoreCode {
    /**
     * 程序的入口
     */
    public static void main(String[] args){
        int[] array = {5,10, 7, 1, 1, 5, 1, 9, 6, 3, 1, 4, 3, 3, 7};

        merge(array, 0, array.length-1);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void merge(int[] array, int left, int right) {
        if(left >= right) {
            return;
        }
        int middle = (left + right) >> 1;
        merge(array, left, middle);
        merge(array, middle + 1, right);
        int[] newArray = new int[right - left + 1];
        // 用于newArray 递增，赋值
        int i = 0;
        int ll = left;
        int rr = right;
        int l = middle;
        int r = middle + 1;
        while((left <= l) && (r <= right)) {
            newArray[i++] = array[left] < array[r] ? array[left++] : array[r++];
            /*if (array[left] < array[r]) {
                newArray[i] = array[left];
                left++;
            } else {
                newArray[i] = array[r];
                r++;
            }
            i++;*/
        }

        // 录入剩下的数
        while (left <= l) {
            newArray[i++] = array[left++];
        }

        while (r <= right) {
            newArray[i++] = array[r++];
        }

        // 把数重新放回原数组中
        for (int k = 0;k < newArray.length;k++,ll++) {
            array[ll] = newArray[k];
        }

    }

}
