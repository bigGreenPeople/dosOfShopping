package com.fj.test;

import java.sql.SQLException;
import java.util.List;

import com.fj.JDBCUtils.JdbcUtils;
import com.fj.dao.BookCaseDao;
import com.fj.domain.BookType;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��������Ƿ�ɹ�
		BookCaseDao bookCaseDao = new BookCaseDao();
		/*
		BookType bookType = new BookType(9, "xxx��", 20);
		
		try {
			boolean b = bookCaseDao.addBookType(bookType);
			System.out.println(b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//���Բ�ѯ�Ƿ�ɹ�
	/*	List<BookType> list;
		try {
			list = bookCaseDao.getBookType();
			for(BookType bookType:list){
				System.out.println(bookType.getTypeName());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//�������ǵ������Ƿ�ɹ�
		
		
		try {
			//��������
			JdbcUtils.beginTransaction();
			//�����ݽ��в���
			bookCaseDao.updBookCase(2, 10);
			int i = 2/0;
			bookCaseDao.updBookCase(3, -20);
			//�ύ����
			JdbcUtils.commitTransaction();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//�ع�����
			try {
				JdbcUtils.rollbackTransaction();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

}
