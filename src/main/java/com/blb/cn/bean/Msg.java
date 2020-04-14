package com.blb.cn.bean;

import java.util.HashMap;
import java.util.Map;

public class Msg {

	
	//返回状态码，100：成功 ；200：失败
	private Integer code;
	
	private String msg;
	
	//用户放回的数据，放在map里面
	private Map<String, Object> map =new HashMap<String, Object>();
	
	
	//返回成功的方法
	public static Msg success() {
		
		Msg result = new Msg();
		result.setCode(100);
		result.setMsg("处理成功！");
		return result;
		
	}
	
	    //返回失败的方法
		public static Msg fail() {
			
			Msg result = new Msg();
			result.setCode(200);
			result.setMsg("处理失败！");
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
