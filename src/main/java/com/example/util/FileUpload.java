package com.example.util;

import com.example.bean.MemberVO;
import com.example.dao.MemberDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Member;

public class FileUpload {
    public MemberVO uploadPhoto(HttpServletRequest request)
    {
        String filename = "";
        int sizeLimit = 15 * 1024 * 1024;

        String realPath = request.getServletContext().getRealPath("upload");
        System.out.println("RealPath: " + realPath);

        File dir = new File(realPath);
        if(!dir.exists())
            dir.mkdirs();

        MemberVO one = null;
        MultipartRequest multipartRequest = null;
        try {
            multipartRequest = new MultipartRequest(request, realPath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());

            filename = multipartRequest.getFilesystemName("photo");

            one = new MemberVO();
            String seq = multipartRequest.getParameter("seq");
            String age = multipartRequest.getParameter("age");
            if(seq!=null&&!seq.equals(""))
                one.setSeq(Integer.parseInt(seq));
            one.setSid(multipartRequest.getParameter("sid"));
            one.setPosition(multipartRequest.getParameter("position"));
            one.setName(multipartRequest.getParameter("name"));
            one.setAge(Integer.parseInt(age));
            one.setMajor(multipartRequest.getParameter("major"));
            one.setPhone(multipartRequest.getParameter("phone"));
            one.setPosition(multipartRequest.getParameter("position"));

            if(seq!=null&&seq.equals(""))
            {
                MemberDAO dao = new MemberDAO();
                String oldfilename = dao.getPhotoFilename(Integer.parseInt(seq));
                if(filename != null && oldfilename != null)
                    FileUpload.deleteFile(request, oldfilename);
                else if(filename == null && oldfilename != null)
                    filename = oldfilename;
            }

            one.setPhoto(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return one;
    }

    public static void deleteFile(HttpServletRequest request, String filename)
    {
        String filePath = request.getServletContext().getRealPath("upload");

        File f = new File(filePath + "/" + filename);
        if(f.exists())
            f.delete();
    }
}
