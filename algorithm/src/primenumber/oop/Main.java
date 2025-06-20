package primenumber.oop;

public class Main {
    public static void main(String[] args) {
        Item counter = new Counter(2);
        Item sieve = new Sieve(counter);

        int num = 1003;
        int next = 0;

        while (true) {
            next = sieve.out();
            if (next > num) {
                break;
            }
            System.out.println("next = " + next);
        }

        // 时间复杂度: O(nlogn), 空间复杂度: O(n)
    }
}
