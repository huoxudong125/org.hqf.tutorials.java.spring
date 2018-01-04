import org.hqf.tutorials.spring.service.interfaces.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext_springProxy.xml")
public class SpringProxyDemo {
    @Resource(name="userService")
    private UserService us;

    @Test
    public void fun1(){
        us.save(100);
    }

}

