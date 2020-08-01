package com.sda.javagda34.webappdemo.servlets;

import com.sda.javagda34.webappdemo.model.Grade;
import com.sda.javagda34.webappdemo.services.GradeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/grade/add")
public class GradeAddController extends HttpServlet {
    private GradeService gradeService = new GradeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/gradeForm.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Optional<Grade> grade = gradeService.processFormParameters(req);

    }
}
