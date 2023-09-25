package com.mainproject.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mainproject.dao.AdminDao;
import com.mainproject.model.Admin;
import com.mainproject.model.User;


@WebServlet("/")
public class Myservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Myservlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getServletPath();
		switch(path) {
		case "/validate":validateAdmin(request,response);
						 break;
		case "/user" :   userlist(request,response);
						 break;
		case "/userform" :userform(request,response);
						 break;
		case "/insert" : insertuser(request,response);
					  	 break;
		case "/delete" : deleteUserByid(request,response);
						 break;
		case "/edit" : selectUserByid(request,response);
						 break;
		case "/update": updateuser(request,response);
						 break;
		default:Loginpage(request,response);
		}
		
	}

		private void updateuser(HttpServletRequest request, HttpServletResponse response) {
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String city=request.getParameter("city");
		String email=request.getParameter("email");
		User u = new  User(id, name,city,email);
	    AdminDao.updateUser(u);
	    try {
			response.sendRedirect("user");
  			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


		private void selectUserByid(HttpServletRequest request, HttpServletResponse response) {
		
			int id =Integer.parseInt(request.getParameter("id"));
			User u =AdminDao.selectuser(id);
			request.setAttribute("list", u);
			RequestDispatcher rd = request.getRequestDispatcher("userform.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			

	}


		private void deleteUserByid(HttpServletRequest request, HttpServletResponse response) {
		   
			int id = Integer.parseInt(request.getParameter("id"));
			AdminDao.deleteuser(id);
			
			try {
				response.sendRedirect("user");
      			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}


		private void insertuser(HttpServletRequest request, HttpServletResponse response) {
		String name =request.getParameter("name");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		
		User u  = new User(name, email, city);
		AdminDao.insertUser(u);
		
		try {
			response.sendRedirect("user");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


		private void userform(HttpServletRequest request, HttpServletResponse response) {
			RequestDispatcher rd = request.getRequestDispatcher("userform.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}


		private void userlist(HttpServletRequest request, HttpServletResponse response) {
			
			ArrayList<User> us = AdminDao.displayUser();
			request.setAttribute("display", us);
			
			RequestDispatcher rd = request.getRequestDispatcher("user.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}


		private void validateAdmin(HttpServletRequest request, HttpServletResponse response) {
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			Admin a = new Admin(username, password);
			
			String status = AdminDao.validate(a);
			if(status.equals("success")) {
				RequestDispatcher rd = request.getRequestDispatcher("user");
				try {
					rd.forward(request, response);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				else {
					RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
					try {
						rd.forward(request, response);
					} catch (ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		



		private void Loginpage(HttpServletRequest request, HttpServletResponse response) {
		
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}


		


		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

