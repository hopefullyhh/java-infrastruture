package proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

public class CglibProxyFactory {
    public static Object getProxyObject(Object obj, MethodInterceptor methodInterceptor) {
        Enhancer enhancer = new Enhancer();
        Class<?> aClass = obj.getClass();
        enhancer.setClassLoader(aClass.getClassLoader());
        enhancer.setSuperclass(aClass);
        enhancer.setCallback(methodInterceptor);
        return enhancer.create();
    }
}
