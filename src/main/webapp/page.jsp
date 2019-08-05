<%--
  Created by IntelliJ IDEA.
  User: baiyunzhong
  Date: 2019/7/25
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>分页查询</title>
</head>
<body>
    <h1>修真院学生报名信息</h1>
    <p><a href="/index.jsp">返回</a>></p>
    <br>

<%-- 当前用户：${pageScope.currentUser}<!-- (只能在同一个页面中使用) --> <br>
当前用户：${requestScope.currentUser}-${roleName} 有重定向数据就访问不到<br>
当前用户：${sessionScope.currentUser}-${roleName} 可以使用<br> --%>

    <div>
        <table border="1" cellpadding="10" cellspacing="0" class="table1">
            <thead>
            <tr>
                <td>线上学号</td>
                <td>姓名</td>
                <td>QQ号码</td>
                <td>修真类型</td>
                <td>预计入学时间</td>
                <td>毕业学校</td>
                <td>日报链接</td>
                <td>立愿</td>
                <td>辅导师兄</td>
                <td>从何处了解到修真院</td>
                <td>创建日期</td>
                <td>修改日期</td>

            </tr>
            </thead>
            <c:forEach items="${students}" var="s">
                <tr>
                    <th>${s.onlineId }</th>
                    <th>${s.name }</th>
                    <th>${s.qq }</th>
                    <th>${s.carrer }</th>
                    <th>${s.enterDateString}</th>
                    <th>${s.school}</th>
                    <th>${s.dailyLinks}</th>
                    <th>${s.slogan}</th>
                    <th>${s.senior}</th>
                    <th>${s.source}</th>
                    <th>${s.createAtString}</th>
                    <th>${s.updateAtString}</th>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div>
        <a href="/GET/students/page?currentPage=1">首页</a>
        <a href="/GET/students/page?currentPage=${requestScope.page.currentPage-1}">上一页</a>
        <a href="/GET/students/page?currentPage=${requestScope.page.currentPage+1}">下一页</a>
        <a href="/GET/students/page?currentPage=${requestScope.page.pageCount}">尾页</a>
    </div>
</body>
</html>
