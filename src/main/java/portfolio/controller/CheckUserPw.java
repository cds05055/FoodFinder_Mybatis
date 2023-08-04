package portfolio.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import portfolio.model.service.UserService;
import portfolio.model.vo.User;

/**
 * Servlet implementation class CheckUserPw
 */
@WebServlet("/user/checkPw.do")
public class CheckUserPw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUserPw() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		UserService service = new UserService();
//		// DELETE FROM USER_TBL WHERE USER_ID = ?
//		String ckUserPw = request.getParameter("quit-pw");
//		System.out.println(ckUserPw);
//		User uOne = service.checkUserByPw(ckUserPw);
//		
//		if(uOne != null) {
//			request.setAttribute("msg", "회원탈퇴가 완료되었습니다. 이용해주셔서 감사합니다.");
//			request.setAttribute("url", "/index.jsp");
//			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/serviceSuccess.jsp");
//			view.forward(request, response);
//		} else {
//			request.setAttribute("msg", "회원탈퇴에 실패하였습니다. 다시 시도해주세요.");
//			request.setAttribute("url", "/user/changOption.do");
//			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp");
//			view.forward(request, response);
//		}
		
	}

}
