package com.sms;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/staffprofile")
public class staffProfile extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServerException
	{

		HttpSession session = request.getSession();
		ArrayList<Staff> staffList = new ArrayList<Staff>();
		staffList = (ArrayList<Staff>) session.getAttribute("stlist");
		int value1=Integer.parseInt(request.getParameter("index"));
		
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
				+ "            <a href=\"admin.editmarks.html\" style=\"text-decoration: none; font-size: 17px;\">Edit Marks</a>\r\n"
				+ "            <a href=\"admin.addstudent.html\" style=\"text-decoration: none; font-size: 17px;background-color: tomato;\r\n"
				+ "            color: rgb(59, 56, 55);\">Add Student</a>\r\n"
				+ "        </div>\r\n"
				+ "        <a id=\"dropdown\">Staff</a>\r\n"
				+ "        <div id=\"dropdown-container\">\r\n"
				+ "            <a  href=\"showstaff\" style=\"text-decoration: none; font-size: 15px;\">Staff List</a>\r\n"
				+ "            <a href=\"admin.addstaff.html\" style=\"text-decoration: none; font-size: 15px;\">Add Staff</a>\r\n"
				+ "        </div>\r\n"
				+ "        <a href=\"index.html\" onclick=\"preventReload()\" style=\"text-decoration: none;\">Logout</a>\r\n"
				+ "        <!-- <script type=\"text/javascript\">\r\n"
				+ "            function preventBack() { window.history.forward(); }\r\n"
				+ "            setTimeout(\"preventBack()\", 0);\r\n"
				+ "            window.onunload = function () { null };\r\n"
				+ "        </script> -->\r\n"
				+ "    </nav>\r\n"
				+ "    <section >\r\n"
				+ "        <div>\r\n"
				+ "            <h3 style=\"padding-top: 100px; margin-left: 45%;\">Profile</h3>\r\n"
				+ "        </div>\r\n"
				+ "            <div style=\"margin-left: 200px; \">\r\n"
				+ "        		  <b>Name:</b>  <span style=\"padding-left: 110px;\">"+staffList.get(value1).getName()+"</span><br><br><br>\r\n"
				+ "				  <b>Gender:</b> <span style=\"padding-left: 97px;\">"+staffList.get(value1).getGender()+"</span><br><br><br>\r\n"
				+ "				  <b>Email:</b> <span style=\"padding-left: 111px;\">"+staffList.get(value1).getEmailid()+"</span><br><br><hr>\r\n"
				+ "				  <b>Mobile no:</b>  <span style=\"padding-left: 80px;\">"+staffList.get(value1).getMobile()+"</span><br><br><br>\r\n"
				+ "				  <b>Date of Joining:</b>  <span style=\"padding-left: 40px;\">"+staffList.get(value1).getDoj()+"</span><br><br><br>\r\n"
				+ "				  <b>Salary:</b>  <span style=\"padding-left: 109px;\">"+staffList.get(value1).getSalary()+"</span><br><br><br>\r\n"
				+ "				  <b>Address:</b>  <span style=\"padding-left: 90px;\">"+staffList.get(value1).getAddress()+"</span><br><br><hr>\r\n"
				+ "           </div>\r\n"
				+ "         </form>"
				+ "    </section>\r\n"
				+ "</body>\r\n"
				+ "</html>");
	}
}
