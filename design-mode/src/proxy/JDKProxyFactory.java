package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class JDKProxyFactory {
    public static Object getProxyObject(Object obj, InvocationHandler invocationHandler) {
        Class<?> aClass = obj.getClass();
        return Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), invocationHandler);
    }
}
