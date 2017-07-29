package com.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.domain.User;
import com.sevice.UsersService;

public class MainFrame extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("utf-8");
		
//		�õ��������
		String num=(String) this.getServletContext().getAttribute("num");
		
//		����û��Ƿ�ͨ���˵�½������
		HttpSession session = request.getSession();
		String userId=(String)session.getAttribute("userId");
		if(userId==null){
			request.setAttribute("err", "�������˺����룡");
			request.getRequestDispatcher("/Web-INF/admin/Login.jsp").forward(request, response);
			return;
		}
		
//		����Ĵ����Ƕ�cookie�Ĳ���
		
		String user=request.getParameter("user");
		String pass=request.getParameter("pass");
		String val=request.getParameter("iskeepinfo");
		

//		�û���ѡ�˱��� ����ȥ����cookie
		if(val!=null&&val.equals("keep")){
			Cookie cookie=new Cookie("id", user);
			cookie.setMaxAge(3600*24);
			response.addCookie(cookie);		
		}else{
			Cookie cookie=new Cookie("id", user);
			cookie.setMaxAge(0);
			response.addCookie(cookie);	
		}
		
//		����õ����ǵ�cookie
		Cookie[] cookies=request.getCookies();
		String lastTime="";
//		�Ƿ���ҵ�lastTime
		boolean b=false;
		
		if(cookies!=null)
		{
			for(Cookie cookie:cookies)
			{
				if("lastTime".equals(cookie.getName())){
					lastTime=cookie.getValue();
//					�õ�ת����
					SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//					�õ�ʱ��
					String nowTime=simpleDateFormat.format(new Date());
					cookie=new Cookie("lastTime", nowTime);
//					������������
					cookie.setMaxAge(3600*24);
//					��ӵ�http��Ӧ��
					response.addCookie(cookie);
					//System.out.println(lastTime);
					b=true;
				}
			}
		}
		if(!b)
		{
//			�õ�ת����
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			�õ�ʱ��
			String nowTime=simpleDateFormat.format(new Date());
			Cookie cookie=new Cookie("lastTime", nowTime);
//			������������
			cookie.setMaxAge(3600*24);
//			��ӵ�http��Ӧ��
			response.addCookie(cookie);
		}
		
//		�õ���½���û�
		User u=new UsersService().getUserById(userId);
		
		out.println("<img src='images/Hello.jpg'/><hr/>");
		out.println("<h1>��ӭ&nbsp;"+u.getUsername()+"&nbsp;��½</h1>");
		if(b){
			out.println("���ϴε�½��ʱ���ǣ�"+lastTime);
		}else{
			out.println("��ӭ���״ε�½��");
		}
		out.println("����վ�������"+num+"��");
		out.println("<a href=\"/BBS/index.jsp\">���ص�½����</a></br>");
		out.println("<h1>��ѡ����Ҫ���еĲ���</h1>");
		out.println("<a href=\"/BBS/ManageUsers\">�����û�</a></br>");
		out.println("<a href=\"/BBS/AdddateUser\">����û�</a></br>");
		out.println("<a href=\"/BBS/LookUserView\">�����û�</a></br>");
		out.println("<a href=\"/BBS/index.jsp\">�˳�ϵͳ</a></br>");
		out.println("<hr/><img src='images/wg.jpg'/>");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			this.doGet(request, response);
	}

}
