import org.hqf.tutorials.spring.domain.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorld {

    @Test
    public void getUserBySpring(){

        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) context.getBean("user");

        System.out.println("user = " + user);
    }

}
