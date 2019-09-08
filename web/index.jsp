<%--
  Created by IntelliJ IDEA.
  User: Li Dongfang
  Date: 2019/4/21
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>HomePagee</title>
</head>
<body>



<a href="/hello/handle03">handle03测试url中的请求参数RequestParam</a>

<br/>
<br/>
<br/>
<a href="/hello/handle02?username=tomcat">handle02测试url中的请求参数</a>




<br/>
<br/>
<br/>

<br/>
<br/>
<br/>
<a href="/hello/handle01">Hello World</a>
<br/>
<br/>
<br/>


<a href="/shopping/book/1">查询图书</a>
<br/>
<br/>
<br/>

<%--
<a href="/shopping/book/1">新增图书</a>
--%>
<form action="/shopping/book/1" method="post">
    <input type="submit" value="更新1号图书">
</form>
<br/>
<br/>
<br/>


<%--
<a href="/shopping/book/1">更新图书</a>
--%>
<form action="/shopping/book/1" method="post">
    <input name="_method" id="put">
    <input type="submit" value="更新1号图书">
</form>
<br/>
<br/>
<br/>


<%--
<a href="/shopping/book/1">删除图书</a>
--%>
<form action="/shopping/book/1" method="post">
    <input name="_method" id="delete">
    <input type="submit" value="删除1号图书">
</form>
<br/>
<br/>
<br/>
</body>
</html>

<%--http://localhost:31945/index.jsp--%>
