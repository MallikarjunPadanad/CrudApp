package com.dev.crudapp.service;


import com.dev.crudapp.entity.Student;
import com.dev.crudapp.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq) {
        return studentRepository.save(studentReq);
    }

    public Student getStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);

        return student.orElse(null);

    }

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public Student updateStudent(Long id, Student studentReq) {

        Optional<Student> studentOptional = studentRepository.findById(id);

        if (studentOptional.isEmpty()) {
            return null;
        }

        Student existingStudent = studentOptional.get();

        existingStudent.setName(studentReq.getName());
        existingStudent.setAge(studentReq.getAge());
        existingStudent.setRollNo(studentReq.getRollNo());
        existingStudent.setSubject(studentReq.getSubject());
        existingStudent.setEmail(studentReq.getEmail());

        return studentRepository.save(existingStudent);
    }

    public Boolean deleteStudent(Long id) {

        if (!studentRepository.existsById(id)) {
            return false;
        }

        studentRepository.deleteById(id);

        return true;
    }
}