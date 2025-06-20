package primenumber.oop;

/**
 * 筛子
 * 1.构造filter的链式结构
 * 2.作为filter的出入口
 */
public class Sieve extends Item {
    public Sieve(Item counter) {
        super(counter);
    }

    @Override
    public int out() {
        int factor = item.out();
        item = new Filter(item, factor);
        return factor;
    }
}
