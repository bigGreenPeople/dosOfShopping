package com.fj.demo;

import java.util.Scanner;

import com.fj.data.*;

public class StartManagement {
	
	public static Scanner input = new Scanner(System.in);//������
	public static Menu menu = new Menu();//�����ӡ�˵�����
	public static Data data = new Data();
	
	public static void main(String[] args) {
		while(true){
			launch();
		}
	}
	
	public static void launch(){
		//��ʼ��data����
				data.init();
				
				//��ӡ����¼����
				menu.printLoginMenu();
				
				//ѡ����Ҫ���еĲ���
				
				int flag = input.nextInt();
				Menu.nextMenu();
				//��������Ա������
				ManagerService managerService = new ManagerService();
				
				//�ж��û�ѡ���ѡ��
				switch (flag) {
				case 1:
					//���е�¼��֤
					System.out.println("����������:");
					if(managerService.checkAdmin(input.next())){
						System.out.println("����ϵͳ");
						mainManagement();
					}else{
						System.out.println("�������!");
						//System.out.println(Manager.loginNum);
						if(Manager.loginNum==3){
							System.out.println("�������3���������ϵͳ�Զ��رգ���������������");
							System.exit(0);;
						}
					}
					
					break;
				case 2:
					//����Ա��������
					System.out.println("�������޸�ǰ����:");
					if(managerService.checkAdmin(input.next())){
						System.out.println("�������޸ĺ�����:");
						managerService.updPass(input.next());
					}else{
						System.out.println("�������!");
					}
					Menu.nextMenu();
					break;
				case 3:
					//�˳�jvm
					Menu.nextMenu();
					System.out.println("лл����ʹ��!ף���������0.0.....");
					System.exit(0);
					break;
				default:
					System.out.println("�����ֵ����");
					break;
				}
	}
	
	//������ϵͳ
	public static void mainManagement(){
		while(true){
			//��ӡϵͳ������
			menu.printMainMenu();
			
			//����ѡ��
			int flag = input.nextInt();
			Menu.nextMenu();
			//�ж�ѡ��ѡ��
			switch (flag) {
			case 1:		
				//����ͻ���Ϣ����
				custManagement();
				
				break;
			case 2:
				//���빺��ϵͳ
				shoppingManagement();
				break;
			case 3:
				//��������ع�
				reviewManagement();
				break;
			case 4:
				//�˳�ϵͳ  �����˳�����
				return;
			default:
				System.out.println("�����ֵ����");
				break;
			}
		}
	}
	
	//�ͻ���Ϣ����ϵͳ
	public static void custManagement(){
		while(true){
			//��ӡ�ͻ��������
			menu.printCustManageMenu();
			//�����û������� 
			CustService custService = new CustService();
			
			//�����û���ѡ��
			String flag = input.next();
			Menu.nextMenu();
			//�ж��û���ѡ��
			switch (flag) {
			case "1":
				//��ʾ����
				custService.showCust();
				break;
			case "2":
				//���
				if(custService.addCust()){
					System.out.println("��ӳɹ���");
				}else{
					System.out.println("���ʧ��!");
				}
				Menu.nextMenu();
				break;
			case "3":
				//�޸�
				if(custService.updCust()){
					System.out.println("�޸ĳɹ���");
				}else{
					System.out.println("�޸�ʧ��!");
				}
				Menu.nextMenu();
				break;
			case "4":
				//��ѯ
				while(true){
					custService.findCustById();
					System.out.print("Ҫ������ѯ��(y/n):");
					if("n".equals(input.next())){
						break;
					}
				}
				Menu.nextMenu();
				break;
			case "n":
				//������һ��
				return;
			default:
				System.out.println("�����ֵ����");
				break;
			}
		}
	}
	
	//�������ϵͳ
	public static void shoppingManagement(){
		//����shoppingservice
		ShoppingService shoppingService = new ShoppingService();
		
		//��ӡ��Ʒ��Ϣ
		shoppingService.showGoods();
		
		//������Ʒ
		shoppingService.shopping();
		
		System.out.print("�س���������һ��......");
		input.nextLine();
		Menu.nextMenu();
	}
	
	//����ع�ϵͳ
	public static void reviewManagement(){
		while(true){
			//����luckservic
			LuckService luckService = new LuckService();
			//��ӡ����ع˽���
			menu.printReviewManageMenu();
			//����ѡ�����
			String flag = input.next();
			menu.nextMenu();
			//�ж�
			switch (flag) {
			case "1":
				//���˴����
				luckService.giveGift();
				break;
			case "2":
				//���˳齱
				luckService.luckDraw();
				break;
			case "3":
				//�����ʺ�
				luckService.birthdayGreetings();
				menu.nextMenu();
				break;
			case "n":
				//������һ��
				return;
			default:
				System.out.println("�����ֵ����");
				menu.nextMenu();
				break;
			}
		}
		
	}
}
