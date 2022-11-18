<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.example.dao.MemberDAO"%>
<%@ page import="com.example.util.FileUpload" %>
<%
	String seq = request.getParameter("id");
	if (seq != ""){
		int id = Integer.parseInt(seq);
        MemberDAO memberDAO = new MemberDAO();
        System.out.println("id : " + id);
//        MemberVO u = new MemberVO();
//        u.setSeq(id);

        String filename = memberDAO.getPhotoFilename(id);
        if(filename != null)
            FileUpload.deleteFile(request, filename);

		memberDAO.deleteMember(id);
	}
	response.sendRedirect("posts.jsp");
%>