package com.sh.mybatis.emp.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.mybatis.common.AbstractController;
import com.sh.mybatis.emp.model.service.EmpService;

public class EmpSearch2Controller extends AbstractController {

	private EmpService empService;
	
	public EmpSearch2Controller(EmpService empService) {
		this.empService = empService;
	}
	
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.사용자입력값 처리
		String searchType = request.getParameter("searchType");
		String searchKeyword = request.getParameter("searchKeyword");
		String gender = request.getParameter("gender");
		Integer salary = null;
		try {
			salary = Integer.parseInt(request.getParameter("salary"));
		} catch (NumberFormatException e) {}
		String salarayCompare = request.getParameter("salarayCompare");
		
		String hireDate = request.getParameter("hire_date");
		String hiredateCompare = request.getParameter("hiredateCompare");
		
		Map<String, Object> param = new HashMap<>();
		param.put("searchType", searchType);
		param.put("searchKeyword", searchKeyword);
		param.put("gender", gender);
		param.put("salary", salary);
		param.put("salarayCompare", salarayCompare);
		param.put("hireDate", hireDate);
		param.put("hiredateCompare", hiredateCompare);
		
		System.out.println("param = " + param);
		
		// 2. 업무로직 - 검색
		List<Map<String, Object>> empList = empService.search2(param);
		System.out.println("empList = " + empList);
		
		// 3. jsp 데이터 전달
		request.setAttribute("empList", empList);
		
		return "emp/search2";
	}
}