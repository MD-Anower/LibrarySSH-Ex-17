package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateSessionFactory;
import entity.BookCategory;

public class BookCategoryDao {
	
	 public void add(BookCategory bookCategory){
	    	Session session= HibernateSessionFactory.getSession();
	    	Transaction tran= session.beginTransaction();
	    	
	    	session.save(bookCategory);
	    	tran.commit();
	    	session.close();
	      }
	      
	      public void update(BookCategory bookCategory){
	      	Session session= HibernateSessionFactory.getSession();
	      	Transaction tran= session.beginTransaction();
	      	
	      	session.update(bookCategory);
	      	tran.commit();
	      	session.close();
	        }
	      
	      public void delete(BookCategory bookCategory){
	        	Session session= HibernateSessionFactory.getSession();
	        	Transaction tran= session.beginTransaction();
	        	
	        	session.delete(bookCategory);
	        	tran.commit();
	        	session.close();
	          }
	      
	      public List<BookCategory> findAll(){
	        	Session session= HibernateSessionFactory.getSession();
	        	Transaction tran= session.beginTransaction();
	        	
	        	String hql="from BookCategory";
	        	Query query= session.createQuery(hql);
	        	List<BookCategory> list= query.list();
	        	
	        	tran.commit();
	        	session.close();
	        	return list;
	          }
	      public List<BookCategory> findByKeyword(String keyword){
	        	Session session= HibernateSessionFactory.getSession();
	        	Transaction tran= session.beginTransaction();
	        	
	        	String hql="from BookCategory where CategoryName like '%s'or remark like '%s'";
	        		hql=String.format(hql,"%"+keyword+"%", "%"+keyword+"%");
	        	Query query= session.createQuery(hql);
	        	List<BookCategory> list= query.list();
	        	
	        	tran.commit();
	        	session.close();
	        	return list;
	          }
}
