package com.fujie;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;


//��������ɶ�xml�ļ���crud����
public class XmlDemo {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//DocumentBuilderFactory.newInstance()�������DOM��������
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		//ͨ��dom������newDocumentBuilder()�����õ�Dom������
		DocumentBuilder dbu=dbf.newDocumentBuilder();
//		ָ�������Ǹ�xml�ļ�
		Document document=dbu.parse("src/MyXml.xml");
		
		//list(document);
		//read(document);
		//add(document);
		//del(document);
		upd(document);
	}
	
	//�޸Ľڵ�
	public static void upd(Document doc) throws Exception
	{
		//�õ���һ��ѧ��
		Element stu = (Element)doc.getElementsByTagName("ѧ��").item(0);
		//�õ�ѧ���ĵ�һ������(����֪��ѧ���м�������)
		Node stu_name=stu.getElementsByTagName("����").item(0);
		//���������е�����
		stu_name.setTextContent("����");
		
		trans(doc);
	}
	
	//ɾ�����
	public static void del(Document doc) throws Exception
	{
//		//�ҵ���һ��ѧ�� 
//		Node node=doc.getElementsByTagName("ѧ��").item(0);
//		//���ڵ�ȥɾ���ӽڵ�
//		node.getParentNode().removeChild(node);
		
//		ɾ������
		Element node = (Element)doc.getElementsByTagName("ѧ��").item(0);
		node.removeAttribute("sex");
		trans(doc);
	}
	//��ӽڵ�
	public static void add(Document doc) throws Exception
	{
		//����һ���µ�ѧ���ڵ�
		Element stu=doc.createElement("ѧ��");
		Element stu_name=doc.createElement("����");
		stu_name.setTextContent("����");
		Element stu_age=doc.createElement("����");
		stu_age.setTextContent("20");
		Element stu_intro=doc.createElement("����");
		stu_intro.setTextContent("�ǳ�����");
		
//		��ӵ�ѧ��
		stu.appendChild(stu_name);
		stu.appendChild(stu_age);
		stu.appendChild(stu_intro);
		//���½���ѧ���ڵ��м�������
		
		//���ڵ���ӵ�doc��
		doc.getDocumentElement().appendChild(stu);
		
		trans(doc);
	}
	
	//����xml�ļ�����
	public static void trans(Document doc) throws Exception
	{
		//�õ�TransformerFactory
		TransformerFactory tff=TransformerFactory.newInstance();
		//ͨ��tff�õ�һ��ת����
		Transformer tf=tff.newTransformer();
		//�����ļ�
		tf.transform(new DOMSource(doc),new StreamResult("src/MyXml.xml"));
	}
	//����document
	public static void list(Node node)
	{
		//�ڿ���̨��ӡ���ڵ������
		if(node.getNodeType()==Node.ELEMENT_NODE)
		{
			System.out.println(node.getNodeName());
		}
		//ȡ���ӽڵ�
		NodeList nl = node.getChildNodes();
		//�ݹ���ȥ���������еĽڵ� 
		for(int i=0;i<nl.getLength();i++)
		{
			Node n=nl.item(i);
			list(n);
		}
		
	}
	//�����ѯĳ��ѧ������Ϣ 
	public static void read(Document doc)
	{
//		�õ�ѧ���ļ���
		NodeList nl = doc.getElementsByTagName("ѧ��");
		//�õ���һ��ѧ��
		Element stu=(Element)nl.item(0);
		System.out.println(stu.getAttribute("sex"));
//		�õ�����
		Element name=(Element)stu.getElementsByTagName("����").item(0);
		System.out.println(name.getTextContent());
	}
}
