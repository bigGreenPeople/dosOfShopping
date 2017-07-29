package com.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.User;

public class LookUserView extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
//		js����
		out.println("<script type='text/javascript'>");
		out.println("function look(){var e=document.getElementById('username').value; window.open('/BBS/UserClServlet?type=look&name='+e,'_self');}");
		out.println("</script>");
		//�õ���ѯ�������
		ArrayList<User> al=(ArrayList)request.getAttribute("al");
		

		out.println("<img src='images/Hello.jpg'/><hr/><a href='/BBS/MainFrame'>����������</a>"+"   "+"<a href='/BBS/Login'>��ȫ�˳�</a>");
		out.println("<h2>�����û�</h2>");
		out.println("<br/><input id='username' type='text' size='10'/><input type='button' onclick='look()' value='����'/>");
		
		if(al!=null){
	//		��ʾ������
			out.println("<table border='1px' width='600' bordercolor='red' cellspacing=0>");
			out.println("<tr><th>�û�ID</th><th>�û���</th><th>��������</th><th>Ȩ�޵ȼ�</th><th>�û�����</th><th>ɾ���û�</th><th>�޸��û�</th></tr>");
			for(User u:al)
			{
				out.println("<tr>"
						+ "<td>"+u.getId()+"</td>"
						+ "<td>"+u.getUsername()+"</td>"
						+ "<td>"+u.getEmail()+"</td>"
						+ "<td>"+u.getGrade()+"</td>"
						+ "<td>"+u.getPasswd()+"</td>"
						+ "<td><a onclick='return confirmOper()' href='/BBS/UserClServlet?type=del&id="+u.getId()+"'>ɾ���û�</a></td>"
						+ "<td><a href='/BBS/UserClServlet?type=gotoUpdView&id="+u.getId()+"'>�޸��û�</a></td>"
						+"</tr>");
			}
			out.println("</table>");
		}
		out.println("<hr/><img src='images/wg.jpg'/>");
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
