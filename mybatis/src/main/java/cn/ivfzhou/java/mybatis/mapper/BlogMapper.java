package cn.ivfzhou.java.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;

import cn.ivfzhou.java.mybatis.bean.Author;
import cn.ivfzhou.java.mybatis.bean.Blog;
import cn.ivfzhou.java.mybatis.bean.Comment;
import cn.ivfzhou.java.mybatis.languagedriver.MyLanguageDriver;

// @CacheNamespaceRef(OtherMapper.class)
public interface BlogMapper {

    /*// @Select("select * from t_blog")
    @SelectProvider(value = BlogSQLBuilder.class, method = "selectBlog2")
    // @SelectProvider(BlogSQLBuilderMethodResolver.class)
    @ConstructorArgs(@Arg(id = true, column = "id", name = "id"))
    @Results(id = "blogMap1", value = {
            @Result(property = "title", column = "title"),
            @Result(property = "type", column = "type", typeHandler = EnumOrdinalTypeHandler.class),
            @Result(property = "author", column = "author_id", one = @One(select = "cn.ivfzhou.mybatis.mapper.BlogMapper.selectAuthor")),
            @Result(property = "coauthor", column = "coauthor_id", one = @One(select = "cn.ivfzhou.mybatis.mapper.BlogMapper.selectAuthor")),
            @Result(property = "comments", column = "id", many = @Many(select = "cn.ivfzhou.mybatis.mapper.BlogMapper.selectComments", fetchType = FetchType.LAZY))
    })*/
    List<Blog> selectBlog2();

    Blog selectBlog3();

    //@Select("select * from t_author where id = #{id}")
    Author selectAuthor(int id);

    //@Select("select * from t_comment where blog_id = #{blog_id}")
    List<Comment> selectComments(int blogID);

    @MapKey("id")
    Map<Integer, Blog> selectBlogs();

    @Update({"<script>",
            "update Author",
            "  <set>",
            "    <if test='username != null'>username=#{username},</if>",
            "    <if test='password != null'>password=#{password},</if>",
            "    <if test='email != null'>email=#{email},</if>",
            "    <if test='bio != null'>bio=#{bio}</if>",
            "  </set>",
            "where id=#{id}",
            "</script>"})
    @Lang(MyLanguageDriver.class)
    void example();

}
