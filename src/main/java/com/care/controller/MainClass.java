package com.care.controller;

import org.springframework.context.support.GenericXmlApplicationContext;


public class MainClass {
	public static void main(String[] args) {
		String path = "classpath:applicationAOP.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(path);
		LoginClass lc = ctx.getBean("login", LoginClass.class);
		System.out.println("main start!!!!!");
		lc.login();
		lc.logout();
		System.out.println("main end!!!!!");
		ctx.close();
	}
}
