package com.fj.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.fj.JDBCUtils.JdbcUtils;
import com.fj.domain.BookType;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class BookCaseDao {
	//����
	public boolean addBookType(BookType bookType) throws SQLException{
		//�������ǵ�DButil�Ĺ�����
		QueryRunner qr = new QueryRunner();
		
		String sql = "INSERT INTO tb_booktype VALUES(?,?,?)";
		Object[] params = { bookType.getId(),bookType.getTypeName(),bookType.getDays()};		
		int num = qr.update(JdbcUtils.getConnection(),sql,params);
		//�ж�Ӱ��������Ƿ�Ϊ0 	�����Ϊ0�ͳɹ�
		if(num==0){
			return false;
		}
		
		return true;
	}
	//ɾ��
	public boolean delBookCase(){
		return true;
	}
	
	//�޸� 
	public boolean updBookCase(int bookCaseId,int days) throws SQLException{
		QueryRunner qr = new QueryRunner();
		//д��sql���
		String sql = "UPDATE tb_booktype SET days=days+? WHERE id=?";
		Object[] params ={days,bookCaseId};
		
		int num = qr.update(JdbcUtils.getConnection(), sql, params);
		
		//�ж�Ӱ��������Ƿ�Ϊ0 	�����Ϊ0�ͳɹ�
		if(num==0){
			return false;
		}
		
		return true;
	}
	
	//��ѯ
	public List<BookType> getBookType() throws SQLException{
		List<BookType> list = new ArrayList<BookType>();
		QueryRunner qr = new QueryRunner();
		//��ѯ���
		String sql = "SELECT * FROM tb_booktype";
		//�õ������Ѿ���װ�Ľ����
		list = qr.query(new ComboPooledDataSource().getConnection(), sql,new BeanListHandler<BookType>(BookType.class));
		
		return list;
	}
	
}
