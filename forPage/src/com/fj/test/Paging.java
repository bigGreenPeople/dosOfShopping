package com.fj.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fj.DAO.EmpDao;
import com.fj.domain.Emp;

public class Paging extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//����DAO 
		//select * (select t.*,coum l (select * from emp) t where l>=6) where t.l<=1;
		EmpDao empDao = new EmpDao();
		
		//��ҳ��Ϣ
		int pageNow = 1;
		String pageNowStr = request.getParameter("pageNow");
		//����pageNow
		if( pageNowStr!=null ){
			pageNow = Integer.parseInt(pageNowStr);
		}
		
		//ÿҳ3����¼
		int pageSize = 3;
		//System.out.println(pageNowStr);
		
		
		//�����ҳ��
		int pageCount=14% pageSize==0 ? 14/pageSize: 14/pageSize+1;
		
		
		
		//�õ���ҳ�ļ�¼
		List<Emp> list = empDao.showEmpByPage(pageNow, pageSize);
		System.out.println(list.size()); 
		
		//��jspҪ�õ�����Ϣ���õ�request
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/page.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
