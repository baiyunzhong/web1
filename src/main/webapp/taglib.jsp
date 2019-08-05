<%--
  Created by IntelliJ IDEA.
  User: baiyunzhong
  Date: 2019/8/5
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<html>
<head>
    <title>Json Tag-lib</title>
</head>
<body>
<json:object>
    <json:property name="name" value="${name}"/>
    <json:property name="onlineId" value="${onlineId}"/>
    <json:property name="qq" value="${qq}"/>
    <json:property name="carrer" value="${carrer}"/>
    <json:property name="enterDateString" value="${enterDateString}"/>
    <json:property name="school" value="${school}"/>
    <json:property name="dailyLinks" value="${dailyLinks}"/>
    <json:property name="slogan" value="${slogan}"/>
    <json:property name="senior" value="${senior}"/>
    <json:property name="source" value="${source}"/>
    <json:property name="createAtString" value="${createAtString}"/>
    <json:property name="updateAtString" value="${updateAtString}"/>
</json:object>
</body>
</html>
