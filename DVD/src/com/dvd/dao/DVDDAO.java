package com.dvd.dao;

import java.util.Date;
import java.util.List;

import com.dvd.domain.*;

public interface DVDDAO {
	//添加
	public boolean add(DVD dvd);	
	//删除
	public boolean delete(String name);
	//显示dvd
	public List<DVD> showDVD();
	//借出	String ---> Date
	public boolean giveDVD(String name,Date date);
	//归还
	public boolean getDVD(String name,Date date);
	
	//����һ�����ʱ��ID
	public int getLastID();
	
	public List<DVD> showByNum();
	
	//�õ�����
	public int getDay(String name);
}
