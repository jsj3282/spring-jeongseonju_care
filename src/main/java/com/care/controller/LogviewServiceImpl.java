package com.care.controller;

import java.util.ArrayList;


import org.springframework.ui.Model;

public class LogviewServiceImpl {

	public void execute(Model model) {
		LogviewDAO dao = new LogviewDAO();
		ArrayList<LogDTO> logs = dao.logs();
		model.addAttribute("logs", logs);
		
	}
	
	
}
