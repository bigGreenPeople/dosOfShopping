package com.fj.test;

public class TestEnum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s = new Student("fujie", Sex.woman);
		System.out.println("������"+s.name+"  �Ա�"+s.sex);
	}

}

enum Sex{
	woman("Ů"),man("��");
	
	private String sex;
	
	private Sex(String sex){
		this.sex = sex;
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.sex;
	}
	
}
//ö�ٵײ��ʵ�ַ���
/*class Sex{
	private String val; 
	
	public static Sex man = new Sex("��");
	public static Sex woman = new Sex("Ů");
	
	private Sex(){
	}
	private Sex(String val){
		this.val = val;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.val;
	}
}*/

class Student{
	public String name;
	public Sex sex;
	
	public Student(String name, Sex sex) {
		super();
		this.name = name;
		this.sex = sex;
	}
	
}
