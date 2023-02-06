package com.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.StudentResponse;
import com.app.dto.LoginRequestDto;
import com.app.pojos.Student;
import com.app.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	// dep : dao layer i/f
	@Autowired
	private StudentRepository empRepo;
	//dep : model mapper 
	@Autowired
	private ModelMapper mapper;
	
	@PostConstruct
	public void init()
	{
		System.out.println("in init "+mapper);
	}

	@Override
	public List<Student> getAllEmpDetails() {
		return empRepo.findAll();
	}

	@Override
	public Student addEmpDetails(Student transientEmp) {
		// TODO Auto-generated method stub
		return empRepo.save(transientEmp);
	}

	@Override
	public String deleteEmpDetails(Long empId) {
		// chekc if emp exists by id
		if (empRepo.existsById(empId)) {
			empRepo.deleteById(empId);
			return "Emp details deleted ....";
		}
		return "Deletion Failed : Invalid Emp Id !!!!!!!!!!!";
	}

	@Override
	public Student fetchEmpDetails(Long empId) {
		// TODO Auto-generated method stub
		return empRepo.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Invalid Emp ID !!!!!"));
	}

	@Override
	public Student updateEmpDetails(Student detachedEmp) {
		// confirm if emp with id exists !
		if (empRepo.existsById(detachedEmp.getId())) {
			return empRepo.save(detachedEmp);
		}
		throw new ResourceNotFoundException("Invalid Emp Id : Updation Failed!!!!!!!!");
	}

	@Override
	public Student authenticateEmp(LoginRequestDto dto) {
		// TODO Auto-generated method stub
		return empRepo.findByEmailAndPassword(dto.getEmail(), dto.getPassword())
				.orElseThrow(() -> new ResourceNotFoundException("Bad Credentials !!!!!"));
	}


}
