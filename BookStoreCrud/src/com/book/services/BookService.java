package com.book.services;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BookService {
 void getAllBooks(HttpServletRequest request, HttpServletResponse response);
 void connect();
 void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException;
}
