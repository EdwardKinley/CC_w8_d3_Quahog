package db;

import com.sun.xml.internal.xsom.impl.RestrictionSimpleTypeImpl;
import models.Lesson;
import models.Student;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBLesson {

    private static Session session;

    public static List<Student> getStudentsOfLesson(Lesson lesson) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Student> students = null;
        try {
            Criteria cr = session.createCriteria(Student.class);
            cr.add(Restrictions.eq("course", lesson.getCourse()));
            students = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return students;
    }


}
