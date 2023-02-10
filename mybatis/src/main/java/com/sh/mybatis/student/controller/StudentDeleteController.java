package com.sh.mybatis.student.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sh.mybatis.common.AbstractController;
import com.sh.mybatis.student.model.dto.Student;
import com.sh.mybatis.student.model.service.StudentService;

public class StudentDeleteController extends AbstractController {
	
	private StudentService studentService;

	public StudentDeleteController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@Override
	public String doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 사용자입력값
		int no = Integer.parseInt(request.getParameter("no"));
		
		// 2. 업무로직 - db저장
		int result = studentService.deleteStudent(no);
		
		// 3. 사용자 피드백전달
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "학생 삭제 성공!");
		response.setContentType("application/json; charset=utf-8");
		new Gson().toJson(map, response.getWriter());
		
		return null;
	}
	
}
