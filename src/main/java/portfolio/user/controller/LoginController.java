package portfolio.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import portfolio.user.model.service.UserService;
import portfolio.user.model.vo.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/user/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/user/loginForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("user-id");
		String userPw = request.getParameter("user-pw");
		User user = new User(userId, userPw);
		
		// SELECT * FROM USER_TBL WHERE USER_ID = ? AND USER_PW = ?
		UserService service = new UserService();
		User uOne = service.selectCheckLogin(user);
		if(uOne != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", uOne.getUserId());
			session.setAttribute("userNickname", uOne.getUserNickname());
			session.setAttribute("userName", uOne.getUserName());
			session.setAttribute("userPhone", uOne.getUserPhone());
			
			request.setAttribute("msg", "로그인 성공!");
			request.setAttribute("url", "/index.jsp");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/serviceSuccess.jsp");
			view.forward(request, response);
		} else {
			request.setAttribute("msg", "로그인 실패 : 아이디 또는 비밀번호가 다르거나 등록되지 않은 아이디 입니다.");
			request.setAttribute("url", "/user/login.do");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp");
			view.forward(request, response);
//			response.sendRedirect("/user/login.do");
		}
	}

}
