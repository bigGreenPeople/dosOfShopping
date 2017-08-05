package com.sax;

import javax.xml.parsers.*;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Sax1 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
//		����SAXParserFactory����
		SAXParserFactory spf=SAXParserFactory.newInstance();
//		ʹ��SAXParserFactory�õ�������
		SAXParser sp=spf.newSAXParser();
//		��xml�ļ����¼��������
		sp.parse("src/MyXml.xml", new My());
	}

}

class My extends DefaultHandler
{

	@Override
	//�ĵ���ʼִ�д˺���
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("�ĵ���ʼɨ������");
	}
//	�ĵ�����ִ�д˺���
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("�ĵ�����");
	}
//	�ڵ㿪ʼִ�д˺���
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		//qName��Ԫ�ص�����
		//Attributes�����Զ���
//		System.out.println("Ԫ��������:"+qName+"    ��Ԫ�ص�������:"+attributes.getQName(0)+"   ������ֵ��"+attributes.getValue(0));
	}
//	�ڵ����ִ�д˺���
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
//		System.out.println("Ԫ��������:"+qName);
	}
//	���������ı�ִ�д˺���
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
//		super.characters(ch, start, length);
//		ch������xml�ļ������е��ַ���
		String con=new String(ch,start,length);
		if(!con.trim().equals(""))
		{
			System.out.println(con);
		}
	}
	
}