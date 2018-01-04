import org.hqf.tutorials.spring.service.UserServiceImpl;
import org.hqf.tutorials.spring.service.interfaces.UserService;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import javax.jws.soap.SOAPBinding;
import java.lang.reflect.Method;

public class ManualProxy_Cglib implements MethodInterceptor {

    public UserService getUserServiceProxy() {

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(UserServiceImpl.class);

        enhancer.setCallback(this);

        UserService userService = (UserService) enhancer.create();

        return userService;
    }


    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("cglib 增强");
        System.out.println("打开事务");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("结束事务");
        return result;
    }
}
