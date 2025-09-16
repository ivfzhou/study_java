<%@ page contentType="text/html; UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date" %>
<%@ include file="include" %> <%-- 在 jsp 文件加载前引入内容 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Hello</title>
    <meta charset="UTF-8"/>
</head>
<body>
<div>
    <%-- 动作标签 --%>
    <jsp:include page="include"/>
    <jsp:useBean id="user" class="cn.ivfzhou.java.javaee.bean.User"/>
    <jsp:setProperty name="user" property="name" value="ivfzhou"/>
    <jsp:getProperty name="user" property="name"/>
    <%--<jsp:forward page="index.jsp">
        <jsp:param name="name" value="value"/>
    </jsp:forward>--%>

    <br/>
    <%-- EL表达式 --%>
    <%-- false --%>
    ${empty pageScope.user.name}
    <br/>
    ${param}
    <br/>

    <%-- 输出脚本 --%>
    <%=
    new Date()
    %>
    <br/>

    <%-- 语句脚本 --%>
    <%
        out.println("pageContext：" + pageContext);
        out.println("<br/>");
        out.println("session：" + session);
        out.println("<br/>");
        out.println("application：" + application);
        out.println("<br/>");
        out.println("config：" + config);
        out.println("<br/>");
        out.println("out：" + out);
        out.println("<br/>");
        out.println("page：" + page);
        out.println("<br/>");
    %>

    <%-- 全局代码块 --%>
    <%!
        private final static int num = 9;

        public void run() {
            System.out.println(num);
        }
    %>

    <%-- jstl --%>
    <c:if test="${1>1}">
    </c:if>
    <c:choose>
        <c:when test=""></c:when>
        <c:otherwise></c:otherwise>
    </c:choose>
    <c:forEach var="" items="" begin="" end="" step="" varStatus="">
    </c:forEach>
    <%-- 把 var 变量赋值为 value 值 --%>
    <c:url var="" value=""/>
</div>
</body>
</html>
