package com.fj.testservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerificationServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		//�õ��û��������֤��
		String code = request.getParameter("code");
		//�õ������session����֤��
		String relCode = (String) request.getSession().getAttribute("CHECKNUM");
//		System.out.println("session:"+relCode);
//		System.out.println("���ܵ�:"+code);
		//��֤���Ƿ�һ��
		if(relCode.equals(code)){
			request.getRequestDispatcher("/ok.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/Verification.jsp").forward(request, response);
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
