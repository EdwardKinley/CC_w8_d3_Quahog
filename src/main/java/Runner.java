import db.*;
import models.*;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Course course1 = new Course("Maths", "BSc");

        Instructor instructor1 = new Instructor();
        Instructor instructor2 = new Instructor();

        Lesson lesson1 = new Lesson("statistics", 1, course1, instructor1);
        Lesson lesson2 = new Lesson("algebra", 2, course1, instructor2);
        Lesson lesson3 = new Lesson("calculus", 3, course1, instructor2);

        Mentor mentor1 = new Mentor("Stan");
        Mentor mentor2 = new Mentor("Roger");

        Student student1 = new Student("Edward", 40, 1, course1, mentor1);
        Student student2 = new Student("Keith", 35, 2, course1, mentor2);

        DBHelper.save(course1);
        DBHelper.save(instructor1);
        DBHelper.save(instructor2);
        DBHelper.save(lesson1);
        DBHelper.save(lesson2);
        DBHelper.save(lesson3);
        DBHelper.save(mentor1);
        DBHelper.save(mentor2);
        DBHelper.save(student1);
        DBHelper.save(student2);

        Mentor edwardsMentorStan = student1.getMentor();
        Course keithsCourseMaths = student2.getCourse();

        Student rogersStudentKeith = DBMentor.getStudentOfMentor(mentor2);

        List<Student> studentsOfCourse1 = DBCourse.getStudentsOfCourse(course1);
        List<Lesson> lessonsOfCourse1 = DBCourse.getLessonsOfCourse(course1);

        List<Lesson> lessonsofStudent1 = DBStudent.getLessonsOfStudent(student1);
        List<Lesson> lessonsofStudent2 = DBStudent.getLessonsOfStudent(student2);

        List<Student> studentsOfLesson2 = DBLesson.getStudentsOfLesson(lesson2);

        List<Lesson> lessonsOfInstructor1 = DBInstructor.getLessonsOfInstructor(instructor1);
        List<Lesson> lessonsOfInstructor2 = DBInstructor.getLessonsOfInstructor(instructor2);

        List<Student> studentsOfInstructor2 = DBInstructor.getStudentsOfInstructor(instructor2);

    }

}
