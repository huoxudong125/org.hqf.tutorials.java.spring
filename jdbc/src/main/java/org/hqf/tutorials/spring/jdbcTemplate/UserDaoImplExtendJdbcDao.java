package org.hqf.tutorials.spring.jdbcTemplate;

import org.hqf.tutorials.spring.jdbcTemplate.bean.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//使用JDBC模板实现增删改查
public class UserDaoImplExtendJdbcDao extends JdbcDaoSupport implements UserDao {

    public void save(User u) {
        String sql = "insert into t_user values(null,?) ";
       super.getJdbcTemplate().update(sql, u.getName());
    }

    public void delete(Integer id) {
        String sql = "delete from t_user where id = ? ";
        super.getJdbcTemplate().update(sql, id);
    }

    public void update(User u) {
        String sql = "update  t_user set name = ? where id=? ";
        super.getJdbcTemplate().update(sql, u.getName(), u.getId());
    }

    public User getById(Integer id) {
        String sql = "select * from t_user where id = ? ";
        return  super.getJdbcTemplate().queryForObject(sql, new RowMapper<User>() {

            public User mapRow(ResultSet rs, int arg1) throws SQLException {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                return u;
            }
        }, id);

    }

    public int getTotalCount() {
        String sql = "select count(*) from t_user  ";
        Integer count = super.getJdbcTemplate().queryForObject(sql, Integer.class);
        return count;
    }


    public List<User> getAll() {
        String sql = "select * from t_user  ";
        return  super.getJdbcTemplate().query(sql, new RowMapper<User>() {

            public User mapRow(ResultSet rs, int arg1) throws SQLException {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                return u;
            }
        });
    }


}
