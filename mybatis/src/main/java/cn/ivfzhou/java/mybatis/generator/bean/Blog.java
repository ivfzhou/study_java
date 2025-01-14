package cn.ivfzhou.java.mybatis.generator.bean;

import java.io.Serializable;

public class Blog implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.title
     *
     * @mbg.generated
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.grade
     *
     * @mbg.generated
     */
    private Double grade;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.type
     *
     * @mbg.generated
     */
    private Integer type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.author_id
     *
     * @mbg.generated
     */
    private Integer authorId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.coauthor_id
     *
     * @mbg.generated
     */
    private Integer coauthorId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.has_coauthor
     *
     * @mbg.generated
     */
    private Boolean hasCoauthor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_blog
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.id
     *
     * @return the value of t_blog.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.id
     *
     * @param id the value for t_blog.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.title
     *
     * @return the value of t_blog.title
     *
     * @mbg.generated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.title
     *
     * @param title the value for t_blog.title
     *
     * @mbg.generated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.grade
     *
     * @return the value of t_blog.grade
     *
     * @mbg.generated
     */
    public Double getGrade() {
        return grade;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.grade
     *
     * @param grade the value for t_blog.grade
     *
     * @mbg.generated
     */
    public void setGrade(Double grade) {
        this.grade = grade;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.type
     *
     * @return the value of t_blog.type
     *
     * @mbg.generated
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.type
     *
     * @param type the value for t_blog.type
     *
     * @mbg.generated
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.author_id
     *
     * @return the value of t_blog.author_id
     *
     * @mbg.generated
     */
    public Integer getAuthorId() {
        return authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.author_id
     *
     * @param authorId the value for t_blog.author_id
     *
     * @mbg.generated
     */
    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.coauthor_id
     *
     * @return the value of t_blog.coauthor_id
     *
     * @mbg.generated
     */
    public Integer getCoauthorId() {
        return coauthorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.coauthor_id
     *
     * @param coauthorId the value for t_blog.coauthor_id
     *
     * @mbg.generated
     */
    public void setCoauthorId(Integer coauthorId) {
        this.coauthorId = coauthorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.has_coauthor
     *
     * @return the value of t_blog.has_coauthor
     *
     * @mbg.generated
     */
    public Boolean getHasCoauthor() {
        return hasCoauthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.has_coauthor
     *
     * @param hasCoauthor the value for t_blog.has_coauthor
     *
     * @mbg.generated
     */
    public void setHasCoauthor(Boolean hasCoauthor) {
        this.hasCoauthor = hasCoauthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_blog
     *
     * @mbg.generated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Blog other = (Blog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getGrade() == null ? other.getGrade() == null : this.getGrade().equals(other.getGrade()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getAuthorId() == null ? other.getAuthorId() == null : this.getAuthorId().equals(other.getAuthorId()))
            && (this.getCoauthorId() == null ? other.getCoauthorId() == null : this.getCoauthorId().equals(other.getCoauthorId()))
            && (this.getHasCoauthor() == null ? other.getHasCoauthor() == null : this.getHasCoauthor().equals(other.getHasCoauthor()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_blog
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getGrade() == null) ? 0 : getGrade().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getAuthorId() == null) ? 0 : getAuthorId().hashCode());
        result = prime * result + ((getCoauthorId() == null) ? 0 : getCoauthorId().hashCode());
        result = prime * result + ((getHasCoauthor() == null) ? 0 : getHasCoauthor().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_blog
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", grade=").append(grade);
        sb.append(", type=").append(type);
        sb.append(", authorId=").append(authorId);
        sb.append(", coauthorId=").append(coauthorId);
        sb.append(", hasCoauthor=").append(hasCoauthor);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}