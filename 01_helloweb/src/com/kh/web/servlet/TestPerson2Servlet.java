package com.kh.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestPerson2Servlet extends HttpServlet {

	public TestPerson2Servlet() {
		super();
		System.out.println("기본생성자 TestPerson2Servlet() 호출!");
	}

	@Override
	public void destroy() {
		System.out.println("destroy() 호출!");
	}

	@Override
	public void init(ServletConfig config) {
		System.out.println("init(ServletConfig) 호출!");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(this.hashCode());

		// 1. 사용자입력값 가져오기
		String name = req.getParameter("name");
		String color = req.getParameter("color");
		String animal = req.getParameter("animal");
		String[] foodArr = req.getParameterValues("food");

		System.out.println("name = " + name);
		System.out.println("color = " + color);
		System.out.println("animal = " + animal);
		System.out.println("foodArr = " + Arrays.toString(foodArr));

		// 2. 응답메세지 작성 : html
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>개취 검사 결과</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>개인 취향 검사 결과 GET</h1>");
		out.println("<p>" + name + "님의 개인취향 검사 결과는 </p>");
		out.println("<p>" + color + "색을 좋아합니다. </p>");
		out.println("<p>좋아하는 동물은 " + animal + "입니다.</p>");
		out.println("<p>좋아하는 음식은 " + Arrays.toString(foodArr) + "입니다. </p>");
		out.println("</body>");
		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 0. encoding 선언
		request.setCharacterEncoding("utf-8");

		// 1. 사용자입력값 변수에 담기
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		String animal = request.getParameter("animal");
		String[] foodArr = request.getParameterValues("food");

		System.out.println("name = " + name);
		System.out.println("color = " + color);
		System.out.println("animal = " + animal);
		System.out.println("foodArr = " + Arrays.toString(foodArr));

		// 2. 업무로직
		String recommendation = "";
		String colorName = "";
		switch (color) {
		case "빨강":
			recommendation = "빨간 짬뽕";
			colorName = "red";
			break;
		case "노랑":
			recommendation = "노란 참외";
			colorName = "yellow";
			break;
		case "초록":
			recommendation = "초록 시금치";
			colorName = "green";
			break;
		case "파랑":
			recommendation = "파랑 파워에이드";
			colorName = "blue";
			break;
		}

		// jsp에 새로 생선된 data를 전달하기 위해 request에 속성으로 저장한다.
		// key:String, value:Object 저장
		request.setAttribute("recommendation", recommendation);
		request.setAttribute("colorName", colorName);

		// 3. html작성을 jsp에 위임.
		// /(슬레시)로 시작한다면, /WebContent에서 조회함.
		RequestDispatcher reqDispatcher = request.getRequestDispatcher("/servlet/testPersonEnd.jsp");
		reqDispatcher.forward(request, response);

		// 3. 응답메세지처리 html
//		response.setContentType("text/html; charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.println("<!DOCTYPE html>");
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<title>개취 검사 결과</title>");		
//		out.println("<style>");
//		out.println(".recommendation { font-size: 2em; color: lime; text-decoration: underline; }");
//		out.println("</style>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<h1>개인 취향 검사 결과 jsp</h1>");
//		out.println("<p>" + name + "님의 개인취향 검사 결과는 </p>");
//		out.println("<p>" + color + "색을 좋아합니다. </p>");
//		out.println("<p>좋아하는 동물은 " + animal + "입니다.</p>");
//		out.println("<p>좋아하는 음식은 " + Arrays.toString(foodArr)+ "입니다. </p>");
//		out.println("<hr>");
//		out.println("<p class='recommendation'>오늘은 " + recommendation + " 어떠세요?</p>");
//		out.println("</body>");
//		out.println("</html>");

	}

}
