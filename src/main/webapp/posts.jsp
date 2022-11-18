<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@ page import="com.example.dao.MemberDAO" %>
<%@ page import="com.example.bean.MemberVO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>free board</title>
<style>
#list {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}
#list td, #list th {
  border: 1px solid #ddd;
  padding: 8px;
  text-align:center;
}
#list tr:nth-child(even){background-color: #f2f2f2;}
#list tr:hover {background-color: #ddd;}
#list th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: center;
  background-color: #006bb3;
  color: white;
}
</style>
<script>
	function delete_ok(id) {
        var a = confirm("정말로 삭제하겠습니까?");
        if (a) location.href = 'deletepost.jsp?id=' + id;
    }
</script>
</head>
<body>
<h1>동아리 회원 관리</h1>
<%
	MemberDAO memberDAO = new MemberDAO();
	List<MemberVO> list = memberDAO.getMemberList();
	request.setAttribute("list",list);
%>
<table id="list" width="90%">
<tr>
    <th>#</th>
    <th>photo</th>
	<th>StudentID</th>
    <th>Position</th>
    <th>Name</th>
	<th>Age</th>
	<th>Major</th>
	<th>Phone</th>
	<th>Regdate</th>
	<th>Edit</th>
	<th>Delete</th>
</tr>
<c:forEach items="${list}" var="u">
	<tr>
		<td>${u.getSeq()}</td>
        <td><c:if test="${u.getPhoto() ne ''}"><br />
        <img src="${pageContext.request.contextPath }/upload/${u.getPhoto()}" class="photo" width="150px"></c:if></td>
        <td>${u.getSid()}</td>
        <td>${u.getPosition()}</td>
		<td>${u.getName()}</td>
		<td>${u.getAge()}</td>
		<td>${u.getMajor()}</td>
        <td>${u.getPhone()}</td>
		<td>${u.getRegdate()}</td>
		<td><a href="editform.jsp?id=${u.getSeq()}">Edit</a></td>
		<td><a href="javascript:delete_ok('${u.getSeq()}')">Delete</a></td>
	</tr>
</c:forEach>
</table>
<br/><a href="addpostform.jsp">Add New Member</a>
</body>
</html>