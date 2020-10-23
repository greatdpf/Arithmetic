package com.greatdpf;

import org.junit.Test;

/**
 * 异或运算：无进位相加
 * 如：将下面
 * 100100
 * 011100
 * --------- 将两个数直接进行相加，有进位的不进位即可
 * 111000
 * 重要性质：
 * （1）N ^ N = 0;
 * （2）N ^ 0 = N;
 * （3）满足交换律和结合率
 *
 *问题：
 * 1.如何不用额外变量交换两个数？
 * 2.如何取得一个数的最右边的1？
 * 3.如何记录一个数中出现1的次数？
 * 4.一个数组中只有一个数出现了奇数次，其他所有数都出现了偶数次，如何找到这个数？
 * 5.一个数组中只有两个数出现了奇数次，其他所有数都出现了偶数次，如何找到这两个数？
 *
 *
 * @author : dpf
 * @version : V1.0
 * @date : 2020/10/23
 */
public class ExclusiveOr {
    /**
     * 不用额外变量交换两个数；
     * 这种方式有一个问题，就是如果操作数组，不能操作数组同一下标的数
     * 如：
     * a[0] = a[0] ^ a[0]
     * a[0] = a[0] ^ a[0]
     * a[0] = a[0] ^ a[0]
     * 最终结果肯定是 a[0] = 0;
     */
    @Test
    public void swap() {
        int a = 10;
        int b = 20;
        // 没交换之前的 a 和 b
        System.out.println(a + " : " + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        // 交换后的 a 和 b
        System.out.println(a + " : " + b);
    }

    /**
     * 获取一个数的最右侧 1
     * 如：        100100，
     * 则最右侧就是    100，这个数就是 4；
     */
    @Test
    public void rightOne() {
        int a = 36;
        int b = a & (~a + 1);
        // 输出 a 和 b 的二进制数
        // a ：100100
        // b ：000100
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
    }

    /**
     * 记录一个数中出现 1 的次数
     * （1）找出最右侧 1 并记录
     * （2）将最右侧 1 改为 0
     * （3）再找出右侧 1 并记录，直到 a = 000000;
     */
    @Test
    public void countOne() {
        int a = 37;
        System.out.println(Integer.toBinaryString(a));
        int count = 0;
        int rightOne = 0;
        while (a != 0) {
            rightOne = a & (~a + 1);
            count++;
            a = rightOne ^ a;
        }
        // 这个肯定是 a 最左侧位置上的 1
        System.out.println(Integer.toBinaryString(rightOne));
        System.out.println(count);
    }

    /**
     * 打印只出现奇数次的这个数
     * 根据异或运算的性质可知：
     * N ^ N = 0
     * 异或运算满足交换律和结合律
     * 所以出现偶数次的全部异或在一起，肯定为 0 ，最终只会剩下出现了奇数次的那个数
     */
    @Test
    public void printNum() {
        int[] arr = {1,2,1,2,4,4,4,3,3};
        int num = 0;
        for (int a : arr) {
            num ^= a;
        }
        System.out.println(num);
    }

    /**
     * 找到只出现了奇数次的两个数 num1，num2
     * 1.将数组中所有数进行异或
     * 最终得到的结果肯定是 result = num1 ^ num2
     * 因为其他数都是偶数个，抑或结果为 0 ;
     * 2.找到 result 最右侧 1 rightOne
     * 那么可以直到，在 rightOne 这个位置上，num1，num2要么一个是 1，一个是 0
     * 因为如果相同位置上的数相同，那么异或的结果肯定不是 1 ；
     * 3.通过 rightOne 的不同，将 num1 和 num2 分开
     * rightOne & arr[i] == 0；这就说明，他们在rightOne这个位置上的数都是相同的，即为 1
     * 0100    0011
     * 0001    0001
     * 0000    0001
     * 4.然后将区分开的一组数肯定是 num1 在一组，num2 在另外一组，
     * 并且他们各组都只有他们一个出现了奇数次，
     * 所以在按照之前找奇数次的方式，找到这个数。
     * 5.最后再将 num1 和 result 异或，就可以得到 num2
     * 这个是采用了 swap() 方法，可见 swap() 的注释
     */
    @Test
    public void printTwoNum() {
        int[] arr = {1,2,1,2,4,4,4,3,3,3};
        int result = 0;
        // 得到 num1 ^ num2
        for (int a : arr) {
            result ^= a;
        }
        // 得到 result 的最右侧 1
        int rightOne = result & (~result + 1);
        int num1 = result;

        for (int a : arr) {
            // 将 num1 和 num2 按照 最右侧 1 位置不同 区分
            if ((rightOne & a) == 0) {
                num1 ^= a;
            }
        }
        // 相当于 num1 ^ num1 ^ num2，结果肯定是 num2
        int num2 = num1 ^ result;
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
        System.out.println("出现了奇数次的数 \n num1 ：" + num1 + "\n num2 ：" +num2);


    }



}
