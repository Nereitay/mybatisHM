<%@ page import="org.apache.ibatis.io.Resources" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactoryBuilder" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="es.kiwi.domain.User" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.util.List" %>
<%@ page import="es.kiwi.dao.IUserDAO" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<body>
<h2>Hello World!</h2>
<%

    InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    SqlSessionFactory factory = builder.build(in);

    SqlSession sqlSession = factory.openSession();

    IUserDAO userDao = sqlSession.getMapper(IUserDAO.class);

    List<User> users = userDao.findAll();
    for(User user : users){
        System.out.println(user);
    }

    sqlSession.close();
    in.close();
%>
</body>
</html>
