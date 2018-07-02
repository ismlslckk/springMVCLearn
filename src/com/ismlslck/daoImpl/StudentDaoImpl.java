package com.ismlslck.daoImpl;

import com.ismlslck.dao.StudentDao;
import com.ismlslck.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Student> getAllStudents() {
        Query<Student> query = sessionFactory.getCurrentSession().createQuery("from Student", Student.class);
        List<Student> students = query.getResultList();
        return students;
    }

    @Override
    public boolean saveStudent(Student student) {
        Session currentSession = sessionFactory.getCurrentSession();
        try {
            currentSession.save(student);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateStudent(Student student) {
        Session currentSession = sessionFactory.getCurrentSession();
        try {
            currentSession.update(student);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Student getStudentById(int id) {
        return sessionFactory.getCurrentSession().get(Student.class,id);
    }

    @Override
    public boolean deleteStudent(int id) {
        Student s = getStudentById(id);
        if(s!=null){
            try {
                sessionFactory.getCurrentSession().remove(s);
                return true;
            }
            catch (Exception e){return false;}
        }
        else {return false;}
    }
}
