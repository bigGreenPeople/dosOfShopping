package com.dvd.DB;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dvd.domain.*;

public class DVDMgr {
	//ģ������ݿ�
	public static List<DVD> db = new ArrayList<DVD>();
	//�´���ӵ�ID
	public static int lastID = 4;
	
	//��ʼ������
	public static void init(){
		DVD d1 = new DVD(1, "ս��", 1, 1,new Date() , null);
		DVD d2 = new DVD(2, "�̿�����", 0, 0, null, null);
		DVD d3 = new DVD(3, "Сʱ��", 0, 0, null, null);
		
		db.add(d1);
		db.add(d2);
		db.add(d3);
	}
}
