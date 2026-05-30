package com.niharika.studentmanagement.service;

import com.niharika.studentmanagement.entity.Student;
import com.niharika.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) {
            System.out.println("Student not found with id: " + id);
            return null;
        }
        return student;

//        Student student = null;
//
//        student.getName();
//
//        return student;
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        Student existingStudent = studentRepository.findById(id).orElse(null);

            if (existingStudent == null) {
                System.out.println("No student found to update with id: " + id);
                return null;
            }

            existingStudent.setName(updatedStudent.getName());
            existingStudent.setCourse(updatedStudent.getCourse());
            existingStudent.setEmail(updatedStudent.getEmail());

            return studentRepository.save(existingStudent);
    }

    public String deleteStudent(Long id) {
        Student student = studentRepository.findById(id).orElse(null);

        if (student == null) {
            return "Student not found";
        }
    
        studentRepository.deleteById(id);
    
        return "Student deleted successfully";
    }
}