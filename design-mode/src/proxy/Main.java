package proxy;

public class Main {
    public static void main(String[] args) {
        final Person person = new Person();
        IPerson proxyObject = (IPerson) JDKProxyFactory.getProxyObject(person, (proxy, method, params) -> {
            System.out.println("你叫什么");
            Object result = method.invoke(person, params);
            System.out.println("哦，我叫李四");
            return result;
        });
        proxyObject.speak();

        Person proxyObject1 = (Person) CglibProxyFactory.getProxyObject(person, (obj, method, params, methodProxy) -> {
            System.out.println("今晚吃什么");
            Object result = methodProxy.invokeSuper(obj, params);
            System.out.println("哦，我今晚吃鱼");
            return result;
        });
        proxyObject1.eat();

        proxyObject1.run();
    }
}
