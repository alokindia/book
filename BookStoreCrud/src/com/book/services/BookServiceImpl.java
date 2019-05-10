package com.book.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.dao.BookDAOImpl;
import com.book.model.Book;

public class BookServiceImpl implements BookService{
	BookDAOImpl bd;
	public BookServiceImpl(String jdbcDriver, String jdbcUsername, String jdbcPassword,String jdbcURL )
	{
		super();
		bd=new BookDAOImpl(jdbcDriver,jdbcUsername,jdbcPassword,jdbcURL);
		
	}
	public BookServiceImpl()
	{super();}
	@Override
	public void getAllBooks(HttpServletRequest request, HttpServletResponse response)
	{
		
		List<Book> lb=bd.listAllBooks();
		request.setAttribute("listbook", lb);
		System.out.println("Within getbooks : services ");
		RequestDispatcher dispatcher=request.getRequestDispatcher("BookList.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	@Override
	public void connect() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void showEditForm(HttpServletRequest request,
			HttpServletResponse response) throws SQLException, ServletException, IOException  {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		Book existingBook=bd.findABook(id);
		RequestDispatcher dispatcher=request.getRequestDispatcher("BookForm.jsp");
		request.setAttribute("book",existingBook);
		dispatcher.forward(request,response);
	}
}
