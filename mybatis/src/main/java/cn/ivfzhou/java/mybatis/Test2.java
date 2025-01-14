package cn.ivfzhou.java.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.ivfzhou.java.mybatis.bean.Blog;
import cn.ivfzhou.java.mybatis.bean.Type;
import cn.ivfzhou.java.mybatis.mapper.BlogMapper;

public class Test2 {

    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // SqlSessionFactory sqlSessionFactory2 = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource), "myenv");
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            switch (2) {
                case 1:
                    Blog blog = session.selectOne("cn.ivfzhou.java.mybatis.mapper.BlogMapper.selectBlog1", 4);
                    System.out.println(JSON.toJSON(blog));
                    break;
                case 2:
                    List<Blog> blogs = session.selectList("cn.ivfzhou.java.mybatis.mapper.BlogMapper.selectBlog2");
                    System.out.println(JSON.toJSON(blogs));
                    break;
                case 3:
                    blog = session.selectOne("cn.ivfzhou.java.mybatis.mapper.BlogMapper.selectBlog3", 1);
                    System.out.println(JSON.toJSON(blog));
                    break;
                case 4:
                    blog = new Blog(0);
                    blog.setGrade(88.8888);
                    blog.setType(Type.SOCIAL);
                    int res = session.insert("cn.ivfzhou.java.mybatis.mapper.BlogMapper.insertBlog", blog);
                    System.out.println("res=" + res + "，blog.id=" + blog.getId());
                    break;
                case 5:
                    BlogMapper mapper = session.getMapper(BlogMapper.class);
                    blogs = mapper.selectBlog2();
                    System.out.println(JSON.toJSON(blogs));
                    break;
                case 6:
                    break;
            }
        }
    }

}
