package com.fj.test;
/*
 * �����߳�
 * */
public class TestThread {
	//һ��100�ſ�Ƭ
	public static int card = 100;
	public static B b = new B();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��������
		People1 p1 = new People1();
		People2 p2 = new People2();
		
		Thread thread1 = new Thread(p1);
		Thread thread2 = new Thread(p2);
		
		//���������߳�
		thread1.start();
		thread2.start();
		
			
	}

}

class People1 implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
			while(true){
				synchronized(TestThread.b){
					System.out.println("p1�����������ߵ�"+TestThread.card+"�ſ�Ƭ");
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					TestThread.card--;
	
					if(TestThread.card<0){
						break;
					}
				
			}
		}
		
		
	}
	
}

class People2 implements Runnable{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
				while(true){
					synchronized(TestThread.b){
						System.out.println("p2�����������ߵ�"+TestThread.card+"�ſ�Ƭ");
						TestThread.card--;
						
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if(TestThread.card<0){
							break;
						}
				}
			}
			
			
			
		}
	
}

class B{
	
}