package chap03.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirect/test")
public class RedirectServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		
		System.out.println("name: " + name);
		System.out.println("age: " + age);
		
		try {
			int a = Integer.parseInt(age);
			
			// 리다이렉트 주소는 클라이언트 측에서 새로 접속한다고 생각해서 적어야 한다.
			if (a < 10) {
				resp.sendRedirect("/chap03/redirect/a.jsp?user=" + name);
			} else if (a < 20) {
				resp.sendRedirect("/chap03/redirect/b.jsp?user=" + name);
			} else {
				resp.sendRedirect("/chap03/redirect/c.jsp?user=" + name);
			}
		} catch (NumberFormatException e) {
			System.out.println("나이 없이 요청해서 구글로 보내버리겠습니다.");
			resp.sendRedirect("https://google.com");
		}
	}
}
