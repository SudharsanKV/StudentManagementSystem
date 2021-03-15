package com.sms;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/stafflist")
public class staffList extends HttpServlet {
		public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			Staff staff = new Staff(request.getParameter("stname"), request.getParameter("stgender"), request.getParameter("stemailid"),
					request.getParameter("stmobile"), request.getParameter("stdoj"), Integer.parseInt(request.getParameter("stsalary")),
					request.getParameter("staddress"));
			session.setAttribute("staff", staff);
			RequestDispatcher rd= request.getRequestDispatcher("showstaff");
			rd.forward(request, response);
		}
}
class Staff{

	public String name;
	public String gender;
	public String emailid;
	public String mobile;
	public String doj;
	public int salary;
	public String address;
	
	public Staff(String name, String gender, String emailid, String mobile, String doj, int salary, String address) {
		this.name = name;
		this.gender = gender;
		this.emailid = emailid;
		this.mobile = mobile;
		this.doj = doj;
		this.address = address;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public String getGender() {
		return gender;
	}
	public String getEmailid() {
		return emailid;
	}
	public String getMobile() {
		return mobile;
	}
	public String getDoj() {
		return doj;
	}
	public String getAddress() {
		return address;
	}
	public int getSalary() {
		return salary;
	}
	
	
}