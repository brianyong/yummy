package edu.kh.yummy.member.model.service;

import static edu.kh.yummy.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.yummy.store.model.vo.Store;
import edu.kh.yummy.member.model.dao.MemberDAO;
import edu.kh.yummy.member.model.vo.Member;

// Service : 비즈니스 로직 처리(데이터 가공, 트랜잭션 처리)
public class MemberService {

	private MemberDAO dao = new MemberDAO();

	/**
	 * 로그인 Service
	 * 
	 * @param memberId
	 * @param memberPw
	 * @return loginMember
	 * @throws Exception
	 */
	public Member login(String memberId, String memberPw) throws Exception {

		// DB 연결 정보를 담고있는 Connection을 얻어옴.
		Connection conn = getConnection();

		// 얻어온 Connection과 매개변수를 DAO의 알맞은 메소드로 전달하여 결과를 반환 받음.
		Member loginMember = dao.login(conn, memberId, memberPw);

		// 커넥션 반환
		close(conn);
		
		// 서비스 수행 결과 반환
		return loginMember;
	}
	
	
	/** 회원가입 Service
	 * @param member
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Member member) throws Exception{
	      
		  // 1) 커넥션 얻어오기
	      Connection conn = getConnection();
	      
	      // 2) DAO 호출해서 insert 진행 후 결과 반환받기
	      int result = dao.signUp(conn, member);
	      
	      // 3) 반환 받은 결과에 따라 트랜잭션 처리하기
	      if(result > 0) {
	         commit(conn);
	      }else {
	         rollback(conn);
	      }
	      
	      // 4) 사용한 커넥션 반환하기
	      close(conn);
	      
	      // 5) 결과를 Controller로 반환하기
	      return result;
	      
	   }
	
	
	/** 아이디 중복검사 Service
	 * @param id
	 * @return result
	 * @throws Exception
	 */
	public int idDupCheck(String id) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.idDupCheck(conn, id);
		
		close(conn);
		
		return result;
	}
	
	
	/** 비밀번호 변경 Service
	 * @param currentPwd
	 * @param newPwd1
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int changePwd(String currentPwd, String newPwd1, int memberNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.changePwd(conn, currentPwd, newPwd1, memberNo);
		
		if(result > 0) 	commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}
	
	
	/** 회원 탈퇴 Service
	 * @param currentPwd
	 * @param memberNo 
	 * @return result
	 * @throws Exception
	 */
	public int secession(String currentPwd, int memberNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.secession(conn, currentPwd, memberNo);
		
		if(result > 0) 	commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}
	

	/**
	 * 가게정보 조회Service
	 * 
	 * @param memberNo
	 * @return storeInfo
	 * @throws Exception
	 */
	public Store storeInfo(int memberNo) throws Exception {

		Connection conn = getConnection();

		Store storeInfo = dao.storeInfo(conn, memberNo);

		close(conn);
		return storeInfo;
	}

	/**
	 * 일반회원 정보 업데이트 서비스
	 * 
	 * @param memberPhone
	 * @param memberEmail
	 * @param memberNo
	 * @return
	 * @throws Exception
	 */
	public int memberUpdate(String memberPhone, String memberEmail, int memberNo) throws Exception {
		Connection conn = getConnection();

		int result = dao.memberUpdate(conn, memberPhone, memberEmail, memberNo);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);

		return result;

	}

	/**
	 * 점주 정보 업데이터 서비스
	 * 
	 * @param memberPhone
	 * @param memberEmail
	 * @param storePhone
	 * @param storeAddress
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int ownerUpdate(  String memberPhone, String memberEmail, String storeAddr, String storePhone1,  
			int memberNo) throws Exception {

		Connection conn = getConnection();
		int  result = dao.memberUpdate(conn, memberPhone, memberEmail, memberNo);
		

		if (result > 0) {// 가게정보 수정 성공시
			result = dao.ownerUpdate(conn, storePhone1, storeAddr, memberNo);
			

			if (result == 0) {// insert가 안된 경우

				System.out.println("실패야 임마 제대로 해 ");

			}

		}

		// 반복문 종료 후 result가 0보다 큰경우
		// == 첨부 파일의 수정, 삽입이 모두 성공한 경우
		if (result > 0)

		{
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);

		return result;
	}

}