package primenumber;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PrimeNumber {
    public boolean isPositivePrimeNumber(int num) {
        if (num <= 1) {
            return false;
        }

        int max = (int) Math.sqrt(num);
        for (int i = 2; i <= max; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * 筛选法计算[2,n]之间的质数
     *
     * @param num
     * @return int[]
     */
    public int[] getPrimeNumbers(int num) {
        if (num <= 1) {
            return new int[0];
        }

        int[] nums = new int[num - 1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 2;
        }

        int max = (int) Math.sqrt(num);
        int step = 2;
        while (step <= max) {
            for (int i = 2 * step - 2; i < nums.length; i += step) {
                nums[i] = 0;
            }
            step++;
        }

        return IntStream.of(nums).filter(item -> item != 0).toArray();
    }

    public static void main(String[] args) {
        //100000 -> 56 ,51, 51
        //1000000 -> 78, 66, 72
        int num = 1003;
        PrimeNumber primeNumber = new PrimeNumber();
        boolean positivePrimeNumber = primeNumber.isPositivePrimeNumber(num);
        System.out.println("positivePrimeNumber = " + positivePrimeNumber);

        long start = System.currentTimeMillis();
        int[] primeNumbers = primeNumber.getPrimeNumbers(num);
        long end = System.currentTimeMillis();
        System.out.println("primeNumbers = " + Arrays.toString(primeNumbers));
        System.out.println("end - start, " + (end - start) + "ms");
    }
}
