package cn.ivfzhou.java.mybatis;

import java.util.HashMap;
import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;

import cn.ivfzhou.java.mybatis.bean.Blog;

public class Test1 {

    /*
     * 不使用 xml 配置获取 SQLSessionFactory。
     * */
    public static void main(String[] args) throws Exception {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("username", "root");
        hashMap.put("password", "123456");
        hashMap.put("url", "jdbc:mysql://127.0.0.1:3306/db_mybatis");
        DataSource dataSource = DruidDataSourceFactory.createDataSource(hashMap);
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(BlogMapper.class);
        configuration.setDefaultEnumTypeHandler(EnumOrdinalTypeHandler.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            Blog blog = mapper.selectByID(1);
            System.out.println(blog);
        }
    }

    public interface BlogMapper {
        @Select("SELECT * FROM `t_blog` WHERE `id`=#{id}")
        Blog selectByID(int id);
    }

}
