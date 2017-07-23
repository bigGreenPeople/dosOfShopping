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
		//response.setHeader("Content-Type", "application/force-download");
		response.setHeader("Content-Disposition", "attachment; filename=winter.java");
		
		//�õ�·��
		String path = request.getServletContext().getRealPath("/img/TestPosition.java");
		//������ 
		FileInputStream fis = new FileInputStream(path);
		BufferedInputStream bis = new BufferedInputStream(fis);
		//������������
		byte[] buff = new byte[1024];
		int len = bis.read(buff);
		
		while(len!=-1){
			//����һ��Ҫָ��д��ĳ��Ȳ�Ȼ�������ǰ���ı�
			out.write(buff, 0, len);
			len = bis.read(buff);
		}
		//out.write(buff);
		
		out.flush();
		out.close();
		bis.close();
		fis.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
