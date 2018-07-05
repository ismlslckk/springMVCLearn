package com.ismlslck.dao;

import com.ismlslck.entity.Faculty;

import java.util.List;

public interface FacultyDao {

    public List<Faculty> getAllFaculty();

    public Faculty getFacultyById(int id);

    public boolean saveFaculty(Faculty faculty);

    public boolean updateFaculty(Faculty faculty);

    public boolean deleteFaculty(int id);
}
