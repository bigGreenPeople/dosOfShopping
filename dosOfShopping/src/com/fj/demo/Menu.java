package com.fj.demo;
/*
 * ����������ڴ�ӡ�˵�����Ϣ
 * */
public class Menu {
	//��ӡ����¼����
	public void printLoginMenu(){
		System.out.println("\t��ӭʹ�ý��Ϲ������ϵͳ1.0��");
		System.out.println("***********************************");
		System.out.println("1.��¼ϵͳ");
		System.out.println("2.����Ա��������");
		System.out.println("3.�˳�");
		System.out.println("***********************************");
		System.out.println("ѡ����Ҫ���еĲ���:");
	}
	
	//��ӡϵͳ������
	public void printMainMenu(){
		System.out.println("\t��ӭʹ�ý��Ϲ������ϵͳ");
		System.out.println("***********************************");
		System.out.println("1.�ͻ���Ϣ����");
		System.out.println("2.�������");
		System.out.println("3.����ع�");
		System.out.println("4.ע��");
		System.out.println("***********************************");
		System.out.println("ѡ����Ҫ���еĲ���:");
	}
	
	//��ӡ�ͻ���Ϣ�������
	public void printCustManageMenu(){
		System.out.println("���Ϲ������ϵͳ>�ͻ�������Ϣ>��ʾ�ͻ���Ϣ");
		System.out.println("***********************************");
		System.out.println("1.��ʾ�����û���Ϣ");
		System.out.println("2.��ӿͻ���Ϣ");
		System.out.println("3.�޸Ŀͻ���Ϣ");
		System.out.println("4.��ѯ�ͻ���Ϣ");
		System.out.println("***********************************");
		System.out.println("ѡ����Ҫ���еĲ�����'n'������һ��:");
	}
	
	//��ӡ����ع˵Ĺ������
	public void printReviewManageMenu(){
		System.out.println("���Ϲ������ϵͳ>����ع�");
		System.out.println("***********************************");
		System.out.println("1.���˴����");
		System.out.println("2.���˳齱");
		System.out.println("3.�����ʺ�");
		System.out.println("***********************************");
		System.out.println("ѡ����Ҫ���еĲ�����'n'������һ��:");
	}
	
	//��ӡ3�лس�
	public static void nextMenu(){
		for(int i=0;i<3;i++){
			System.out.println();
		}
	}
	
}
