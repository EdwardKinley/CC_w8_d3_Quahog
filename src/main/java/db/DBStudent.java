package db;

import models.Lesson;
import models.Student;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBStudent {

    private static Session session;

    public static List<Lesson> getLessonsOfStudent(Student student) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Lesson> lessons = null;
        try {
            Criteria cr = session.createCriteria(Lesson.class);
            cr.add(Restrictions.eq("course", student.getCourse()));
            lessons = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return lessons;
    }

}
