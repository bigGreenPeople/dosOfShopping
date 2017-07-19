package com.fj.demo;

import java.util.Scanner;

import com.fj.data.Data;
import com.fj.data.Goods;

/*
 * �����Ҫ����齱��ҵ���߼�
 * */
public class LuckService {
	Scanner scanner = new Scanner(System.in);
	//���˴���͵ķ���
	public void giveGift(){
		System.out.println("���Ϲ������ϵͳ>����ع�>���˴����");
		System.out.println();
		//�ҳ�������ߵĻ�Ա����ӡ
		int maxIndex = -1;
		int maxScore = 0;
		for(int i=0;i<Data.customers.length;i++){
			if(Data.customers[i].custScore>maxScore){
				maxScore = Data.customers[i].custScore;
				maxIndex = i;
			}
			if(Data.customers[i].custNo == 0){
				break;
			}	
		}
		//��ӡ��߻��ֵĻ�Ա��Ϣ
		if(maxIndex!=-1){
			System.out.println("������߻��ֵĻ�Ա�ǣ�"+Data.customers[maxIndex].custNo+"   "+Data.customers[maxIndex].custBirth+"   "+Data.customers[maxIndex].custScore);
		}
		
		System.out.println("��ϲ��������Ʒ��һ����ֵ12000.0Ԫ��ƻ���ʼǱ�����");
		System.out.println();
		System.out.print("�س�������......");
		scanner.nextLine();
		Menu.nextMenu();
	}
	
	//���˳齱����
	public void luckDraw(){
		System.out.println("���Ϲ������ϵͳ>����ع�>���˳齱");
		System.out.println();
		System.out.print("�Ƿ�ʼ(y/n):");
		String flag = scanner.nextLine();
		
		if(flag.equals("y")){
			//�������Ԫ�ص�����±�
			int maxIndex = -1;
			for(int i=0;i<Data.customers.length;i++){
				if(Data.customers[i].custNo == 0){
					maxIndex = i-1;
					break;
				}
			}
			
			//����һ��0��maxIndex�������	
			int index = (int) (Math.random()*maxIndex);
			System.out.println();
			System.out.println("�����û�����MP3��"+Data.customers[index].custNo);
			System.out.println();
			System.out.print("�س�������......");
			scanner.nextLine();
		}else if(flag.equals("n")){
			return;
		}else{
			System.out.println("�����ֵ����");
		}
	}
	
	//�����ʺ�
	public void birthdayGreetings(){
		System.out.println("���Ϲ������ϵͳ>����ع�>�����ʺ�");
		System.out.println();
		
		System.out.print("��������������(��/��<����λ����ʾ>):");
		String nowDate = scanner.next();
		//�ҵ�������nowDate����
		int index = -1;
		for(int i=0;i<Data.customers.length;i++){
			if(Data.customers[i].custNo == 0){
				break;
			}
			if(Data.customers[i].custBirth.equals(nowDate)){
				index = i;
				break;
			}
		}
		if(index!=-1){
			System.out.println("�����յĻ�Ա��:"+Data.customers[index].custNo);
			System.out.println("��ϲ������mp3һ����	");
		}else{
			System.out.println("����û�˹����� !");
		}
		System.out.println();
		System.out.println("�س�������......");
		scanner.nextLine();
		
	}
}
