package com.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateCode extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		//PrintWriter out = response.getWriter();
		// 7.��ֹ������������ͼƬ
				response.setDateHeader("Expires", -1);
				response.setHeader("Cache-Control", "no-cache");
				response.setHeader("Pragma", "no-cache");
				// 6.֪ͨ�ͻ�����ͼƬ��ʽ�򿪷��͹�ȥ������
				response.setHeader("Content-Type", "image/jpeg");
				// 1.���ڴ��д���һ��ͼƬ
				BufferedImage image = new BufferedImage(50, 28,
						BufferedImage.TYPE_INT_RGB);
				// 2.��ͼƬ��д����
				Graphics g = image.getGraphics();
				// �豳��ɫ
				g.setColor(Color.BLACK);
				g.fillRect(0, 0, 50, 28);
				// 3.����д�����ݵ���ɫ������
				g.setColor(Color.RED);
				g.setFont(new Font(null, Font.BOLD, 20));
				// 4.��ͼƬ��д����
				String num = makeNum();
				//��仰���ǰ�������ɵ���ֵ�����浽session��
		//ͨ��session�Ϳ���ֱ��ȥ���漴���ɵ���֤����
				request.getSession().setAttribute("checkcode", num);	
				g.drawString(num, 0, 20);
				// 5.��д�����ݵ�ͼƬ����������
				ImageIO.write(image, "jpg", response.getOutputStream());
		}
			//�ú���ʱ�������7λ����
			public String makeNum() {
				Random r = new Random();
				//9999999 ��������7λ
				String num = r.nextInt(9999) + ""; 
				StringBuffer sb = new StringBuffer();
				//�������4λ��ǰ�油��
				for (int i = 0; i < 4 - num.length(); i++) {
					sb.append("0");
				}
				num = sb.toString() + num;
				return num;

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
