package com.care.controller;


import java.text.SimpleDateFormat;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.care.template.Constant;

@Aspect
@Repository
public class CommonClass {
	
	private JdbcTemplate template;
	
	public CommonClass() {
		String config = "classpath:applicationJDBC.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(config);
		JdbcTemplate template = ctx.getBean("template", JdbcTemplate.class);
		Constant.template = template;
	}
	
	private SimpleDateFormat dayTime;
	private long loglong;
	private String logdate;
	@After("execution(* com.care.controller.LoginClass.login())") 
	public void AfterLogin(JoinPoint joinPoint) {
		dayTime = new SimpleDateFormat("yyyy-MM-dd aa hh:mm:ss");
		loglong = System.currentTimeMillis();
		logdate = dayTime.format(loglong);
		logWrite();
		System.out.println("로그인 되었습니다.");
	}
	
	@Before("execution(* com.care.controller.LoginClass.logout())") 
	public void BeforeLogout(JoinPoint joinPoint) {
		System.out.println("로그아웃 되었습니다.");
	}
	
	public void logWrite() {
		String sql = "insert into logdate values(lognum.nextval,?)";
		System.out.println("---------------------------------------------- " + logdate);
		System.out.println(Constant.template);
		Constant.template.update(sql, ps->{
			ps.setString(1,  logdate);
		});
		
	}
}

