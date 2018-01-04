import org.hqf.tutorials.spring.service.UserServiceImpl;
import org.hqf.tutorials.spring.service.interfaces.UserService;
import org.junit.Assert;
import org.junit.Test;

public class ManualProxyDemoTest {

    @Test
    public void TestDynamic(){
        UserService userService=new UserServiceImpl();

        ManualProxy_Dynamic manualProxyDynamic =new ManualProxy_Dynamic(userService);

        UserService userServiceProxy= manualProxyDynamic.getUserService();

        userServiceProxy.save(100);

        Assert.assertFalse(userServiceProxy instanceof  UserServiceImpl);
    }

    @Test
    public void TestCglib(){
        UserService userService=new UserServiceImpl();

        ManualProxy_Cglib manualProxyDynamic =new ManualProxy_Cglib();

        UserService userServiceProxy= manualProxyDynamic.getUserServiceProxy();

        userServiceProxy.save(100);

        Assert.assertTrue(userServiceProxy instanceof  UserServiceImpl);
    }
}
