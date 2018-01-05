import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateDemo {
    @Test
    public void fun1() throws Exception{

        //0 准备连接池
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://192.168.126.129:3306/hibernate_basic");
        dataSource.setUser("root");
        dataSource.setPassword("121");
        //1 创建JDBC模板对象
        JdbcTemplate jt = new JdbcTemplate();
        jt.setDataSource(dataSource);
        //2 书写sql,并执行
        String sql = "insert into t_user values(null,'rose') ";
        jt.update(sql);

    }
}
