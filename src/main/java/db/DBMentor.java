package db;

import models.Mentor;
import models.Student;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class DBMentor {

    private static Session session;

    public static Student getStudentOfMentor(Mentor mentor){
        session = HibernateUtil.getSessionFactory().openSession();
        Student student = null;
        try {
            Criteria cr = session.createCriteria(Student.class);
            cr.add(Restrictions.eq("mentor", mentor));
            student = (Student) cr.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return student;
    }

}
