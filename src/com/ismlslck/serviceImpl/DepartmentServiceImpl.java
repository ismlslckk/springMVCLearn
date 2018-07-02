package com.ismlslck.serviceImpl;

import com.ismlslck.dao.DepartmentDao;
import com.ismlslck.entity.Department;
import com.ismlslck.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    @Transactional
    public List<Department> getAllDepartment() {
        return departmentDao.getAllDepartment();
    }

    @Override
    @Transactional
    public List<Department> getAllDeparmentByFacultyId(int id) {
        return departmentDao.getAllDeparmentByFacultyId(id);
    }

    @Override
    @Transactional
    public Department getDepartmentById(int id) {
        return departmentDao.getDepartmanById(id);
    }

    @Override
    @Transactional
    public boolean saveDepartment(Department department) {
        return departmentDao.saveDepartment(department);
    }

    @Override
    @Transactional
    public boolean updateDepartment(Department department) {
        return departmentDao.updateDepartment(department);
    }

    @Override
    @Transactional
    public boolean deleteDepartment(int id) {
        return departmentDao.deleteDepartment(id);
    }
}
