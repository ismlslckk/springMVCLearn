package com.ismlslck.daoImpl;

import com.ismlslck.dao.FacultyDao;
import com.ismlslck.entity.Department;
import com.ismlslck.entity.Faculty;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FacultyDaoImpl implements FacultyDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Faculty> getAllFaculty() {
        Query<Faculty> query = sessionFactory.getCurrentSession().createQuery("from Faculty", Faculty.class);
        List<Faculty> faculties = query.getResultList();
        return faculties;
    }

    @Override
    public Faculty getFacultyById(int id) {
        return sessionFactory.getCurrentSession().get(Faculty.class, id);
    }

    @Override
    public boolean saveFaculty(Faculty faculty) {
        try {
            sessionFactory.getCurrentSession().save(faculty);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateFaculty(Faculty faculty) {
        Session currentSession = sessionFactory.getCurrentSession();
        try {
            currentSession.update(faculty);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteFaculty(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Faculty f = getFacultyById(id);
        if(f!=null){
            try {
                currentSession.remove(f);
                return true;
            }
            catch (Exception e){return false;}
        }
        else {return false;}
    }

}
