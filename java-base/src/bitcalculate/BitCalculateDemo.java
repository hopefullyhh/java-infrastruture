package bitcalculate;

/**
 * |：按位或，有1即为1
 * &：按位与，两个为1才为1
 * ~：非运算，0为1，1为0
 * ^：异或运算，相同为0，不同为1
 */
public class BitCalculateDemo {
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;
    public static void main(String[] args) {
        System.out.println("COUNT_BITS = " + COUNT_BITS);
        System.out.println("RUNNING = " + RUNNING);
        System.out.println("SHUTDOWN = " + SHUTDOWN);
        System.out.println("STOP = " + STOP);
        System.out.println("TIDYING = " + TIDYING);
        System.out.println("TERMINATED = " + TERMINATED);
        System.out.println(-1 << 29 | 0);
        System.out.println((1 << 29) & ~((1 << 29) - 1));
        System.out.println(((-1 << 29) + 2 ) & ((1 << 29) - 1));
    }
}
