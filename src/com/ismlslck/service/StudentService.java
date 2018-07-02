package com.ismlslck.service;

import com.ismlslck.entity.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getAllStudents();

    public boolean saveStudent(Student student);

    public boolean updateStudent(Student student);

    public Student getStudentById(int id);

    public boolean deleteStudent(int id);


}
