package com.fj.action;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fj.CommonUtils.CommonUtils;
import com.fj.domain.User;

public class UserServlet extends BaseServlet {
	

	public String getUser(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
//		��form�����ݵĲ������һ��map
		Map<String, String[]> parameterMap = req.getParameterMap();
		
		//Set <String> set = parameterMap.keySet();
		User user=null;
		try {
			//�������ǵ�CommonUtils��tobean����  ֱ�ӽ�from������������user���Ե�����ע�뵽user��
			user = CommonUtils.toBean(User.class, parameterMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//��ӡ��user����Ϣ
		System.out.println("username:"+user.getUsername()+"\npassword:"+user.getPassword());
		return null;
	}
	
}
