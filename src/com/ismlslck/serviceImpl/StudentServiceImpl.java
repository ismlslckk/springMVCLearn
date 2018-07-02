package com.ismlslck.serviceImpl;

import com.ismlslck.dao.StudentDao;
import com.ismlslck.entity.Student;
import com.ismlslck.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    @Transactional
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    @Override
    @Transactional
    public boolean saveStudent(Student student) {
        return studentDao.saveStudent(student);
    }

    @Override
    @Transactional
    public boolean updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    @Transactional
    public Student getStudentById(int id) {
        return studentDao.getStudentById(id);
    }

    @Override
    @Transactional
    public boolean deleteStudent(int id) {
        return studentDao.deleteStudent(id);
    }
}
