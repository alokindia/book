package com.book.controller;
import com.book.services.BookService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.model.Book;
import com.book.services.BookServiceImpl;

/**
 * Servlet implementation class BookController
 */
@WebServlet("/")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    BookServiceImpl bs;
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		String jdbcDriver=getServletContext().getInitParameter("driver");
		String jdbcUsername=getServletContext().getInitParameter("jdbcusername");
		String jdbcPassword=getServletContext().getInitParameter("jdbcpassword");
		String jdbcURL=getServletContext().getInitParameter("url");
		bs = new BookServiceImpl(jdbcDriver,jdbcUsername,jdbcPassword,jdbcURL);
		System.out.println("Driver ="+jdbcDriver);
		System.out.println("Username ="+jdbcUsername);
		System.out.println("password ="+jdbcPassword);
		System.out.println("url ="+jdbcURL); 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getServletPath();
		switch(action)
		{
		case "/list": {System.out.println("I am the list");
						break;}
		default:
			bs.getAllBooks(request,response);	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}















