package com.ismlslck.service;

import com.ismlslck.entity.Faculty;

import java.util.List;

public interface FacultyService {
    public List<Faculty> getAllFaculty();

    public Faculty getFacultyById(int id);

    public boolean saveFaculty(Faculty faculty);

    public boolean updateFaculty(Faculty faculty);

    public boolean deleteFaculty(int id);

    public int getFacultyIdByStudentId(int id);



}
