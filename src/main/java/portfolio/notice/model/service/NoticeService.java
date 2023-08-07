package portfolio.notice.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import portfolio.common.SqlSessionTemplate;
import portfolio.notice.model.dao.NoticeDAO;
import portfolio.notice.model.vo.Notice;

public class NoticeService {
	private NoticeDAO nDao;
	
	public NoticeService() {
		nDao = new NoticeDAO();
	}
	
	public int insertNotice(Notice notice) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = nDao.insertNotice(session, notice);
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public List<Notice> selectNoticeList() {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		List<Notice> nList = nDao.selectNoticeList(session);
		return nList;
	}

	public Notice selectOenByNo(int noticeNo) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		Notice notice = nDao.selectOenByNo(session, noticeNo);
		return notice;
	}

	public int deleteNotice(int noticeNo) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = nDao.deleteNotice(session, noticeNo);
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public int modifyNotice(Notice notice) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = nDao.modifyNotice(session, notice);
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	
}
