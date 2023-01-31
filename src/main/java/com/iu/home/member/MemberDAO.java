package com.iu.home.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import org.eclipse.jdt.internal.compiler.batch.Main;

import com.iu.home.util.DBConnection;

public class MemberDAO {
//data access
	Scanner sc = new Scanner(System.in);
	
	
	public int setAddMember(MemberDTO dto) throws Exception {	
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "INSERT INTO MEMBER (ID, PW, NAME, PHONE, EMAIL) "
				+ "VALUES (?, ?, ?, ?, ?)";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, dto.getId());
		st.setString(2, dto.getPw());
		st.setString(3, dto.getName());
		st.setString(4, dto.getPhone());
		st.setString(5, dto.getEmail());

		int result = st.executeUpdate();
		
		DBConnection.disConnection(connection, st);
		return result;
	}
	

	public static void main(String[] args) {
		// 스태틱 메서드라서 같은 클래스라도 객체만들어줘야대
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("test1");
		memberDTO.setPw("11");
		memberDTO.setName("11");
		memberDTO.setPhone("11");
		memberDTO.setEmail("11");
		try {
			System.out.println(memberDAO.setAddMember(memberDTO) != 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
	
	
}
