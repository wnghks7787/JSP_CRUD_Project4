package com.example.dao;

import com.example.bean.MemberVO;
import com.example.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	private final String MEMBER_INSERT = "insert into MEMBER (sid, position, name, age, major, phone, photo) values (?,?,?,?,?,?,?)";
	private final String MEMBER_UPDATE = "update MEMBER set sid=?, position=?, name=?, age=?, major=?, phone=?, photo=? where seq=?";
	private final String MEMBER_DELETE = "delete from MEMBER where seq=?";
	private final String MEMBER_GET = "select * from MEMBER where seq=?";
	private final String MEMBER_LIST = "select * from MEMBER order by seq desc";
    private final String MEMBER_SELECT = "select * from MEMBER where seq=?";

	public int insertMember(MemberVO vo) {
        int result = 0;
		System.out.println("===> JDBC로 insertMember() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MEMBER_INSERT);
            stmt.setString(1, vo.getSid());
            stmt.setString(2, vo.getPosition());
			stmt.setString(3, vo.getName());
			stmt.setInt(4, vo.getAge());
			stmt.setString(5, vo.getMajor());
            stmt.setString(6, vo.getPhone());
            stmt.setString(7, vo.getPhoto());
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	// 글 삭제
	public void deleteMember(int vo) {
		System.out.println("===> JDBC로 deleteMember() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MEMBER_DELETE);
			stmt.setInt(1, vo);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int updateMember(MemberVO vo) {
		System.out.println("===> JDBC로 updateMember() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MEMBER_UPDATE);
            stmt.setString(1, vo.getSid());
            stmt.setString(2, vo.getPosition());
			stmt.setString(3, vo.getName());
			stmt.setInt(4, vo.getAge());
			stmt.setString(5, vo.getMajor());
            stmt.setString(6, vo.getPhone());
            stmt.setString(7, vo.getPhoto());
			stmt.setInt(8, vo.getSeq());
			
			
			System.out.println(vo.getSid() + "-" + vo.getPosition() + vo.getName() + "-" + vo.getAge() + "-" + vo.getMajor() + "-" + vo.getPhone() + "-" + vo.getPhoto() + "-" + vo.getSeq());
			stmt.executeUpdate();
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}	
	
	public MemberVO getMember(int seq) {
		MemberVO one = new MemberVO();
		System.out.println("===> JDBC로 getMember() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MEMBER_GET);
			stmt.setInt(1, seq);
			rs = stmt.executeQuery();
			if(rs.next()) {
				one.setSeq(rs.getInt("seq"));
                one.setPhoto(rs.getString("photo"));
                one.setSid(rs.getString("sid"));
                one.setPosition(rs.getString("position"));
				one.setName(rs.getString("name"));
				one.setAge(rs.getInt("age"));
				one.setMajor(rs.getString("major"));
				one.setPhone(rs.getString("phone"));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return one;
	}
	
	public ArrayList<MemberVO> getMemberList(){
		ArrayList<MemberVO> list = null;
		System.out.println("===> JDBC로 getMemberList() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MEMBER_LIST);
			rs = stmt.executeQuery();
            list = new ArrayList<MemberVO>();
            MemberVO one = new MemberVO();
			while(rs.next()) {
                one = new MemberVO();
				one.setSeq(rs.getInt("seq"));
                one.setPhoto(rs.getString("photo"));
                one.setSid(rs.getString("sid"));
                one.setPosition(rs.getString("position"));
				one.setName(rs.getString("name"));
				one.setAge(rs.getInt("age"));
				one.setMajor(rs.getString("major"));
                one.setPhone(rs.getString("phone"));
				one.setRegdate(rs.getDate("regdate"));
                list.add(one);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return list;
	}

    public String getPhotoFilename(int seq)
    {
        String filename = null;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(MEMBER_GET);
            stmt.setInt(1, seq);
            rs = stmt.executeQuery();
            if(rs.next())
                filename = rs.getString("photo");
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("===> JDBC로 getPhotoFilename() 기능 처리");
        return filename;
    }

    public MemberVO getOne(int seq)
    {
        MemberVO one = null;
        conn = JDBCUtil.getConnection();
        try {
            stmt = conn.prepareStatement(MEMBER_SELECT);
            stmt.setInt(1, seq);
            rs = stmt.executeQuery();
            if(rs.next()) {
                one = new MemberVO();
                one.setSeq(rs.getInt("seq"));
                one.setSid(rs.getString("sid"));
                one.setPhoto(rs.getString("photo"));
                one.setName(rs.getString("name"));
                one.setAge(rs.getInt("age"));
                one.setPosition(rs.getString("position"));
                one.setMajor(rs.getString("major"));
                one.setPhone(rs.getString("phone"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return one;
    }
}
