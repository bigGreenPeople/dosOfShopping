package com.fj.test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fj.MD5.MD5;

public class CreateCookie extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter pw = response.getWriter();
		//md5����
		//���cookieҪ������ĵ�ʱ��ʹ��URLEncoder����    Ȼ��ȡֵ��ʱ��URLDecoder�����OK��
		//Cookie cookie = new Cookie("username", MD5.MD5("fujie"));
		//������ǰʱ��
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = simpleDateFormat.format(new Date());
		System.out.println(time);
		
		//����һ����־�����һ�ε���Ͳ�����cookie
		boolean b=true;
		//ȡ��cookie
		Cookie[] cookies = request.getCookies();
		//�������ǵ�lasttime
		if(cookies!=null){
			for(Cookie c:cookies){
				if(c.getName().equals("lastTime")){
					//��ӡ�������������ʱ��
					pw.println(c.getValue());
					b = false;
				}
			}
		}
		if(b){
			pw.print("���ǵ�һ�ε��� ");
		}
		
		Cookie cookie = new Cookie("lastTime", time);
		cookie.setMaxAge(3000);
		response.addCookie(cookie);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
