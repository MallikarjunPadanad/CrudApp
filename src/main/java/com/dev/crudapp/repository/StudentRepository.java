package com.dev.crudapp.repository;


import com.dev.crudapp.controller.StudentController;
import com.dev.crudapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository extends JpaRepository<Student,Long> {

}
