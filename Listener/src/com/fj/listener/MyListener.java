package com.fj.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyListener implements HttpSessionListener {
	//��վ���ʼ���
	private int userNumber;
	
	//����������tomcat������ʱ�򴴽�
	public MyListener() {
		// TODO Auto-generated constructor stub
		System.out.println("����������");
	}
	
	//session������ʱ�򴥷�
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		userNumber++;
		arg0.getSession().setAttribute("userNumber", userNumber);
	}
	//session�رյ�ʱ�򴥷�
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
