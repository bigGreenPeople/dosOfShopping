package com.fj.CommonUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;

import com.fj.domain.User;

public class CommonUtils {
	
	//����һ�����ظ���32λuuidֵ
	public static String uuid(){
		return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
	}
	
	/** 
     *  
     * @param bean   
     * @param map 
     * @return map --> bean: ��Mapת��ΪBean 
     * @throws Exception  
     * �˷������ڰѱ���map��װ�����ǵĶ���
     * ������ʱ���ǵı����ܻ���һЩ���Ƕ������Ե�ֵ�����ʱ��ͻ��׳��쳣
     * ���������Բ���Ӱ�����Ƿ�װ
     * ��������������Ӧ�ð�ԭ��map���Ķ��������ó���
     * ������һ���µ�map
     */  
    public static <T ,K, V> T toBean(Class<T> bean, Map<String, V> map) throws Exception {        
    	//����һ���µ�map���map ���bean������
    	Map<String, V> beanMap = new HashMap<String, V>();
    	
    	//����һ��bean����
        T t = bean.newInstance();
        //�õ����е�����
        Field[] fields = bean.getDeclaredFields();
        
        //�õ�map������key
        Set<String> set = map.keySet();
        
        //ѭ���������������з���������
        for(Field f:fields){
        	//�õ����Ե�����
        	String name = f.getName();
        	//���map����������Ҫ�����ԾͰ����������µ�map��
        	if(set.contains(name)){
        		//�ŵ������µ�map��ȥ
        		beanMap.put(name, map.get(name));
        	}
        }
        BeanUtils.populate(t, beanMap);  
        return t;  
       
    }  
/*	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", "fujie");
		map.put("password", "fujie123");
		map.put("passworsd", "fujie123");
		
		try {
			User user = toBean(User.class, map);
			System.out.println("username:"+user.getUsername()+"\npassword:"+user.getPassword());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
}
