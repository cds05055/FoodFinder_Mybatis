package portfolio.model.service;

import java.sql.Connection;

import portfolio.common.JDBCTemplate;
import portfolio.model.dao.UserDAO;
import portfolio.model.vo.User;

public class UserService {
	private JDBCTemplate jdbcTemplate;
	private UserDAO uDao;
	
	public UserService() {
		jdbcTemplate = JDBCTemplate.getInstance();
		uDao = new UserDAO();
	}

	public User selectCheckLogin(User user) {
		Connection conn = jdbcTemplate.createConnection();
		User uOne = uDao.selectCheckLogin(conn, user);
		jdbcTemplate.close(conn);
		return uOne;
	}


	public User selectOneById(String userId) {
		Connection conn = jdbcTemplate.createConnection();
		User uOne = uDao.selectOneById(conn, userId);
		jdbcTemplate.close(conn);
		return uOne;
	}

	public int insertUser(User user) {
		// 연결 생성
		Connection conn = jdbcTemplate.createConnection();
		
		// DAO 호출(연결과 같이 전달)
		int result = uDao.insertUser(conn, user);
		
		// 커밋, 롤백
		if(result > 0) {
			// 성공 시 커밋
			jdbcTemplate.commit(conn);
		} else {
			// 실패 시 롤백
			jdbcTemplate.rollback(conn);
		}
		jdbcTemplate.close(conn);
		return result;
	}

	public int modifyUser(User user) {
		Connection conn = jdbcTemplate.createConnection();
		int result = uDao.modifyUser(conn, user);
		if(result > 0) {
			jdbcTemplate.commit(conn);
		} else {
			jdbcTemplate.rollback(conn);
		}
		jdbcTemplate.close(conn);
		return result;
	}

	public int deleteUser(User user) {
		Connection conn = jdbcTemplate.createConnection();
		int result = uDao.deleteUser(conn, user);
		if(result > 0) {
			jdbcTemplate.commit(conn);
		} else {
			jdbcTemplate.rollback(conn);
		}
		jdbcTemplate.close(conn);
		return result;
	}

}
