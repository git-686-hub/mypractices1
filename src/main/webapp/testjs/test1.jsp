<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>js测试</title>
<script src="${pageContext.request.contextPath}/jquery/jquery-3.4.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/test.js">

</script>
</head>
<body>
<button type="button" value="点我显示日期"  onclick="show()">显示日期</button>
<button type="button" value="点我显示" onclick="showString()">显示文字</button>
<button type="button" value="点我显示" onclick="print()">输出</button>
<button type="button" value="点我显示" onclick="reset()">还原</button>
<p id="demo">这里要显示什么呢？</p>
</body>
</html>