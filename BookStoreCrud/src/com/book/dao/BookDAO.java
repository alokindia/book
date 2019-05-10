package com.book.dao;

import java.sql.SQLException;
import java.util.List;

import com.book.model.Book;

public interface BookDAO {
void connect() throws SQLException, ClassNotFoundException;
List<Book> listAllBooks() throws SQLException;
}
