package com.fj.servlet;
/*
 * ��servlet��һ�α����ʵ�ʱ��ÿ��2s��һ���ʼ�
 * */
public class SendMailThread extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i=0;
		try {
			while(true){
				Thread.sleep(2000);
				System.out.println("������"+i+++"���ʼ�");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//super.run();
	}
}
