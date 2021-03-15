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

@WebServlet("/showstaff")
public class showStafflist extends HttpServlet {
	ArrayList<Staff> stafflist = new ArrayList<Staff>();
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServerException
	{

		HttpSession session = request.getSession();
		Staff staff = (Staff)session.getAttribute("staff");
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
				+ "            <h3 style=\"padding-top: 100px; margin-left: 45%; padding-bottom: 20px;\">Staff List</h3>\r\n"
				+ "        </div>\r\n"
				+ "        <div>\r\n"
				+ "            <table id=\"sdtable\" border=\"1\" cellpadding=\"15\" style=\"border-collapse: collapse; overflow-x: auto;\r\n"
				+ "            text-align: center; overflow-y: auto; margin-left: 500px;\">\r\n"
				+ "                <thead>\r\n"
				+ "                    <tr>\r\n"
				+ "                        <th rowspan=\"2\">Name</th>\r\n"
				+ "                        <th rowspan=\"2\">Gender</th>\r\n"
				+ "                        <th rowspan=\"2\">Email</th>\r\n"
				+ "                        <th rowspan=\"2\">Date of Joining</th>\r\n"
				+ "                        <th rowspan=\"2\">Salary</th>\r\n"
				+ "                    </tr>\r\n"
				+ "                </thead>\r\n"
				+ "                <tbody>\r\n"
		);
		if(staff!=null) {
			if(stafflist.isEmpty()&&staff.getName()!="") {
					stafflist.add(staff);
			}
			else {
				int j=0;
				if(stafflist.isEmpty()&&staff.getName()=="") {
					j=1;
				}
				for(int i=0; i<stafflist.size(); i++) {
					Staff object = stafflist.get(i); 
					if(object.getName().equals(staff.getName())&&object.getEmailid().equals(staff.getEmailid())) {
						j=1;
						break;
					}
					else if(staff.getName()=="") {
						j=1;
						break;
					}
				}
				if(j==0)
					stafflist.add(staff);
			}
			for(int i=0; i<stafflist.size();i++) {
				
				out.println("<tr>\r\n"
					+ "                        <td><a href=\"staffprofile?index="+i+"\" style=\"text-decoration: none;\" >"+stafflist.get(i).getName()+"</a></td>\r\n"
					+ "                        <td>"+stafflist.get(i).getGender()+"</td>\r\n"
					+ "                        <td>"+stafflist.get(i).getEmailid()+"</td>\r\n"
					+ "                        <td>"+stafflist.get(i).getDoj()+"</td>\r\n"
					+ "                        <td>"+stafflist.get(i).getSalary()+"</td>\r\n"
					+ "                    </tr>\r\n");					
				}
			session.setAttribute("stlist", stafflist);
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
