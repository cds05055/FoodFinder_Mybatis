package portfolio.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import portfolio.user.model.service.UserService;
import portfolio.user.model.vo.User;

/**
 * Servlet implementation class UserEnrollController
 */
@WebServlet("/user/register.do")
public class UserInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/user/enrollForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("user-id");
		String userPw = request.getParameter("user-pw");
		String userNickname = request.getParameter("user-nickname");
		String userName = request.getParameter("user-name");
		int userAge = Integer.parseInt(request.getParameter("user-age"));
		String userGender = request.getParameter("user-gender");
		String userPhone = request.getParameter("user-phone");
		User user = new User(userId, userPw, userNickname, userName, userAge, userGender, userPhone);
		
		UserService service = new UserService();
		int result = service.insertUser(user);
		
		if(result > 0) {
			request.setAttribute("msg", "회원가입을 성공하셨습니다! 로그인 해주세요!");
			request.setAttribute("url", "/user/logout.do");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/serviceSuccess.jsp");
			view.forward(request, response);
		} else {
			request.setAttribute("msg", "회원가입에 실패하였습니다. 다시 시도해주세요.");
			request.setAttribute("url", "/user/register.do");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp");
			view.forward(request, response);
		}
	}

}
