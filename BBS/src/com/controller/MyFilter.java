package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpRetryException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyFilter extends HttpServlet implements Filter {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}


	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
//		��ServletRequestת��Ϊ���ǵ�HttpServletRequest
		HttpServletRequest httpServletRequest=(HttpServletRequest) request;
//		����������Դ
		String url=httpServletRequest.getRequestURI();
		
//		����û�ֱ�ӷ��ʵ��ǵ�½����ͷ���
		if(url.startsWith("/BBS/Login")||url.startsWith("/BBS/CreateCode")||url.startsWith("/BBS/WEB-INF/admin/Login.jsp"))
		{
			chain.doFilter(request, response);
		}else{
//			�õ�Session
			HttpSession httpSession=httpServletRequest.getSession();
			String user=(String) httpSession.getAttribute("userId");
			
			if(user!=null)
			{
				chain.doFilter(request, response);
			}else{
				request.setAttribute("err", "��úõ�½");
//				��ת����½����
				httpServletRequest.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}
	}


	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
