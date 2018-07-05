package com.ismlslck.daoImpl;

import com.ismlslck.dao.DepartmentDao;
import com.ismlslck.entity.Department;
import com.ismlslck.entity.Faculty;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Department> getAllDepartment() {
        Query<Department> query = sessionFactory.getCurrentSession().createQuery("from Department", Department.class);
        List<Department> departments = query.getResultList();
        return departments;
    }

    @Override
    public List<Department> getAllDeparmentByFacultyId(int id) {
        Query<Department> query = sessionFactory.getCurrentSession().createQuery("from Department where facultyId=:facultyId", Department.class);
        query.setParameter("facultyId",id);
        return query.getResultList();
    }

    @Override
    public Department getDepartmanById(int id) {
        return sessionFactory.getCurrentSession().get(Department.class, id);
    }

    @Override
    public boolean saveDepartment(Department department) {
        try {
            sessionFactory.getCurrentSession().save(department);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateDepartment(Department department) {
        Session currentSession = sessionFactory.getCurrentSession();
        try {
            currentSession.update(department);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteDepartment(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Department d = getDepartmanById(id);
        currentSession.remove(d);
        return true;
    }
}
