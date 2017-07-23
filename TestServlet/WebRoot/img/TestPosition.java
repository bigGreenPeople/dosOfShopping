package com.fj.servlet;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestPosition extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		OutputStream out = response.getOutputStream();
		//����������Ϣͷ
		response.setHeader("Content-Disposition", "attachment; filename=winter.jpg");
		
		//�õ�·��
		String path = request.getServletContext().getRealPath("/fujie.text");
		//������ 
		FileInputStream fis = new FileInputStream(path);
		BufferedInputStream bis = new BufferedInputStream(fis);
		//������������
		byte[] buff = new byte[1024];
		int len = 0;
		while((len=bis.read(buff))>0){
			out.write(buff);
		}
		bis.close();
		fis.close();
		
		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
