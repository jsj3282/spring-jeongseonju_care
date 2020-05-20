package com.care.controller;


import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.care.template.Constant;

public class BatchClass {
	private JdbcTemplate template;
	
	public BatchClass() {
		String config = "classpath:applicationJDBC.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(config);
		JdbcTemplate template = ctx.getBean("template", JdbcTemplate.class);
		Constant.template = template;
	}
	
	public void logPrint() {
		String sql = "select count(*) from logdate";
		int num = Constant.template.queryForObject(sql,  Integer.class);
		System.out.println("게시물의 전체 개수 : " + num);
		
		
	}
}
