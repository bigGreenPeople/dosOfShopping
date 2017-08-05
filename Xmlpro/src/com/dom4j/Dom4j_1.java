package com.dom4j;

import java.io.FileOutputStream;
import java.util.*;

import org.dom4j.*;
import org.dom4j.io.*;

public class Dom4j_1 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
//		�õ�������
		SAXReader sr=new SAXReader();
//		ָ�������ĸ�XML�ļ�
		Document doc=sr.read("src/MyXml.xml");
		
		//list(doc.getRootElement());
		add(doc.getRootElement());
		//del(doc.getRootElement());
		//upd(doc);
	}
	
	//�޸�Ԫ��
	public static void upd(Document doc) throws Exception
	{
		List<Element> stus=(List)doc.getRootElement().elements("ѧ��");
		
		for(Element stu:stus)
		{
			Element stu_age=stu.element("����");
			int age=Integer.parseInt((stu_age.getTextTrim()))+3;
			stu_age.setText(age+"");
		}
		format(doc.getRootElement());
	}
	
	//ɾ��һ��Ԫ��
	public static void del(Element doc) throws Exception
	{
		//�õ���һ��ѧ��
		Element stu=doc.element("ѧ��");
		//�Ӹ��ڵ�ȥɾ������������
		stu.remove(stu.attribute("sex"));
		format(doc);
	}
	
	//���Ԫ��
	public static void add(Element doc) throws Exception
	{
		Element stu=DocumentHelper.createElement("ѧ��");
		//���һ������
		stu.addAttribute("sex", "��");
		Element stu_name=DocumentHelper.createElement("����");
		stu_name.setText("����");
		Element stu_age=DocumentHelper.createElement("����");
		stu_age.setText("18");
		Element stu_intro=DocumentHelper.createElement("����");
		stu_intro.setText("ѧ��");
		//�����е��ӽڵ���ӵ�ѧ���ڵ���
		stu.add(stu_name);
		stu.add(stu_age);
		stu.add(stu_intro);
		//��ѧ���ڵ���ӵ����ڵ���
		//doc.add(stu);
//		���ڵ���ӵ�ָ����λ��
		List li = doc.elements();
		li.add(2,stu);
		
		format(doc);
		
	}
	
	public static void format(Element doc) throws Exception
	{
		//�õ�һ�����źÿ���ʽ��ָ���������
		OutputFormat output=OutputFormat.createPrettyPrint();
		output.setEncoding("utf-8");
		//���ڴ���д�뵽XML�ļ���(ע��Ҫ������ģʽ���ó�UTF-8)
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/MyXml.xml"),output);
		//��dom��д�뵽�ļ���
		writer.write(doc);
		//�ͷ��ļ�
		writer.close();
	}

	//�������ǵ��ĵ�
	public static void list(Element doc)
	{
		System.out.println(doc.getName()+"\t"+doc.getTextTrim()+"\t����:"+doc.attributeValue("sex"));
//		�õ��ĵ��ĵ�����
		Iterator<Element> it=doc.elementIterator();
		
		while(it.hasNext())
		{
			Element e=(Element)it.next();
			list(e);
			
		}
	}
}
