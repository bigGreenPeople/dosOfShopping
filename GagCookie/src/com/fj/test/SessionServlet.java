package com.fj.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		//�õ�session
		HttpSession session = request.getSession();
		//��session�������ֵ
		session.setAttribute("name", "����");
		
		//�������ת	�ڽ���cookie����Ȼ�ܹ�ʹ��session��ֵ
		//�����ʵ�����ں������JSESSIONID=...����cookie������Ҳ����ȡ��JSESSIONID��
		//encodeURL()�Ǳ�Ӧ�ü���ģ�encodeRedirectURL()�ǿ�Ӧ�õ�
		String url = response.encodeRedirectURL("/GagCookie/GetSession");
		response.sendRedirect(url);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
