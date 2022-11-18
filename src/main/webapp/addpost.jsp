<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.example.dao.MemberDAO"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.*"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import="com.example.util.FileUpload" %>
<%@ page import="com.example.bean.MemberVO" %>

<%--<% request.setCharacterEncoding("utf-8"); %>--%>

<%--<jsp:useBean id="u" class="com.example.bean.MemberVO" />--%>
<%--<jsp:setProperty property="*" name="u"/>--%>

<%
    request.setCharacterEncoding("utf-8");
	MemberDAO memberDAO = new MemberDAO();
	FileUpload upload = new FileUpload();
    MemberVO u = upload.uploadPhoto(request);

    int i = memberDAO.insertMember(u);
	String msg = "데이터 추가 성공 !";
	if(i == 0) msg = "[에러] 데이터 추가 ";
%>

<script>
	alert('<%=msg%>');
	location.href='posts.jsp';
</script>