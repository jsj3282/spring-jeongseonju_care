package com.care.controller;

import java.util.ArrayList;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.care.template.Constant;

@Repository
public class LogviewDAO {
	private JdbcTemplate template;
	
	public LogviewDAO() {
		String config = "classpath:applicationJDBC.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(config);
		JdbcTemplate template = ctx.getBean("template", JdbcTemplate.class);
		Constant.template = template;
	}
	public ArrayList<LogDTO> logs() {
		System.out.println("===========================" + Constant.template);
		String sql = "select * from logdate";
		ArrayList<LogDTO> logs = null;
		logs = (ArrayList<LogDTO>)Constant.template.query(sql, new BeanPropertyRowMapper<LogDTO>(LogDTO.class));
		return logs;
	}
}
