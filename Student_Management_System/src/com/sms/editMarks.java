package com.sms;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/enter")
public class editMarks extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Student student = (Student)session.getAttribute("student_marks");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>add-student</title>\r\n"
				+ "    <link rel=\"stylesheet\" href=\"css/header.css\">\r\n"
				+ "    <style>\r\n"
				+ "        #dropdown-container1{\r\n"
				+ "            display: block;\r\n"
				+ "            cursor: pointer;\r\n"
				+ "            padding-left: 10px;\r\n"
				+ "        }\r\n"
				+ "    </style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <header>\r\n"
				+ "        <h1>Student Management System</h1>\r\n"
				+ "    </header>\r\n"
				+ "    <!-- <img src=\"/Images/addstudent.png\" alt=\"\"> -->\r\n"
				+ "    <nav class=\"sidenav\">\r\n"
				+ "        <a href=\"admin.home.html\" style=\"text-decoration: none;\" >Home</a>\r\n"
				+ "        <a id=\"dropdown\" style=\"background-color: tomato;color: rgb(59, 56, 55);\">Student</a>\r\n"
				+ "        <div id=\"dropdown-container1\">\r\n"
				+ "            <a href=\"show\" style=\"text-decoration: none; font-size: 17px;\">Student List</a>\r\n"
				+ "            <a href=\"admin.addstudent.html\" style=\"text-decoration: none; font-size: 17px;background-color: tomato;\r\n"
				+ "            color: rgb(59, 56, 55);\">Add Student</a>\r\n"
				+ "        </div>\r\n"
				+ "        <a id=\"dropdown\">Staff</a>\r\n"
				+ "        <div id=\"dropdown-container\">\r\n"
				+ "            <a href=\"showstaff\" style=\"text-decoration: none; font-size: 15px;\">Staff List</a>\r\n"
				+ "            <a href=\"admin.addstaff.html\" style=\"text-decoration: none; font-size: 15px;\">Add Staff</a>\r\n"
				+ "        </div>\r\n"
				+ "        <a href=\"index.html\" onclick=\"preventReload()\" style=\"text-decoration: none;\">Logout</a>\r\n"
				+ "    </nav>\r\n"
				+ "    <section >\r\n"
				+ "        <div>\r\n"
				+ "            <h3 style=\"padding-top: 100px; margin-left: 45%;\">Enter Marks</h3>\r\n"
				+ "        </div>\r\n"
				+ "        <div style=\"margin-left: 200px; \">\r\n"
				+ "        <form action=\"edit\" method=\"POST\" >\r\n"
				+ "         	<label for=\"sem1\">Semester 1</label><br>\r\n"
				+ "        	<input type=\"text\" id=\"sem1\" name=\"sem1\" maxlength=\"2\" max=\"100\" min=\"0\" value=\""+student.getSem1()+"\"><br><br>\r\n"
				+ "         	<label for=\"sem2\">Semester 2</label><br>\r\n"
				+ "        	<input type=\"text\" id=\"sem2\" name=\"sem2\" maxlength=\"2\" max=\"100\" min=\"0\" value=\""+student.getSem2()+"\"><br><br>\r\n"
				+ "         	<label for=\"sem3\">Semester 3</label><br>\r\n"
				+ "        	<input type=\"text\" id=\"sem3\" name=\"sem3\" maxlength=\"2\" max=\"100\" min=\"0\" value=\""+student.getSem3()+"\"><br><br>\r\n"
				+ "         	<label for=\"sem4\">Semester 4</label><br>\r\n"
				+ "        	<input type=\"text\" id=\"sem4\" name=\"sem4\" maxlength=\"2\" max=\"100\" min=\"0\" value=\""+student.getSem4()+"\"><br><br>\r\n"
				+ "         	<label for=\"sem5\">Semester 5</label><br>\r\n"
				+ "        	<input type=\"text\" id=\"sem5\" name=\"sem5\" maxlength=\"2\" max=\"100\" min=\"0\" value=\""+student.getSem5()+"\"><br><br>\r\n"
				+ "         	<label for=\"sem6\">Semester 6</label><br>\r\n"
				+ "        	<input type=\"text\" id=\"sem6\" name=\"sem6\" maxlength=\"2\" max=\"100\" min=\"0\" value=\""+student.getSem6()+"\"><br><br>\r\n"
				+ "         	<label for=\"sem7\">Semester 7</label><br>\r\n"
				+ "        	<input type=\"text\" id=\"sem7\" name=\"sem7\" maxlength=\"2\" max=\"100\" min=\"0\" value=\""+student.getSem7()+"\"><br><br>\r\n"
				+ "         	<label for=\"sem8\">Semester 8</label><br>\r\n"
				+ "        	<input type=\"text\" id=\"sem8\" name=\"sem8\" maxlength=\"2\" max=\"100\" min=\"0\" value=\""+student.getSem8()+"\"><br><br>\r\n"
				+ "             <input type=\"submit\">\r\n"
				+ "             </form>\r\n"
				+ "        </div>\r\n"
				+ "    </section>\r\n"
				+ "</body>\r\n"
				+ "</html>");
	}
}
