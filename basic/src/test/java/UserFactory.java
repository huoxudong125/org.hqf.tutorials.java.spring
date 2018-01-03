import org.hqf.tutorials.spring.domain.User;

public class UserFactory {

    public static User createUserStatic(){
        return new User();
    }

    public  User createUser(){
        return new User();
    }
}
