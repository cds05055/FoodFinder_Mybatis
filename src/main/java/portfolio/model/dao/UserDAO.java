package portfolio.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import portfolio.model.vo.User;

public class UserDAO {

	public int insertUser(SqlSession session, User user) {
		int result = session.insert("UserMapper.insertUser", user);
		return result;
	}

	public int modifyUser(SqlSession session, User user) {
//		String query = "UPDATE USER_TBL SET USER_PW = ?, USER_NICKNAME = ?, USER_PHONE = ? WHERE USER_ID = ?";
		int result = session.update("UserMapper.modifyUser", user);
		return result;
	}

	public int deleteUser(SqlSession session, User user) {
//		String query = "DELETE FROM USER_TBL WHERE USER_ID = ? AND USER_PW = ?";
		int result = session.delete("UserMapper.deleteUser", user);
		return result;
	}

	public User selectCheckLogin(SqlSession session, User user) {
		User uOne = session.selectOne("UserMapper.selectCheckLogin", user);
		return uOne;
	}

	public User selectOneById(SqlSession session, String userId) {
//		String query = "SELECT * FROM USER_TBL WHERE USER_ID = ?";
		User uOne = session.selectOne("UserMapper.selectOneById", userId);
		return uOne;
	}

//	private User rsetToUser(ResultSet rset) throws SQLException {
//		User user = new User();
//		user.setUserId(rset.getString("USER_ID"));
//		user.setUserPw(rset.getString("USER_PW"));
//		user.setUserNickname(rset.getString("USER_NICKNAME"));
//		user.setUserName(rset.getString("USER_NAME"));
//		user.setUserAge(rset.getInt("USER_AGE"));
//		user.setUserGender(rset.getString("USER_GENDER"));
//		user.setUserPhone(rset.getString("USER_PHONE"));
//		user.setUserEnrollDate(rset.getTimestamp("USER_ENROLLDATE"));
//		return user;
//	}

}
