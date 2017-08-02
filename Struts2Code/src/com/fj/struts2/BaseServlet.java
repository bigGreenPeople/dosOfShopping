package com.fj.struts2;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��������ܵ�����ʱ����������service����
 * �������ڽ��ܵ��û�Ҫ���õķ���
 * Ȼ�����÷���ȥ�����������
 * �ڽ��ܵ�Ҫ���ص���ת��Ϣ
 * ����֮
 * @author BigGreenPeople
 *
 */
public class BaseServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//�õ���ҳ������method���� �����������ĸ�
		String  method = req.getParameter("method");
		System.out.println(method);
		//�õ��������
		Class clazz =  this.getClass();
		Method met = null;
		
		try {
			//�õ����ǵķ�������
			//�������ǲ���дreq.getClass()��resp.getClass()		
			met = clazz.getDeclaredMethod(method, HttpServletRequest.class,HttpServletResponse.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("�޴˷���!");
		}
		String result="";
		//����֮
		try {
			//�õ����ǵķ���ֵ	
			result = (String) met.invoke(this, req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("��������ʱ����!");
		}
		
		//���ݷ���ֵ������ô��ת
		//����������һ���涨
		//f:xxx.jsp	���Ϊforword
		//r:xxxjsp	���Ϊ�ض���
		//xxx.jsp ���Ĭ��Ϊforword
		
		//�ж�result��û�ж��� ���Ϊnull�Ļ�����ʲô������
		if(result!=null && !result.equals("")){
			//�жϷ���ֵ��û��
			if(result.contains(":")){
				//�õ�����λ��
				int index = result.indexOf(":");
				//��ȡ��ǰ׺
				String s = result.substring(0,index);
				//��ȡҪ��ת�Ľ��� 
				String path = result.substring(index+1);
				
				//�ж��������ת
				if(s.equals("r")){
					//�ض���
					resp.sendRedirect(req.getContextPath()+path);
				}else if(s.equals("f")){
					//forword	��ת
					req.getRequestDispatcher(path).forward(req, resp);
				}
			}else{
				//Ĭ��forword	��ת
				req.getRequestDispatcher(result).forward(req, resp);
			}
		}

	}
}
