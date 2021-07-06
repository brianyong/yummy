package edu.kh.yummy.gps.model.service;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static edu.kh.yummy.common.JDBCTemplate.*;
import edu.kh.yummy.store.model.vo.Store;

public class GpsDAO {
	
	// 자주 사용하는 JDBC 객체 참조 변수 선언
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// 외부 XML 파일에 작성된 SQL 구문을 읽어와 저장할 Properties객체 참조 변수 선언
	private Properties prop = null;
	
	
	// 기본 생성자를 이용한 DAO 객체 생성 시 외부 XML파일을 읽어와 prop에 저장
	public GpsDAO() {
		// selectBoard-query.xml 파일의 경로 얻어오기
		String filePath 
			= GpsDAO.class.getResource("/edu/kh/yummy/sql/gps/gps-query.xml").getPath();                    
		
		try {
			prop = new Properties();
			
			// filePath 변수에 저장된 경로로 부터 XML 파일을 읽어와 prop에 저장
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/** 주소 검색 시 구 단위의 가게 정보 조회
	 * @author Choiyujeong
	 * @param conn
	 * @param searchGu
	 * @return sList
	 * @throws Exception
	 */
	public List<Store> selectList(Connection conn, String condition) throws Exception{
		
		List<Store> sList = new ArrayList<Store>();
		
		String sql = prop.getProperty("selectList") + condition ;
		
		try {
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				
				String storeName = rs.getString(1);
				String storeAddr = rs.getString(2);
				
				
				int e = storeAddr.indexOf(",");
				
				storeAddr = storeAddr.substring(e+2);
				
				Store store = new Store(storeName, storeAddr);
				
				
				sList.add(store);
				
			}
			
			
		}finally {
			close(rs);
			close(stmt);
		}
		
		return sList;
	}

}
