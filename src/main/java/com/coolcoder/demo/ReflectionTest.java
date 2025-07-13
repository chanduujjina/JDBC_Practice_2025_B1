package com.coolcoder.demo;

import java.lang.reflect.Method;

public class ReflectionTest {
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		Class<?> cls = Class.forName("java.sql.PreparedStatement");
		
		Method[] declaredMethods = cls.getDeclaredMethods();
		
		for(Method method : declaredMethods) {
			System.out.println(method.toString());
		}
		
		
	}

}
