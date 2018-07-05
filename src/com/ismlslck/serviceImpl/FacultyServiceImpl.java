package com.ismlslck.serviceImpl;

import com.ismlslck.dao.FacultyDao;
import com.ismlslck.dao.StudentDao;
import com.ismlslck.entity.Faculty;
import com.ismlslck.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyDao facultyDao;

    @Autowired
    private StudentDao studentDao;

    @Override
    @Transactional
    public List<Faculty> getAllFaculty() {
        return facultyDao.getAllFaculty();
    }

    @Override
    @Transactional
    public Faculty getFacultyById(int id) {
        return facultyDao.getFacultyById(id);
    }

    @Override
    @Transactional
    public boolean saveFaculty(Faculty faculty) {
        return facultyDao.saveFaculty(faculty);
    }

    @Override
    @Transactional
    public boolean updateFaculty(Faculty faculty) {
        return facultyDao.updateFaculty(faculty);
    }

    @Override
    @Transactional
    public boolean deleteFaculty(int id) {
        return facultyDao.deleteFaculty(id);
    }

    @Override
    @Transactional
    public int getFacultyIdByStudentId(int id) {
        return studentDao.getStudentById(id).getDepartment().getFaculty().getId();
    }
}
