package com.fj.demo;

import java.util.Random;
import java.util.Scanner;

public class Demo1 {
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		while(true){
			f();
		}
		
	}
	
	public static void f(){
		System.out.print("�������������:");
		int flag = scanner.nextInt();
		Random random = new Random();
		
		switch (flag) {
		case 1:
			int i = random.nextInt(3);
			if(i==flag)
				System.out.println("��ϲ�����һ��ϴ����");
			else
				System.out.println("ʲô��û�У�����");
			break;
		case 2:
			int i2 = random.nextInt(3);
			if(i2==flag)
				System.out.println("��ϲ�����һ������");
			else
				System.out.println("ʲô��û�У�����");
			break;
		case 3:
			int i3 = random.nextInt(3);
			if(i3==flag)
				System.out.println("��ϲ�����һ������");
			else
				System.out.println("ʲô��û�У�����");
			break;
		default:
			System.out.println("��������");
			break;
		}
	}

}
