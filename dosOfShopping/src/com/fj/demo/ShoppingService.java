package com.fj.demo;

import java.util.*;

import com.fj.data.Data;
import com.fj.data.Goods;

public class ShoppingService {
	//����һ�����ϵ��������ﳵ��  ����Ҳ����ʹ������Ϊ�˷�����ʹ���˼���
	public static List<GiftInfo> list = new LinkedList<GiftInfo>();
	//�������
	public static Scanner scanner = new Scanner(System.in);
	//��ʾ��Ʒ
	public void showGoods(){
		System.out.println("���Ϲ������ϵͳ>�������");
		System.out.println("*************************");
		Goods[] goods = Data.goods;
		System.out.println("��ѡ��Ҫ�������Ʒ���:");
		//ѭ��������ʾ��Ʒ����Ϣ
		for(int i=0;i<goods.length;i++){
			if(goods[i].goodsName!=null){
				System.out.println((i+1)+":"+goods[i].goodsName);
			}
		}
		
		System.out.println("*************************");
	}
	
	//������Ʒ
	public void shopping(){
		//�õ����ǵ���Ʒ��
		Goods[] goods = Data.goods;
		
		System.out.print("�������Ա��:");
		int custNo = scanner.nextInt();
		while(true){
			
			System.out.print("��������Ʒ���:");
			int giftIndex = scanner.nextInt()-1;
			System.out.print("��������Ŀ:");
			int num = scanner.nextInt();
			
			//���빺�ﳵ
			int isPayIdenx = -1;
			for(int i=0;i<list.size();i++){
				//�������Ʒ�Լ�����һ��
				if(giftIndex==list.get(i).giftIndex){
					isPayIdenx = i;
				}
			}
			
			if(isPayIdenx!=-1){
				list.get(isPayIdenx).num+=num;
			}else{
				GiftInfo giftInfo = new GiftInfo(custNo,giftIndex, num );
				list.add(giftInfo);
			}
			
			
			//�Ƿ��˳�
			System.out.print("�Ƿ����(y/n):");
			String flag = scanner.next();
			if(flag.equals("n")){
				break;
			}
		}
		
		
		//����ͳ��
		
		
		//��������嵥
		System.out.println("***********�����嵥***********");
		System.out.println("��Ʒ\t����\t����\t���");
		
		//�ܽ��
		double sum = 0;
		for(GiftInfo gift:list){
			sum+=(gift.num*goods[gift.giftIndex].goodsPrice);
			System.out.println(goods[gift.giftIndex].goodsName
					+"   "+goods[gift.giftIndex].goodsPrice+"Ԫ"
					+"   "+gift.num
					+"   "+(gift.num*goods[gift.giftIndex].goodsPrice)+"Ԫ");
		}
		
		
		System.out.println("�ۿۣ�         "+sale(sum));
		System.out.println("����ܼƣ� "+(sale(sum)*sum)+"Ԫ");
		System.out.print("ʵ�ʽɷѣ� ");
		double payMoney = scanner.nextInt();
		System.out.println("��Ǯ��         "+(payMoney-sale(sum)*sum)+"Ԫ");
		System.out.println("���ι������û��֣�"+(sale(sum)*sum*0.1));
		
		//�����û��Ļ���
		for(int i=0;i<Data.customers.length;i++){
			if(Data.customers[i].custNo == list.get(0).custNo){
				Data.customers[i].custScore =Data.customers[i].custScore+(int) (sale(sum)*sum*0.1); 
			}
		}
		 
	}
	
	//����һ�����۵ķ���
	public double sale(double sum){
		if(sum>=5000){
			return 0.75;
		}else if(sum>=4000){
			return 0.8;
		}else if(sum>=3000){
			return 0.85;
		}else if(sum>=2000){
			return 0.9;
		}else if(sum>=1000){
			return 0.95;
		}else{
			return 1;
		}
	}
}