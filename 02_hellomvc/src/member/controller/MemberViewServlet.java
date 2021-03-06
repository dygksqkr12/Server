package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.vo.Member;

/**
 * Servlet implementation class MemberViewServlet
 */
@WebServlet("/member/memberView")
public class MemberViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//1. 업무로직 : 회원객체 가져오기
//		HttpSession session = request.getSession();
//		Member member = null;
//		if(session != null) 
//			member = (Member)session.getAttribute("loginMember");
//		if(member == null) {
//			session.setAttribute("msg", "로그인후 사용할 수 있습니다.");
//			response.sendRedirect(request.getContextPath());
//			return;
//		}
		
		//2. jsp 위임처리
		request.getRequestDispatcher("/WEB-INF/views/member/memberView.jsp")
			   .forward(request, response);
		
	}

}