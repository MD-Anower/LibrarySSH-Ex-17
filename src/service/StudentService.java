package service;

import java.util.List;

import dao.BookCategoryDao;
import dao.BookDao;
import dao.StudentDao;
import entity.Book;
import entity.BookCategory;
import entity.Student;

public class StudentService {
	
	private StudentDao studentDao;
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public void add(Student student){
		 this.studentDao.add(student);
	}
	
    public void update(Student student){
		this.studentDao.update(student);
	}

    public void delete(Student student){
	     this.studentDao.delete(student);
    }
    
    public List<Student> findAll(Student student){
    	return this.studentDao.findAll();
    }
    public List<Student> findByKeyword(String keyword){
    	return this.studentDao.findByKeyword(keyword);
    }
}
