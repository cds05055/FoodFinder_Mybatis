package portfolio.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import portfolio.notice.model.service.NoticeService;
import portfolio.notice.model.vo.Notice;

/**
 * Servlet implementation class insertNoticeController
 */
@WebServlet("/notice/insertNotice.do")
public class InsertNoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertNoticeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/notice/insert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String noticeSubject = request.getParameter("noticeSubject");
		String noticeContent = request.getParameter("noticeContent");
		Notice notice = new Notice(noticeSubject, noticeContent);
		NoticeService service = new NoticeService();
		int result = service.insertNotice(notice);
		if(result > 0) {
			response.sendRedirect("/notice/noticeList.do");
		} else {
			request.setAttribute("msg", "작성을 실패했습니다.");
			request.setAttribute("url", "/notice/noticeList.do");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp");
			view.forward(request, response);
			
		}
	}

}
