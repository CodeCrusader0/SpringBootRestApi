package com.app.service;

import java.time.LocalDate;
import java.util.List;

import com.app.dto.StudentResponse;
import com.app.dto.LoginRequestDto;
import com.app.pojos.Student;

public interface StudentService {
//get all emps
	List<Student> getAllEmpDetails();

	Student addEmpDetails(Student transientEmp);

	String deleteEmpDetails(Long empId);

	Student fetchEmpDetails(Long empId);

	Student updateEmpDetails(Student detachedEmp);

	Student authenticateEmp(LoginRequestDto dto);

//	List<StudentResponse> getEmpsBySalary(double minSal, double maxSal);
}
