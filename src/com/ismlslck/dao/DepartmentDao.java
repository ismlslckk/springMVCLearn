package com.ismlslck.dao;

import com.ismlslck.entity.Department;

import java.util.List;

public interface DepartmentDao {
    public List<Department> getAllDepartment();
    public List<Department> getAllDeparmentByFacultyId(int id);
    public Department getDepartmanById(int id);
    public boolean saveDepartment(Department department);
    public boolean updateDepartment(Department department);
    public boolean deleteDepartment(int id);

}
