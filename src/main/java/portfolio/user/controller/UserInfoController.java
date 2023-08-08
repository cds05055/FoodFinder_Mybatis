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
 * Servlet implementation class UserInfoController
 */
@WebServlet("/user/info.do")
public class UserInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/user/userInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("user-id");
		String userPw = request.getParameter("user-pw-new");
		String userNickname = request.getParameter("user-nickname");
		String userName = request.getParameter("user-name");
		String userPhone = request.getParameter("user-phone");
		UserService service = new UserService();
		User user = new User(userId, userPw, userNickname, userName, userPhone);
		int result = service.modifyUser(user);
		if(result > 0) {
			response.sendRedirect("/index.jsp");
		} else {
			request.setAttribute("msg", "수정에 실패하였습니다. 다시 시도해주세요.");
			request.setAttribute("url", "/user/info.do");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp");
			view.forward(request, response);
		}
	}

}
