import org.hqf.tutorials.spring.service.UserServiceImpl;
import org.hqf.tutorials.spring.service.interfaces.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ManualProxy_Dynamic implements InvocationHandler {

    private UserService userService;

    public ManualProxy_Dynamic(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {

        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(UserService.class.getClassLoader()
                , UserServiceImpl.class.getInterfaces(),
                this);

        return userServiceProxy;

    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("动态代理");
        System.out.println("打开事务");
        Object result = method.invoke(userService, args);
        System.out.println("关闭事务");

        return result;
    }
}
