package portfolio.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import portfolio.model.service.UserService;
import portfolio.model.vo.User;

/**
 * Servlet implementation class UserChangeOption
 */
@WebServlet("/user/changOption.do")
public class deleteUsetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteUsetController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService service = new UserService();
		String userId = request.getParameter("userId");
		User user = service.selectOneById(userId);
		HttpSession session = request.getSession();
		session.setAttribute("userId", user.getUserId());
		request.getRequestDispatcher("/WEB-INF/views/user/userOptionChange.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("quit-id");
		String userPw = request.getParameter("quit-pw");
		User user = new User(userId, userPw);
		UserService service = new UserService();
		User uOne = service.selectCheckLogin(user);
		if(uOne != null) {
			int result = service.deleteUser(uOne);
			if(result > 0 ) {
				request.setAttribute("msg", "회원탈퇴를 성공했습니다. 이용해주셔서 감사합니다.");
				request.setAttribute("url", "/user/logout.do");
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/serviceSuccess.jsp");
				view.forward(request, response);
			} else {
				request.setAttribute("msg", "회원탈퇴에 실패하였습니다. 다시 시도해주세요.");
				request.setAttribute("url", "/index.jsp");
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp");
				view.forward(request, response);
			}
		} else {
			request.setAttribute("msg", "회원 정보 찾기 실패 : 입력하신 비밀번호가 다릅니다.");
			request.setAttribute("url", "/user/changOption.do");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp");
			view.forward(request, response);
		}
	}

}
