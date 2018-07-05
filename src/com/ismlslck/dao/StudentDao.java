package com.ismlslck.dao;

import com.ismlslck.entity.Student;

import java.util.List;

public interface StudentDao {

    public List<Student> getAllStudents();

    public boolean saveStudent(Student student);

    public boolean updateStudent(Student student);

    public Student getStudentById(int id);

    public boolean deleteStudent(int id);
}
