package com.fj.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResourceServlet extends HttpServlet {



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		//getResourceAsStream�����ڷ���this.getServletContext()(Ҳ���ǵ�ǰwebӦ�õ�·��)
//		·�����µ�222.txt�ļ�
		//InputStream resourceAsStream = this.getServletContext().getResourceAsStream("222.txt");
		
		//�������srcĿ¼������Ӧ������ȥ�����
		//��ȥ��õ�ǰ����������  �ڴ����������·����ȥ��111.txt
		InputStream resourceAsStream = ResourceServlet.class.getClassLoader().getResourceAsStream("111.txt");
		
		//���һ��web�ļ���ȫ·��
		String path = this.getServletContext().getRealPath("222.txt");
		System.out.println("ȫ·��:"+path);
		
		//byte����������
		byte[] buf = new byte[1024];
		resourceAsStream.read(buf);
		System.out.println(new String(buf));
		System.out.println("��ȡ�ɹ�");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
