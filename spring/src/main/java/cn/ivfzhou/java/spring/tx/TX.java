package cn.ivfzhou.java.spring.tx;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.ivfzhou.java.spring.bean.User;

@Component("tx")
public class TX {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void query() {
        List<User> users = jdbcTemplate.query("SELECT * FROM `t_user`", (rs, rowNum) -> {
            User user = new User();
            user.setAge(rs.getInt("age"));
            user.setName(rs.getString("name"));
            return user;
        });

        System.out.println(users);
    }

    @Transactional(transactionManager = "transactionManager")
    public void insert() {
        int res = jdbcTemplate.update("INSERT INTO `t_user` (`age`, `name`) VALUES (?, ?);", 20, "ww");
        System.out.println(res);
        throw new RuntimeException("回滚");
    }

}
