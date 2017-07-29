package com.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.User;
import com.sevice.UsersService;

public class ManageUsers extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
//		���������ǵ�js����
		out.println("<script type='text/javascript'>");
		out.println("function jmp(){var e=document.getElementById('pageNow').value; window.open('/BBS/ManageUsers?page='+e,'_self');}");
		out.println("function confirmOper(){return window.confirm('ȷ��ɾ�����û�');}");
		out.println("</script>");
		
		int pageNow=1;//��ǰҳ
		String tempPageNow=request.getParameter("page");
		if(tempPageNow!=null)
		{
			pageNow=Integer.parseInt(tempPageNow);
		}
		int pageSize=3;//ָ��ÿҳ��ʾ3����¼
		int pageCount=1;//ҳ��������
		int rowCount=1;//��¼������
		
			
//			����һ��User������
			UsersService us=new UsersService();
//			�õ���Ҫ������
			ArrayList<User> al=us.getUsersByPage(pageNow, pageSize);
			
//			��ʾҳ��
			out.println("<img src='images/Hello.jpg'/><hr/>��ӭXX��½   <a href='/BBS/MainFrame'>����������</a>"+"   "+"<a href='/BBS/Login'>��ȫ�˳�</a>");
			out.println("<h2>�����û�</h2>");
//			��ʾ������
			out.println("<table border='1px' width='600' bordercolor='red' cellspacing=0>");
			out.println("<tr><th>�û�ID</th><th>�û���</th><th>��������</th><th>Ȩ�޵ȼ�</th><th>�û�����</th><th>ɾ���û�</th><th>�޸��û�</th></tr>");
//			��ʾ��ҳ������
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
			
//			�õ��ܼ�¼��
			rowCount=us.getPageCount(pageSize);
//			�����ҳ�� 
			pageCount=((rowCount%pageSize)==0)?rowCount/pageSize:(rowCount/pageSize)+1;
//			��ʾ��һҳ��ǩ
			if(pageNow!=1)
			{
				out.println("<a href='/BBS/ManageUsers?page="+(pageNow-1)+"'>��һҳ</a>");
			}
//			��ʾҳ��
			for(int i=1;i<=pageCount;i++)
			{
				out.println("<a href='/BBS/ManageUsers?page="+i+"'><"+i+"></a>");
			}
//			��ʾ��һҳ��ǩ			
			if(pageNow!=pageCount)
			{
				out.println("<a href='/BBS/ManageUsers?page="+(pageNow+1)+"'>��һҳ</a>");
			}
			out.println("  &nbsp;&nbsp;  ��ǰҳ:"+pageNow+"/��ҳ��:"+pageCount);
			out.println("<br/><input id='pageNow' type='text' size='10'/><input type='button' onclick='jmp()' value='��ת'/>");
			out.println("<hr/><img src='images/wg.jpg'/>");
		
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
