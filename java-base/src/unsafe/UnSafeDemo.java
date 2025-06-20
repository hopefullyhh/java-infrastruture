package unsafe;

import sun.misc.Unsafe;

public class UnSafeDemo {
    public static void main(String[] args) {
        Unsafe unsafe = sun.misc.Unsafe.getUnsafe();
        System.out.println("unsafe = " + unsafe);
    }
}
