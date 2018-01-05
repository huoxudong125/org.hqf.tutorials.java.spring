package org.hqf.tutorials.spring.jdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import org.hqf.tutorials.spring.jdbcTemplate.bean.User;

//使用JDBC模板实现增删改查
public class UserDaoImpl implements UserDao {


    public UserDaoImpl() {
    }

    private JdbcTemplate jt;

    public JdbcTemplate getJt() {
        return jt;
    }


    public void setJt(JdbcTemplate jt) {
        this.jt = jt;
    }


    public void save(User u) {
        String sql = "insert into t_user values(null,?) ";
       jt.update(sql, u.getName());
    }

    public void delete(Integer id) {
        String sql = "delete from t_user where id = ? ";
       jt.update(sql, id);
    }

    public void update(User u) {
        String sql = "update  t_user set name = ? where id=? ";
       jt.update(sql, u.getName(), u.getId());
    }

    public User getById(Integer id) {
        String sql = "select * from t_user where id = ? ";
        return jt.queryForObject(sql, new RowMapper<User>() {

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
        Integer count =jt.queryForObject(sql, Integer.class);
        return count;
    }


    public List<User> getAll() {
        String sql = "select * from t_user  ";
        return jt.query(sql, new RowMapper<User>() {

            public User mapRow(ResultSet rs, int arg1) throws SQLException {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                return u;
            }
        });
    }


}
