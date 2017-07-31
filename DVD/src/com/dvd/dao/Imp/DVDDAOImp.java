package com.dvd.dao.Imp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.dvd.DB.DVDMgr;
import com.dvd.dao.DVDDAO;
import com.dvd.domain.DVD;

public class DVDDAOImp implements DVDDAO {

	//���
	@Override
	public boolean add(DVD dvd) {
		boolean b = true;
		
		//��list�����������
		DVDMgr.db.add(dvd);
		
		//�޸�����ID
		DVDMgr.lastID++;
		
		return b;
	}

	//ɾ��
	@Override
	public boolean delete(String name) {
		boolean b = false;
		//�������DVD�ļ���
		List<DVD> list = null;
		list = DVDMgr.db;
		//����list����û��name
		for(int i=0;i<list.size();i++){
			//����ҵ����Ǿ�ɾ��
			if(list.get(i).getName().equals(name)){
				//System.out.println("״̬��"+list.get(i).getStuta());
				//�ж�����״̬���Ƿ��Ѿ������
				if(list.get(i).getStuta()==0){
					DVDMgr.db.remove(list.get(i));
					b = true;
				}
				
			}
		}
		
		return b;
	}

	@Override
	public List<DVD> showDVD() {
		//�������DVD�ļ���
		List<DVD> list = null;
		//�õ�����
		list = DVDMgr.db;
		
		return list;
	}

	@Override
	public boolean giveDVD(String name, Date date) {
		boolean b = false;
		//����list����û��name
		for(DVD dvd:DVDMgr.db){
			//����ҵ����Ǿ��޸�״̬
			if(dvd.getName().equals(name)){
				//�ж�����״̬���Ƿ��Ѿ������
				if(dvd.getStuta()==0){
					dvd.setStuta(1);
					dvd.setGiveDate(date);
					//dvd.setGetDate(null);
					dvd.setNum((dvd.getNum()+1));
					b = true;
				}
				
			}
		}
		
		return b;

	}
	@Override
	public boolean getDVD(String name, Date date) {
		boolean b = false;
		
		for(DVD dvd:DVDMgr.db){
			//����ҵ����Ǿ��޸�״̬
			if(dvd.getName().equals(name)){
				//�ж�����״̬���Ƿ��Ѿ�û�����
				if(dvd.getStuta()==1){
					dvd.setStuta(0);
					//dvd.setGiveDate(null);
					dvd.setGetDate(date);
					b = true;
				}
				
			}
		}
		return b;

	}
	
	@Override
	public int getLastID() {
		// TODO Auto-generated method stub
		return DVDMgr.lastID;
	}
	
	@Override
	public List<DVD> showByNum() {
		// TODO Auto-generated method stub
		List<DVD> list = new ArrayList<DVD>();
		
		//���Ƶ��µļ���
		list.addAll(DVDMgr.db);
		//����
		Collections.sort(list);
		
		return list;
	}
	
	@Override
	public int getDay(String name) {
		// TODO Auto-generated method stub
		int day = 0;
		for(DVD dvd:DVDMgr.db){
			//����ҵ����Ǿ��޸�״̬
			if(dvd.getName().equals(name)){
				
				Long newTime = dvd.getGetDate().getTime();
				Long oldTime = dvd.getGiveDate().getTime();
				long time = newTime-oldTime;
				day = (int) (time/(1000*60*60*24));
			}
		}
		
		return day;
	}
}
