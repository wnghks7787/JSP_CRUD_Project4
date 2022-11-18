<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Add New Post</h1>
<form action="addpost.jsp" method="post" enctype="multipart/form-data">
<table>
<tr><td>StudentID:</td><td><input type="text" name="sid"/></td></tr>
<tr><td>Position:</td><td><select name="position">
    <option value="president">회장</option>
    <option value="vicePresident">부회장</option>
    <option value="secretary">총무</option>
    <option value="officer">임원</option>
    <option value="member">정회원</option>
    <option value="associateMember">준회원</option>
</select></td></tr>
<tr><td>Name:</td><td><input type="text" name="name"/></td></tr>
<tr><td>Age:</td><td><input type="number" name="age"/></td></tr>
<tr><td>Major:</td><td><input type="text" name="major"/></td></tr>
<tr><td>Phone Number:</td><td><input type="text" name="phone"/></td></tr>
<tr><td>Image file Upload:</td><td><input type="file" name="photo"></td></tr>
<tr><td><a href="posts.jsp">View All Records</a></td><td align="right"><input type="submit" value="Add Post"/></td></tr>
</table>
</form>

</body>
</html>