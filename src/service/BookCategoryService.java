package service;

import java.util.List;

import dao.BookCategoryDao;
import entity.BookCategory;

public class BookCategoryService {
	
	private BookCategoryDao bookCategoryDao;
	public void setBookCategoryDao(BookCategoryDao bookCategoryDao) {
		this.bookCategoryDao = bookCategoryDao;
	}

	public void add(BookCategory bookCategory){
		 this.bookCategoryDao.add(bookCategory);
	}
	
    public void update(BookCategory bookCategory){
		this.bookCategoryDao.update(bookCategory);
	}

    public void delete(BookCategory bookCategory){
	     this.bookCategoryDao.delete(bookCategory);
    }
    
    public List<BookCategory> findAll(BookCategory bookCategory){
    	return this.bookCategoryDao.findAll();
    }
    public List<BookCategory> findByKeyword(String keyword){
    	return this.bookCategoryDao.findByKeyword(keyword);
    }
}
