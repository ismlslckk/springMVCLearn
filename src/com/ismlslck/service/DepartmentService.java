package com.ismlslck.service;

import com.ismlslck.entity.Department;

import java.util.List;

public interface DepartmentService {
    public List<Department> getAllDepartment();

    public List<Department> getAllDeparmentByFacultyId(int id);

    public Department getDepartmentById(int id);

    public boolean saveDepartment(Department department);

    public boolean updateDepartment(Department department);

    public boolean deleteDepartment(int id);


}
