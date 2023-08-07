package portfolio.notice.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import portfolio.notice.model.vo.Notice;

public class NoticeDAO {
	public String generatePageNavi(int currentPage) {
		// 전체 게시물의 갯수
		int totalCount = 209;
		// 페이지 당 보여줄 게시물의 갯수
		int recordCountPerPage = 10;
		// 이전 다음이 있는 페이지 최대수
		int naviCountPerPage = 5;
		int totalNaviCount;
		
		if(totalCount % recordCountPerPage > 0) {
			totalNaviCount = totalCount/recordCountPerPage + 1;
		} else {
			// 최대 페이지 수
			totalNaviCount = totalCount/recordCountPerPage;
		}
		// currentPage			startNavi
		// 1,2,3,4,5				1
		// 6,7,8,9,10				6
		// 11,12,13,14,15			11
		
		// currentPage			endNavi
		// 1,2,3,4,5				5
		// 6,7,8,9,10				10
		// 11,12,13,14,15			15
		
		int startNavi = ((currentPage - 1)/naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		if(endNavi > totalNaviCount) {
			endNavi = totalNaviCount;
		}
		
		StringBuffer result = new StringBuffer();
		
		for(int i = startNavi; i <= endNavi; i++) {
			result.append("<a href='#'>" + i + "</a>");			
		}
		return result.toString();
	}
	
	private int getTotalCount(SqlSession session) {
		int totalCount = session.selectOne("NoticeMapper.getTotalCount");
		
		/*
		 * <select id="NoticeMapper.getTotalCount" resultType="_int">
		 * 		SELECT COUNT(*) FROM NOTICE_TBL
		 * </select>
		 */
		return totalCount;
	}

	public int insertNotice(SqlSession session, Notice notice) {
		int result = session.insert("NoticeMapper.insertNotice", notice);
		return result;
	}

	public List<Notice> selectNoticeList(SqlSession session) {
		List<Notice> nList = session.selectList("NoticeMapper.selectNoticeList");
		return nList;
	}

	public Notice selectOenByNo(SqlSession session, int noticeNo) {
		Notice notice = session.selectOne("NoticeMapper.selectOenByNo", noticeNo);
		return notice;
	}

	public int deleteNotice(SqlSession session, int noticeNo) {
		int result = session.delete("NoticeMapper.deleteNotice", noticeNo);
		return result;
	}

	public int modifyNotice(SqlSession session, Notice notice) {
		int result = session.update("NoticeMapper.modifyNotice", notice);
		return result;
	}
}
