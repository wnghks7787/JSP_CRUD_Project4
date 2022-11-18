<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.example.dao.MemberDAO, com.example.bean.MemberVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Form</title>
</head>
<body>

<%
	MemberDAO memberDAO = new MemberDAO();
	String id=request.getParameter("id");
	MemberVO u=memberDAO.getMember(Integer.parseInt(id));
    request.setAttribute("vo", u);
%>

<h1>Edit Form</h1>
<form action="editpost.jsp" method="post" enctype="multipart/form-data">
<input type="hidden" name="seq" value="<%=u.getSeq() %>"/>
<table>
<tr><td>StudentID:</td><td><input type="text" name="sid" value="<%= u.getSid()%>"/></td></tr>
    <tr><td>Position:</td><td><select name="position" value="<%=u.getPosition()%>">
        <option value="president">회장</option>
        <option value="vicePresident">부회장</option>
        <option value="secretary">총무</option>
        <option value="officer">임원</option>
        <option value="member">정회원</option>
        <option value="associateMember">준회원</option>
    </select></td></tr>
<tr><td>Name:</td><td><input type="text" name="name" value="<%= u.getName()%>"/></td></tr>
<tr><td>Age:</td><td><input type="number" name="age" value="<%= u.getAge()%>" /></td></tr>
<tr><td>Major:</td><td><input type="text" name="major" value="<%= u.getMajor()%>" /></td></tr>
<tr><td>Phone Number:</td><td><input type="text" name="phone" value="<%= u.getPhone()%>" /></td></tr>
<tr>
    <td>Photo</td><input type="file" name="photo" value="${vo.getPhoto()}" />
    <c:if test="${vo.getPhoto() ne ''}"><br /><img src="${pageContext.request.contextPath }/upload/${vo.getPhoto()}"></c:if>
</tr>
<tr><td colspan="2"><input type="submit" value="Edit Post"/>
<input type="button" value="Cancel" onclick="history.back()"/></td></tr>
</table>
</form>

</body>
</html>