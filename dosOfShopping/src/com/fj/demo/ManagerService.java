package com.fj.demo;

import com.fj.data.*;
/*
 * ������һ��Customer�Ĺ�����
 * �е�����web������service��
 * */

public class ManagerService {
	//��¼��֤
	public boolean checkAdmin(String pass){
		boolean b = false;
		
		//������������ȷ
		if(pass.equals(Data.manager.password)){
			b = true;
		}
		
		//���ʧ�����ӵ�¼ʧ�ܴ���
		if(!b){
			Manager.loginNum++;
		}
		
		Menu.nextMenu();
		return b;
	}
	
	//�޸Ĺ���Ա����s
	public void updPass(String newPass){
		
		Data.manager.password = newPass;
	}
}
