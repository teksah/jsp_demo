package com.sda.javagda34.webappdemo.services;

import com.sda.javagda34.webappdemo.database.EntityDao;
import com.sda.javagda34.webappdemo.model.Grade;
import com.sda.javagda34.webappdemo.model.GradeSubject;
import com.sda.javagda34.webappdemo.model.Student;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletRequest;
import java.util.Optional;


public class GradeService {
    private EntityDao<Grade> gradeEntityDao = new EntityDao<>();
    private EntityDao<Student> studentEntityDao = new EntityDao<>();

    public Optional<Grade> processFormParameters(ServletRequest req) {
        String studentId = req.getParameter("studentId");
        String gradeValue = req.getParameter("gradeValue");
        String subject = req.getParameter("subject");

        long id;
        double gValue;
        GradeSubject gradeSubject;

        try {
            id = Long.parseLong(studentId);
            gValue = Double.parseDouble(gradeValue);
            gradeSubject = GradeSubject.valueOf(subject);
        } catch (Exception e) {
            return Optional.empty();
        }

        Optional<Student> byId = studentEntityDao.findById(id, Student.class);

        if (byId.isPresent()) {
            Student student = byId.get();
            Grade grade = new Grade(null, gValue, gradeSubject,null, student);
        } else {

        }

        return Optional.empty();


    }
}
