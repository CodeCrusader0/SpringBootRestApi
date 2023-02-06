package com.app.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
//finder method for signin
	Optional<Student> findByEmailAndPassword(String em, String pass);

}
