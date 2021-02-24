package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateSessionFactory;
import entity.Book;
import entity.BookCategory;

public class BookDao {
	
	 public void add(Book book){
	    	Session session= HibernateSessionFactory.getSession();
	    	Transaction tran= session.beginTransaction();
	    	
	    	BookCategory category=(BookCategory)session.get(BookCategory.class, book.getCategoryId());
	    	book.setCategory(category);
	    	
	    	session.save(book);
	    	tran.commit();
	    	session.close();
	      }
	      
	      public void update(Book book){
	      	Session session= HibernateSessionFactory.getSession();
	      	Transaction tran= session.beginTransaction();
	      	
	      	BookCategory category=(BookCategory)session.get(BookCategory.class, book.getCategoryId());
	    	book.setCategory(category);
	    	
	      	session.update(book);
	      	tran.commit();
	      	session.close();
	        }
	      
	      public void delete(Book book){
	        	Session session= HibernateSessionFactory.getSession();
	        	Transaction tran= session.beginTransaction();
	        	
	        	session.delete(book);
	        	tran.commit();
	        	session.close();
	          }
	      
	      public List<Book> findAll(){
	        	Session session= HibernateSessionFactory.getSession();
	        	Transaction tran= session.beginTransaction();
	        	
	        	String hql="from Book";
	        	Query query= session.createQuery(hql);
	        	List<Book> list= query.list();
	        	
	        	tran.commit();
	        	session.close();
	        	return list;
	          }
	      public List<Book> findByKeyword(String keyword){
	        	Session session= HibernateSessionFactory.getSession();
	        	Transaction tran= session.beginTransaction();
	        	
	        	String hql="from Book where bookName like '%s'or remark like '%s' or description like '%s'";
	        		hql=String.format(hql,"%"+keyword+"%", "%"+keyword+"%" , "%"+keyword+"%");
	        	Query query= session.createQuery(hql);
	        	List<Book> list= query.list();
	        	
	        	tran.commit();
	        	session.close();
	        	return list;
	          }
}
