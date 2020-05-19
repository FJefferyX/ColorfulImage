<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>


<form method="post" action="${pageContext.request.contextPath}/img/gray2rgb.do" enctype="multipart/form-data">
    上传文件：<input type="file" name="image">
    名字：<input type="text" name="name">
    <input type="submit" value="上传">
</form>

<br>
<form method="post" action="${pageContext.request.contextPath}/img/gray2rgb.do">
    名字：<input type="text" name="name">
    <input type="submit" value="上传">
</form>

</body>
</html>
