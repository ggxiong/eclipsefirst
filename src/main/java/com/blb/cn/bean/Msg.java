package com.blb.cn.bean;

import java.util.HashMap;
import java.util.Map;

public class Msg {

	
	//����״̬�룬100���ɹ� ��200��ʧ��
	private Integer code;
	
	private String msg;
	
	//�û��Żص����ݣ�����map����
	private Map<String, Object> map =new HashMap<String, Object>();
	
	
	//���سɹ��ķ���
	public static Msg success() {
		
		Msg result = new Msg();
		result.setCode(100);
		result.setMsg("����ɹ���");
		return result;
		
	}
	
	    //����ʧ�ܵķ���
		public static Msg fail() {
			
			Msg result = new Msg();
			result.setCode(200);
			result.setMsg("����ʧ�ܣ�");
			return result;
			
		}
	
	
		public  Msg add(String key,Object value) {
			
			 this.getMap().put(key, value);
			
			return this;
			
		}
		

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
	
	
	
	
}
