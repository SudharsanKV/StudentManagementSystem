package com.sms;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/list")
public class studentList extends HttpServlet {
	
	public void service (HttpServletRequest request, HttpServletResponse response) throws IOException, ServerException,ServletException
	{
		
		HttpSession session = request.getSession();
		Student student = new Student(request.getParameter("sdname"), request.getParameter("sdgender"), request.getParameter("sddept"), request.getParameter("sdemailid"),
				request.getParameter("sdfname"), request.getParameter("sdfmobile"), request.getParameter("sdmname"), request.getParameter("sdmmobile"),
				request.getParameter("sdaddress"));
		student.setMarks(0,0,0,0,0,0,0,0);
		session.setAttribute("student", student);
		RequestDispatcher rd= request.getRequestDispatcher("show");
		rd.forward(request, response);
	}
}
class Student{
	public String name;
	public String gender;
	public String department;
	public String emailid;
	public String father_name;
	public String father_mobile;
	public String mother_name;
	public String mother_mobile;
	public String address;
	public int sem1;
	public int sem2;
	public int sem3;
	public int sem4;
	public int sem5;
	public int sem6;
	public int sem7;
	public int sem8;
	
	public Student (String name, String gender, String department, String emailid, String father, String fathermobile,
	String mother, String mothermobile, String address) 
	{
		this.name=name;
		this.gender=gender;
		this.department=department;
		this.emailid=emailid;
		this.father_name=father;
		this.father_mobile=fathermobile;
		this.mother_name=mother;
		this.mother_mobile=mothermobile;
		this.address=address;
	}
	public void setMarks(int sem1, int sem2, int sem3, int sem4, int sem5, int sem6, int sem7, int sem8) {
		this.sem1=sem1;
		this.sem2=sem2;
		this.sem3=sem3;
		this.sem4=sem4;
		this.sem5=sem5;
		this.sem6=sem6;
		this.sem7=sem7;
		this.sem8=sem8;
	}
	public int getSem1() {
		return sem1;
	}
	public int getSem2() {
		return sem2;
	}
	public int getSem3() {
		return sem3;
	}
	public int getSem4() {
		return sem4;
	}
	public int getSem5() {
		return sem5;
	}
	public int getSem6() {
		return sem6;
	}
	public int getSem7() {
		return sem7;
	}
	public int getSem8() {
		return sem8;
	}
	public String getName() {
		return name;
	}
	public String getGender() {
		return gender;
	}
	public String getDepartment() {
		return department;
	}
	public String getEmailid() {
		return emailid;
	}
	public String getFather_name() {
		return father_name;
	}
	public String getFather_mobile() {
		return father_mobile;
	}
	public String getMother_name() {
		return mother_name;
	}
	public String getMother_mobile() {
		return mother_mobile;
	}
	public String getAddress() {
		return address;
	}
		
}
