<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>学生信息查询系统</title>
</head>

<body>
<h1>学生信息系统</h1>
<h2>新增学生信息</h2>
<div>
<form action="/POST/student" role="form">
    填写新学员信息：<br/>
       线上学号：<input type="text" name="onlineId"><br/>
    &emsp;&emsp;姓名：<input type="text" name="name"><br/>
    &emsp;&emsp;&emsp; qq：<input type="text" name="qq"><br/>
       修真类型：<input type="text" name="carrer"><br/>
    <input type="submit" value="提  交">  ${postMsg}

</form>
</div>
<h2>修改学生信息</h2>
   <form action="/UPDATE/student" role="form">
    填写新学员信息：<br/>
    线上学号：<input type="text" name="onlineId"><br/>
       &emsp;&emsp;姓名：<input type="text" name="name"><br/>
       &emsp;&emsp;&emsp;qq：<input type="text" name="qq"><br/>
    修真类型：<input type="text" name="carrer"><br/>
    <input type="submit" value="提  交">  ${updateMsg}

   </form>
<h2>查看学生信息</h2>
<p>查询学号：<input type="text" id="onlineId1">  <a href="/GET/student?onlineId=" onclick="this.href=this.href+document.getElementById('onlineId1').value"><button> 查询</button></a> </p>
<P>${student}</P>
<a href="/GET/students/page?currentPage=1">点击此处查看全部学生信息</a>
<h2>删除学生信息</h2>
<p>删除学号为：<input type="text" id="onlineId">  <a href="/DELETE/student?onlineId=" onclick="this.href=this.href+document.getElementById('onlineId').value"><button> 删除</button></a> ${deleteMsg}</p>
</body>
</html>

