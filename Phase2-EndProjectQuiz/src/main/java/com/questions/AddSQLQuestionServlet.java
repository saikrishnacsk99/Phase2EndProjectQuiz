package com.questions;

import java.io.IOException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.user.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addsqlquestion")
public class AddSQLQuestionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String question = request.getParameter("question");
        String option1 = request.getParameter("option1");
        String option2 = request.getParameter("option2");
        String option3 = request.getParameter("option3");
        String option4 = request.getParameter("option4");
        int correctOption = Integer.parseInt(request.getParameter("correctOption"));

        // Create a new SQLQuestion object and set the values
        SQLQuestion sqlQuestion = new SQLQuestion();
        sqlQuestion.setQuestion(question);
        sqlQuestion.setOption1(option1);
        sqlQuestion.setOption2(option2);
        sqlQuestion.setOption3(option3);
        sqlQuestion.setOption4(option4);
        sqlQuestion.setCorrectOption(correctOption);

        // Save the SQLQuestion object to the database using Hibernate
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(sqlQuestion);
            try {
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                // Log the exception using your logging framework
                e.printStackTrace();
            }
        }

        response.sendRedirect("Addquestion.jsp");
    }
}
