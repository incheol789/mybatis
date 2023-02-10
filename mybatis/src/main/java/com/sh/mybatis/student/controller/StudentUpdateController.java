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

public class StudentUpdateController extends AbstractController {
	
	private StudentService studentService;

	public StudentUpdateController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@Override
	public String doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 사용자입력값
		int no = Integer.parseInt(request.getParameter("no"));
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		
		Student student = new Student();
		student.setNo(no);
		student.setName(name);
		student.setTel(tel);
		System.out.println(student);
		
		// 2. 업무로직 - db저장
		int result = studentService.updateStudent(student);
		
		// 3. 사용자 피드백전달
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "학생 수정 성공!");
		response.setContentType("application/json; charset=utf-8");
		new Gson().toJson(map, response.getWriter());
		
		return null;
	}
	
}
