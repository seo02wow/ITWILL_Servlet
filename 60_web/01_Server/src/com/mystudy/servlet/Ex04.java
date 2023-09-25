package com.mystudy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



// 서블릿 상속 확장 -> 서블릿 
@WebServlet("/signup")
public class Ex04 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println(">> Ex04.doGet() 실행 ~ ");
		
		// request 객체로부터 파라미터 값 추출
		// request.getParameter("파라미터명") : 1개의 파라미터 값 추출(확인)
		// request.getParameterValues("파라미터명") : 동일 이름의 여러 개 데이터 추출 시 사용(배열 리턴)
		// request.getParameterMap() : 파라미터 데이터 Map 형태로 받기 
		// request.getParameterNames() : 파라미터명 확인(추출)
		
		// 전달받은 데이터 추출 후 응답처리 
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String pwd2 = request.getParameter("pwd2");
		String email = request.getParameter("email");
		
		// 체크박스
		// checkbox 선택 안 할 경우 null
		// checkbox 데이터가 여러 개일 경우 첫번째 데이터 가져옴 
		//String hobby = request.getParameter("hobby");
		
		// 취미(hobby - checkbox) 값 추출 
		// 똑같은 파라미터명의 데이터가 여러 개일 경우 -> 배열 객체 리턴 받기 
		String[] hobby = request.getParameterValues("hobby");
		
		// 서버 콘솔에 값 출력 
		System.out.println("---------------------");
		System.out.println(">> name : " + name);
		System.out.println(">> id : " + id);
		System.out.println(">> pwd : " + pwd);
		System.out.println(">> email : " + email);
		
		System.out.println("> hobby 확인 : " + Arrays.toString(hobby));
		
		//=======================
		// 클라이언트(브라우저) 쪽으로 응답 처리 
		// 응답데이터 한글 깨짐 방지를 위한 문자셋 설정
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h2>회원가입 정보</h2>");
		out.println("<ul>");
		out.println("<li>이름 : " + name + "</li>");
		out.println("<li>아이디 : " + id + "</li>");
		out.println("<li>암호 : " + pwd + "</li>");
		out.println("<li>이메일 : " + email + "</li>");
		
		// 선택된 취미 정보
		out.println("<li> 취미 : ");
		if (hobby == null) { //checkbox 선택 안 할 경우 
			out.write("선택 안 함");
		} else {
			for (String str : hobby) {
				out.write(str + "&nbsp;&nbsp;");
			}
		}
		out.println("</li>");
		out.println("</ul>");
		
	}
	
	
}
