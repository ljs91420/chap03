package chap03.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user_id = req.getParameter("user_id");
		String user_password = req.getParameter("user_password");
		
		System.out.println("user_id: " + user_id);
		System.out.println("user_password: " + user_password);
		
		if (user_id != null && user_id.equals("testuser") && user_password != null && user_password.equals("4321")) {
			System.out.println("로그인 성공!");
			
			// 요청 객체를 통해 세션 객체를 호출할 수 있다.
			HttpSession session = req.getSession();
			
			// 세션 객체에도 setAttribute()를 통해 데이터를 실어놓을 수 있다.
			session.setAttribute("login", true);
		} else {
			System.out.println("로그인 실패!");
		}
		
		resp.sendRedirect("/chap03/attribute/sample/loginResultPage.jsp");
	}
}
