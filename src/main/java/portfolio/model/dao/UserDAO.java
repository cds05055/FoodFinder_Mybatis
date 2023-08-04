package portfolio.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import portfolio.model.vo.User;

public class UserDAO {

	public int insertUser(Connection conn, User user) {
		String query = "INSERT INTO USER_TBL VALUES(?,?,?,?,?,?,?,DEFAULT)";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserPw());
			pstmt.setString(3, user.getUserNickname());
			pstmt.setString(4, user.getUserName());
			pstmt.setInt(5, user.getUserAge());
			pstmt.setString(6, user.getUserGender());
			pstmt.setString(7, user.getUserPhone());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int modifyUser(Connection conn, User user) {
		String query = "UPDATE USER_TBL SET USER_PW = ?, USER_NICKNAME = ?, USER_PHONE = ? WHERE USER_ID = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user.getUserPw());
			pstmt.setString(2, user.getUserNickname());
			pstmt.setString(3, user.getUserPhone());
			pstmt.setString(4, user.getUserId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int deleteUser(Connection conn, User user) {
		String query = "DELETE FROM USER_TBL WHERE USER_ID = ? AND USER_PW = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserPw());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public User selectCheckLogin(Connection conn, User user) {
		String query = "SELECT * FROM USER_TBL WHERE USER_ID = ? AND USER_PW = ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		User uOne = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserPw());
			rset = pstmt.executeQuery();
			if(rset.next()) {
				uOne = rsetToUser(rset);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return uOne;
	}

	public User selectOneById(Connection conn, String userId) {
		String query = "SELECT * FROM USER_TBL WHERE USER_ID = ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		User uOne = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				uOne = rsetToUser(rset);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return uOne;
	}

	private User rsetToUser(ResultSet rset) throws SQLException {
		User user = new User();
		user.setUserId(rset.getString("USER_ID"));
		user.setUserPw(rset.getString("USER_PW"));
		user.setUserNickname(rset.getString("USER_NICKNAME"));
		user.setUserName(rset.getString("USER_NAME"));
		user.setUserAge(rset.getInt("USER_AGE"));
		user.setUserGender(rset.getString("USER_GENDER"));
		user.setUserPhone(rset.getString("USER_PHONE"));
		user.setUserEnrollDate(rset.getTimestamp("USER_ENROLLDATE"));
		return user;
	}

}
