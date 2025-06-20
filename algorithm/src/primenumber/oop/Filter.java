package primenumber.oop;

/**
 * 过滤器
 * 1.保存筛选因子
 * 2.对(上一个质数, 下一个质数)区间内的数进判断
 */
public class Filter extends Item {
    private int factor;

    Filter(Item preFilter, int factor) {
        super(preFilter);
        this.factor = factor;
    }

    @Override
    public int out() {
        while (true) {
            int out = item.out();
            if (out % factor != 0) {
                return out;
            }
        }
    }
}
