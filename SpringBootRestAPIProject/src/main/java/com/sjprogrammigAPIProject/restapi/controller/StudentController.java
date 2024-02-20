package com.sjprogrammigAPIProject.restapi.controller;

import com.sjprogrammigAPIProject.restapi.entity.Student;
import com.sjprogrammigAPIProject.restapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class StudentController {
    @Autowired
    StudentRepository repo;
    @GetMapping("/students")
  public List<Student> getAllStudents(){
       List<Student> students =  repo.findAll();
        return students;
    }
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id){
        return repo.findById(id).get();
    }
@PostMapping("/student/add")
@ResponseStatus(code = HttpStatus.CREATED)
    public String createStudent(@RequestBody Student student){
    repo.save(student);
    return "student bien ajouter!";
    }
@PutMapping("/student/update/{id}")
    public Student updateStudent(@PathVariable int id,@RequestBody Student updateStudent){
        Student student = repo.findById(id).get();
        student.setName(updateStudent.getName() != null ? updateStudent.getName() : student.getName());
        student.setBranch(updateStudent.getBranch() != null ? updateStudent.getBranch() : student.getBranch());
        repo.save(student);
    return student;
}
@DeleteMapping("/student/delete/{id}")
    public void deleteStudent(@PathVariable int id){
        Student student = repo.findById(id).get();
        repo.delete(student);
 }
}

