package com.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdddateUser extends HttpServlet {

	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		
		out.println("<img src='images/Hello.jpg'/><hr/><a href='/BBS/MainFrame'>����������</a>"+"   "+"<a href='/BBS/Login'>��ȫ�˳�</a>");
		out.println("<h2>����û�</h2>");
		
//		��ʾ�û���Ϣ
		out.println("<form action='/BBS/UserClServlet?type=add' method='post'>");
		out.println("<table border='1px' width='228' bordercolor='red' cellspacing=0>");
		//out.println("<tr><td>�û�ID</td><td><input readonly type='text' name='id' value='"+u.getId()+"'/></td></tr>");
		out.println("<tr><td>�û�����</td><td><input type='text' name='username'/></td></tr>");
		out.println("<tr><td>��������</td><td><input type='text' name='email'/></td></tr>");
		out.println("<tr><td>�û��ȼ�</td><td><input type='text' name='grade'/></td></tr>");
		out.println("<tr><td>�û�����</td><td><input type='text' name='passwd'/></td></tr>");
		out.println("</table>");
		out.println("<input type='submit' value='�����Ϣ'/><input type='reset' value='������Ϣ'/>");
		out.println("</form>");
		
		out.println("<hr/><img src='images/wg.jpg'/>");
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
