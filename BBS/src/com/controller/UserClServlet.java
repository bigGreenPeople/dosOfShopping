package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.User;
import com.sevice.UsersService;

public class UserClServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
//		�õ�user������
		UsersService us=new UsersService();
		
//		�õ��û����������� 
		String type=request.getParameter("type");
//		ɾ��
		if("del".equals(type)){
			String id=request.getParameter("id");
			if(us.delUser(id))
			{
				request.getRequestDispatcher("/OK").forward(request, response);
			}else{
				request.getRequestDispatcher("/Err").forward(request, response);
			}
		}else if("gotoUpdView".equals(type)){	//��ת���޸Ľ���
			String id=request.getParameter("id");
//			ͨ��һ��id�õ��û�
			User u=us.getUserById(id);
			request.setAttribute("user", u);
//			��תҳ��
			request.getRequestDispatcher("/UpdateUserView").forward(request, response);
		}else if("upd".equals(type)){
			String id=request.getParameter("id");
			String username=request.getParameter("username");
			String email=request.getParameter("email");
			String grade=request.getParameter("grade");
			String passwd=request.getParameter("passwd");
			
//			���ж��η�װ
			User u=new User(Integer.parseInt(id), username, email, Integer.parseInt(grade), passwd);
			//request.setAttribute("user", u);
			
			if(us.updUser(u))
			{
				request.getRequestDispatcher("/OK").forward(request, response);
			}else{
				request.getRequestDispatcher("/Err").forward(request, response);
			}
		}else if("gotoAddUser".equals(type)){	//��ת����ӽ���
			request.getRequestDispatcher("/AdddateUser").forward(request, response);
		}else if("add".equals(type)){
			String username=request.getParameter("username");
			String email=request.getParameter("email");
			String grade=request.getParameter("grade");
			String passwd=request.getParameter("passwd");
			int id=-1;
//			���ж��η�װ
			User u=new User(id, username, email, Integer.parseInt(grade), passwd);
			
			if(us.addUser(u))
			{
				request.getRequestDispatcher("/OK").forward(request, response);
			}else{
				request.getRequestDispatcher("/Err").forward(request, response);
			}
		}else if("gotoLookView".equals(type)){	//��ת����ѯ����
			request.getRequestDispatcher("/LookUserView").forward(request, response);
		}else if("look".equals(type)){
			request.setCharacterEncoding("utf-8");
			String name=request.getParameter("name");
			System.out.println("����"+name);
//			�õ������
			ArrayList<User> al=us.getUserByNames(name);
			request.setAttribute("al", al);
			request.getRequestDispatcher("/LookUserView").forward(request, response);

					
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
