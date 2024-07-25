package chap03.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/employee/detail")
public class EmpDeailServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파라미터로 사원번호를 받아 DB에서 사원정보를 받아왔다고 가정
		String emp_id = req.getParameter("emp_id");
		
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String sql = "SELECT * FROM employees WHERE employee_id = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try (
			Connection conn = DriverManager.getConnection(url, "hr", "1234");
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setInt(1, Integer.parseInt(emp_id));
			
			try (ResultSet rs = pstmt.executeQuery()) {
				rs.next();
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				
				System.out.printf("%s %s\n", first_name, last_name);
				
				// 꺼낸 데이터를 요청 객체의 어트리뷰트에 실어놓는다.(name, value)
				req.setAttribute("first_name", first_name);
				req.setAttribute("last_name", last_name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 화면을 구성하는 코드를 마저 작성하기 위해 JSP페이지로 포워드를 할 때, 여기서 꺼낸 회원 정보가 필요할 수 있다.
		req.getRequestDispatcher("/attribute/sample/requestAttrView.jsp").forward(req, resp);
	}
}
