package com.sms;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/edit")
public class editmarksServlet extends HttpServlet {
		public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 HttpSession session = request.getSession();
			 Student student = (Student) session.getAttribute("student_marks") ;
			 int sem1 = Integer.parseInt(request.getParameter("sem1"));
			 int sem2 = Integer.parseInt(request.getParameter("sem2"));
			 int sem3 = Integer.parseInt(request.getParameter("sem3"));
			 int sem4 = Integer.parseInt(request.getParameter("sem4"));
			 int sem5 = Integer.parseInt(request.getParameter("sem5"));
			 int sem6 = Integer.parseInt(request.getParameter("sem6"));
			 int sem7 = Integer.parseInt(request.getParameter("sem7"));
			 int sem8 = Integer.parseInt(request.getParameter("sem8"));
			 student.setMarks(sem1, sem2, sem3, sem4, sem5, sem6, sem7, sem8);
				RequestDispatcher rd= request.getRequestDispatcher("show");
				rd.forward(request, response);			 
		}
}
