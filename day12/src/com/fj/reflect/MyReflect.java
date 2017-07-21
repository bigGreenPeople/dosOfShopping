package com.fj.reflect;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

public class MyReflect {
	//�������ɶ���
	
	
	public static void main(String[] args) throws Exception{
		//������
		FileInputStream fileInputStream = new FileInputStream("src/classInfo.propertis");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		
		//ȡֵ
		String classPath = properties.getProperty("classPath");
		String method = properties.getProperty("method");
		
		String parameterType = properties.getProperty("parameterType");
		String parameterVar = properties.getProperty("parameterVar");
		
		String parameterType2 = properties.getProperty("parameterType2");
		String parameterVar2 = properties.getProperty("parameterVar2");
		//System.out.println(parameterType);
		Class clazz = Class.forName(classPath);
		//System.out.println(parameterType2);
		//��������
		Object ob = clazz.newInstance();
		//�õ���������
		Method method2 =
			clazz.getMethod(method, Class.forName(parameterType),Class.forName(parameterType2));
		
		//����һ���ڶ��������Ķ���
		Constructor cs2 = Class.forName(parameterType2).getConstructor(parameterVar2.getClass());
		Object intt = cs2.newInstance(parameterVar2);
		//���÷���
		method2.invoke(ob, parameterVar,intt);
	}
}
