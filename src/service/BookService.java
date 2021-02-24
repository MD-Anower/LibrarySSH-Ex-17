package service;

import java.util.List;

import dao.BookCategoryDao;
import dao.BookDao;
import entity.Book;
import entity.BookCategory;

public class BookService {
	
	private BookDao bookDao;
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public void add(Book book){
		 this.bookDao.add(book);
	}
	
    public void update(Book book){
		this.bookDao.update(book);
	}

    public void delete(Book book){
	     this.bookDao.delete(book);
    }
    
    public List<Book> findAll(Book book){
    	return this.bookDao.findAll();
    }
    public List<Book> findByKeyword(String keyword){
    	return this.bookDao.findByKeyword(keyword);
    }
}
