package com.xpath;

import java.util.List;

import org.dom4j.*;
import org.dom4j.io.*;

//����Xpath����crud����

public class Xpath {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		SAXReader sr = new SAXReader();
		Document doc=sr.read("src/test.xml");
		
		List li = doc.selectNodes("/AAA/BBB");
		
		System.out.println(li.size());
	}

}
