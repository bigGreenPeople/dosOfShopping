package com.dvd.view;

import com.dvd.DB.DVDMgr;

public class Start {

	public static void main(String[] args) {
		//��ʼ������
		DVDMgr.init();
		//ʵ��������
		Menu dvdMgr=new Menu();
		//����ѭ��
		while(true){
		dvdMgr.startMenu();   //������
		}
	}

}
