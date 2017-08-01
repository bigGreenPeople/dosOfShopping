package com.fj.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	//����һ�����ӳ�
	public static ComboPooledDataSource cds = new ComboPooledDataSource(); 
	//���������
	public static Connection ct = null;
	
	//�õ�һ������
	public static Connection getConnection() throws SQLException{
		//�������������
		if(ct!=null) return ct;		
		return cds.getConnection();
	}
	//�õ�һ������Դ
	public static ComboPooledDataSource getCds() {
		return cds;
	}
	
	//��������
	public static void beginTransaction() throws SQLException{
		//�ж������Ƿ���
		if(ct!=null) throw new RuntimeException("����!�����ѿ��� ");
		ct = getConnection();
		ct.setAutoCommit(false);
	}
	
	
	//�ύ����
	public static void commitTransaction() throws SQLException{
		//�ж������Ƿ���
		if(ct==null) throw new RuntimeException("����!����δ���� ");
		ct.commit();
		ct = null;
	}
		
	//�ع�����
	public static void rollbackTransaction() throws SQLException{
		//�ж������Ƿ���
		if(ct==null) throw new RuntimeException("����!����δ���� ");
		ct.rollback();
		ct = null;
	}
}
