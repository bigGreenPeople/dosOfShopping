package com.fj.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MyHttpSessionAttrListener implements HttpSessionAttributeListener {
	//��session������Ժ󴥷�
	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("������ӣ���"+arg0.getName()+"   ֵ��"+arg0.getValue());
	}
	//��sessionɾ�����Դ���
	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("����ɾ������"+arg0.getName()+"   ֵ��"+arg0.getValue());
	}
	//��session�޸����Դ���
	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		//����õ����Ǳ��޸�ǰ������
		System.out.println("�����޸� ����"+arg0.getName()+"   ֵ��"+arg0.getValue());
	}

}
