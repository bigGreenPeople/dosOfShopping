package com.dvd.view;
 //ҵ���߼����ʵ��

import java.util.Scanner;

import com.dvd.service.DVDService;
import com.dvd.service.Imp.DVDServiceImp;

public class Menu {
	//ʵ����DVDServiceImp����
	DVDService dsi=new DVDServiceImp();
	//ʵ����Scanner����
	Scanner input=new Scanner(System.in);
	//��ʼ����Ƭ��Ϣ
	public void initial(){
		
	}
	
	//��ʾDvd�˵�
	public void startMenu(){
		System.out.println("	��ӭʹ������DVD������");
		System.out.println("-------------------------------");
		System.out.println("0.������а�");
		System.out.println("1.����DVD");
		System.out.println("2.�鿴DVD");
		System.out.println("3.ɾ��DVD");
		System.out.println("4.���DVD");
		System.out.println("5.�黹DVD");
		System.out.println("6.��         ��");
		System.out.println("-------------------------------");
		System.out.println();
		System.out.print("��ѡ��:");
		String num=input.next();
		switch (num) {
		case "1":
			System.out.print("������Ҫ������DVD������:");
			String aname=input.next();
			dsi.add(aname);    //����DVD
			break;
		case "2":
			dsi.showDVD();    //�鿴DVD������Ϣ
			break;
		case "3":
			System.out.println("������Ҫɾ����DVD������:");
			String dname=input.next();
			dsi.delete(dname);    //ɾ��DVD
			break;
		case "4":
			System.out.print("����������DVD������:");
			String gname=input.next();
			System.out.print("��������DVD������:");
			String gdate=input.next();
			dsi.giveDVD(gname, gdate);    //���DVD
			break;
		case "5":
			System.out.print("������黹��DVD������:");
			String hname=input.next();
			System.out.print("������黹DVD������:");
			String hdate=input.next();
			dsi.getDVD(hname, hdate);    //�黹DVD
			break;
		case "6":
			System.out.println("ллʹ��");  
			System.exit(0);	 //�˳������
			break;
		case "0":
			dsi.showByNum();    //����������
			break;
		default:
			System.out.println("��������������������");
			startMenu();   //������
			break;
		}
	}
	//�������˵�
	public void returnMain() {
		startMenu();
	}

	
}
