package testproxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class PorxyTest {
    @Test
    public void test1(){
        //运行时在内存中为Target动态的创建一个虚拟的代理对象
        //objProxy是代理对象，根据参数来确定到底是谁的代理对象
        TargetInterface objProxy = (TargetInterface) Proxy.newProxyInstance(
                Target.class.getClassLoader(),//与目标对象有相同的类加载器
                new Class[]{TargetInterface.class} ,//
                new InvocationHandler(){
                    //invoke代表的是执行代理对象的方法
                    //method代表的是目标对象的方法字节码对象
                    //args：代表目标对象的相应的方法参数
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //执行目标方法前的逻辑
                        Object invoke = method.invoke(new Target(), args);
                        return invoke;
                        //执行目标方法后的逻辑
                    }
                });
        objProxy.menthod1();
        String s = objProxy.method2();
        System.out.println(s);
        Map<String,Object> map=new HashMap<>();
    }


}
