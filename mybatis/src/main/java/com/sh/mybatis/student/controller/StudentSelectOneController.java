package com.sh.mybatis.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.mybatis.common.AbstractController;
import com.sh.mybatis.student.model.service.StudentService;

public class StudentSelectOneController extends AbstractController {
	
	private StudentService studentService;
	
	/**
	 * 의존객체 주입
	 * @param studentService
	 */
	public StudentSelectOneController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "student/selectOne";
	}
	
	
}
