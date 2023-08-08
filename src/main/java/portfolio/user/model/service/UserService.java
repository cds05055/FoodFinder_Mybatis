	package portfolio.user.model.service;

import org.apache.ibatis.session.SqlSession;

import portfolio.common.JDBCTemplate;
import portfolio.common.SqlSessionTemplate;
import portfolio.user.model.dao.UserDAO;
import portfolio.user.model.vo.User;;

public class UserService {
	private JDBCTemplate jdbcTemplate;
	private UserDAO uDao;
	
	public UserService() {
		jdbcTemplate = JDBCTemplate.getInstance();
		uDao = new UserDAO();
	}

	public User selectCheckLogin(User user) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		User uOne = uDao.selectCheckLogin(session, user);
		session.close();
		return uOne;
	}


	public User selectOneById(String userId) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		User uOne = uDao.selectOneById(session, userId);
		session.close();
		return uOne;
	}

	public int insertUser(User user) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = uDao.insertUser(session, user);
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public int modifyUser(User user) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = uDao.modifyUser(session, user);
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public int deleteUser(User user) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = uDao.deleteUser(session, user);
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

}
