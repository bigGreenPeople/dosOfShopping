package com.fj.test;
/*�Զ��巺�͵�ʹ��
 * 2017��7��21�� 21:37:08
 * */
public class GenericParadigm {
	public static void main(String[] args) {
		A a = new A();
		Integer[] arr = {21,11,5,3};
		
		a.f(arr, 0, 3);
		for(int i:arr){
			System.out.println(i);
		}
	}
}

class A{
	//��������
	public<T> void f(T[] arr,int j,int k){
		T temp = arr[j];
		arr[j] = arr[k];
		arr[k] = temp;
	}
}