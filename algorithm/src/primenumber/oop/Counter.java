package primenumber.oop;

/**
 * 计数器
 * 用于模拟区间[2,n]的数据
 */
public class Counter extends Item {
    private int value;

    public Counter(int value) { 
        super();
        this.value = value;
    }

    @Override
    public int out() {
        return value++;
    }
}
