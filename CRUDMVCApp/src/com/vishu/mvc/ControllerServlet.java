package com.vishu.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ControllerServlet
 */
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside doGet()");
		process(request,response);
	}
     
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside process()");
		String uri = request.getRequestURI();
		RequestDispatcher rd=null;
		System.out.println("uri = "+uri);
		if(uri.contains("/openRegisterView"))
		{
			rd = request.getRequestDispatcher("/Register.jsp");
			rd.forward(request, response);
		}
		if(uri.contains("/openLoginView"))
		{
			rd = request.getRequestDispatcher("/Login.jsp");
			rd.forward(request, response);
		}
		if(uri.contains("/register"))
		{
			System.out.println("inside /register if block");
			Model m = new Model();
			RegBean rb = (RegBean)request.getAttribute("reg");
			String result=m.register(rb);
			if(result.equals(Constants.SUCCESS))
			{
				rd = request.getRequestDispatcher("/Success.jsp");
				rd.forward(request, response);
			}
			else
			{ 
				request.setAttribute("errorMsg", result);
				rd = request.getRequestDispatcher("/Register.jsp");
				rd.forward(request, response);
			}
			
		}
		
		
		
		
		if(uri.contains("/login"))
		{
			System.out.println("inside /login if block");
			Model m = new Model();
			LoginBean lb = (LoginBean)request.getAttribute("user");
			String result=m.authenticate(lb);
			if(result.equals(Constants.SUCCESS))
			{
				HttpSession s = request.getSession(true);
				s.setAttribute("userId", lb.getEmail());
				rd = request.getRequestDispatcher("/Menu.jsp");
				rd.forward(request, response);
			}
			else
			{ 
				request.setAttribute("errorMsg", result);
				rd = request.getRequestDispatcher("/Login.jsp");
				rd.forward(request, response);
			}
			
		}
		
		
		if(uri.contains("/logout"))
		{
			HttpSession s = request.getSession(false);
			if(s==null)
			{
				
			}
			else
			{
				s.removeAttribute("userId");
				s.invalidate();
			}
			response.sendRedirect("HomePage.html");
		}
		
		if(uri.contains("/openEditAccView"))
		{
			System.out.println("inside if block /openEditAccview");
			Model m = new Model();
			HttpSession s = request.getSession(false);
			if(s==null)
			{
				request.setAttribute("errorMsg", "Your Session has expired please login again to continue");
				rd = request.getRequestDispatcher("/Error.jsp");
				rd.forward(request, response);
			}
			else
			{
				String email =(String) s.getAttribute("userId");
				RegBean ub = m.getDetails(email);
				request.setAttribute("userDetails",ub);
				rd = request.getRequestDispatcher("/EditAccount.jsp");
				rd.forward(request, response);
			}
			
			
		}
			
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside doPost()");
		process(request,response);
	}

}
