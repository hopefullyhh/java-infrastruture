package proxy;

public class Person implements IPerson {
    @Override
    public void speak() {
        System.out.println("我叫张三");
    }

    public void eat() {
        System.out.println("今晚吃红烧豆腐");
    }

    protected void run() {
        System.out.println("快跑~");
    }
}
