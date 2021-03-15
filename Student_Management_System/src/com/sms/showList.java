package com.sms;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/show")
public class showList extends HttpServlet {
	
	ArrayList<Student> list = new ArrayList<Student>();
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServerException
	{

		HttpSession session = request.getSession();
		Student student = (Student)session.getAttribute("student");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>student-list</title>\r\n"
				+ "    <link rel=\"stylesheet\" href=\"css/header.css\">\r\n"
				+ "    <style>\r\n"
				+ "    #dropdown-container1{\r\n"
				+ "        display: block;\r\n"
				+ "        cursor: pointer;\r\n"
				+ "        padding-left: 10px;\r\n"
				+ "    }\r\n"
				+ "    </style>\r\n"
				+ "</head>\r\n"
				+ "<body >\r\n"
				+ "    <header >\r\n"
				+ "        <h1>Student Management System</h1>\r\n"
				+ "    </header>\r\n"
				+ "    <!-- <img src=\"/Images/studentlist.jpg\"  alt=\"Student List\"> -->\r\n"
				+ "    <nav class=\"sidenav\">\r\n"
				+ "        <a href=\"admin.home.html\" style=\"text-decoration: none;\" >Home</a>\r\n"
				+ "        <a id=\"dropdown\" style=\"background-color: tomato;color: rgb(59, 56, 55);\">Student</a>\r\n"
				+ "        <div id=\"dropdown-container1\">\r\n"
				+ "            <a href=\"show\" style=\"text-decoration: none; font-size: 17px;background-color: tomato;\r\n"
				+ "            color: rgb(59, 56, 55);\">Student List</a>\r\n"
				+ "            <a href=\"admin.addstudent.html\" style=\"text-decoration: none; font-size: 17px;\">Add Student</a>\r\n"
				+ "        </div>\r\n"
				+ "        <a id=\"dropdown\">Staff</a>\r\n"
				+ "        <div id=\"dropdown-container\">\r\n"
				+ "            <a href=\"showstaff\" style=\"text-decoration: none; font-size: 15px;\">Staff List</a>\r\n"
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
				+ "            <h3 style=\"padding-top: 100px; margin-left: 45%; padding-bottom: 20px;\">Student List</h3>\r\n"
				+ "        </div>\r\n"
				+ "        <div>\r\n"
				+ "            <table id=\"sdtable\" border=\"1\" cellpadding=\"15\" style=\"border-collapse: collapse; overflow-x: auto;\r\n"
				+ "            text-align: center; overflow-y: auto; margin-left: 200px;\">\r\n"
				+ "                <thead>\r\n"
				+ "                    <tr>\r\n"
				+ "                        <th rowspan=\"2\">Name</th>\r\n"
				+ "                        <th rowspan=\"2\">Gender</th>\r\n"
				+ "                        <th rowspan=\"2\">Department</th>\r\n"
				+ "                        <th rowspan=\"2\">Email</th>\r\n"
				+ "                        <th colspan=\"8\">Semester Marks\r\n"
				+ "                            <tr id=\"semrow\">\r\n"
				+ "                                <th>I<sup>st</sup> sem</th>\r\n"
				+ "                                <th>II<sup>nd</sup> sem</th>\r\n"
				+ "                                <th>III<sup>rd</sup> sem</th>\r\n"
				+ "                                <th>IV<sup>th</sup> sem</th>\r\n"
				+ "                                <th>V<sup>th</sup> sem</th>\r\n"
				+ "                                <th>VI<sup>th</sup> sem</th>\r\n"
				+ "                                <th>VII<sup>th</sup> sem</th>\r\n"
				+ "                                <th>VIII<sup>th</sup> sem</th>\r\n"
				+ "                            </tr>\r\n"
				+ "                        </th>\r\n"
				+ "                    </tr>\r\n"
				+ "                </thead>\r\n"
				+ "                <tbody>\r\n"
		);
		if(student!=null) {
			if(list.isEmpty()&&student.getName()!="") {
					list.add(student);
			}
			else {
				int j=0;
				if(list.isEmpty()&&student.getName()=="") {
					j=1;
				}
				for(int i=0; i<list.size(); i++) {
					Student object = list.get(i); 
					if(object.getName().equals(student.getName())&&object.getEmailid().equals(student.getEmailid())) {
						j=1;
						break;
					}
					else if(student.getName()=="") {
						j=1;
						break;
					}
				}
				if(j==0)
					list.add(student);
			}
			for(int i=0; i<list.size();i++) {
				
				out.println("<tr>\r\n"
					+ "                        <td><a href=\"profile?index="+i+"\" style=\"text-decoration: none;\" >"+list.get(i).getName()+"</a></td>\r\n");
//				session.setAttribute("list", list.get(i));
				out.println(
					"                        <td>"+list.get(i).getGender()+"</td>\r\n"
					+ "                        <td>"+list.get(i).getDepartment()+"</td>\r\n"
					+ "                        <td>"+list.get(i).getEmailid()+"</td>\r\n"
					+ "                        <td>"+list.get(i).getSem1()+"</td>\r\n"
					+ "                        <td>"+list.get(i).getSem2()+"</td>\r\n"
					+ "                        <td>"+list.get(i).getSem3()+"</td>\r\n"
					+ "                        <td>"+list.get(i).getSem4()+"</td>\r\n"	
					+ "                        <td>"+list.get(i).getSem5()+"</td>\r\n"
					+ "                        <td>"+list.get(i).getSem6()+"</td>\r\n"
					+ "                        <td>"+list.get(i).getSem7()+"</td>\r\n"
					+ "                        <td>"+list.get(i).getSem8()+"</td>\r\n"
					+ "                    </tr>\r\n");					
				}
			session.setAttribute("list", list);
		}
		out.println(
				  "                </tbody>\r\n"
				+ "            </table>\r\n"
				+ "        </div>\r\n"
				+ "    </section>\r\n"
				+ "    <div id=\"firstperson\" style=\"display: none;\">\r\n"
				+ "        Name:\r\n"
				+ "    </div>\r\n"
				+ "</body>\r\n"
				+ "</html>");
	}
}
