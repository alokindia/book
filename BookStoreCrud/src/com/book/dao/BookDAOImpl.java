package com.book.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.book.model.Book;



public class BookDAOImpl implements BookDAO{
	Connection jdbcConnection=null;
		private String jdbcDriver;
			private String jdbcUsername;
			private String jdbcpassword;
			private String jdbcURL;
			public BookDAOImpl(String jdbcDriver, String jdbcUsername, String jdbcpassword, String jdbcURL) {
				super();
				this.jdbcDriver = jdbcDriver;
				this.jdbcUsername = jdbcUsername;
				this.jdbcpassword = jdbcpassword;
				this.jdbcURL = jdbcURL;
				System.out.println(jdbcDriver+"+++++++++"+jdbcUsername+"+++++++++"+ jdbcpassword+"++++++++"+jdbcURL);
			}
			public BookDAOImpl() {
				super();
				// TODO Auto-generated constructor stub
			}
			
		 
		  
		public void connect() throws SQLException {
				// TODO Auto-generated method stub
				
				if(jdbcConnection==null || jdbcConnection.isClosed())
				{
					try {
						Class.forName(jdbcDriver);
						jdbcConnection=DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcpassword);
						System.out.println(jdbcConnection);
					} catch (ClassNotFoundException e) {
						
						e.printStackTrace();
					}
					
				}
			}
		public Book findABook(int id) throws SQLException
		{
			Book b=new Book();
			PreparedStatement ps=jdbcConnection.prepareStatement("select * from book where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				b.setId(rs.getInt("id"));
				b.setTitle(rs.getString("title"));
				b.setAuthor(rs.getString("author"));
				b.setPrice(rs.getString("price"));
			}
			return b;
		}
		
	
		@Override
		public List<Book> listAllBooks() {
			ArrayList<Book> lb=new ArrayList<>();
		try {
			connect();
			String GetBooks="Select * from book";
		
			PreparedStatement ps= jdbcConnection.prepareStatement(GetBooks);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				com.book.model.Book book=new Book();
				book.setId(rs.getInt("id"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getString("price"));
				System.out.println("ID:"+rs.getInt("id")+"||Title:"+rs.getString("title")+"||Author:"+rs.getString("author")+"||Price:"+rs.getString("price"));
				lb.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return lb;
		}  

		 

}
