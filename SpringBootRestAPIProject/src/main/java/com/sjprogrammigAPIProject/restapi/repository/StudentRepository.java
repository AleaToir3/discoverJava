package com.sjprogrammigAPIProject.restapi.repository;

import com.sjprogrammigAPIProject.restapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
