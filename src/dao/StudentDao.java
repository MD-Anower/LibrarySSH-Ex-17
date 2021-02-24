package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateSessionFactory;
import entity.Book;
import entity.BookCategory;
import entity.Student;

public class StudentDao {
	
	 public void add(Student student){
	    	Session session= HibernateSessionFactory.getSession();
	    	Transaction tran= session.beginTransaction();
	    	
	    	
	    	session.save(student);
	    	tran.commit();
	    	session.close();
	      }
	      
	      public void update(Student student){
	      	Session session= HibernateSessionFactory.getSession();
	      	Transaction tran= session.beginTransaction();
	      	
	    	
	      	session.update(student);
	      	tran.commit();
	      	session.close();
	        }
	      
	      public void delete(Student student){
	        	Session session= HibernateSessionFactory.getSession();
	        	Transaction tran= session.beginTransaction();
	        	
	        	session.delete(student);
	        	tran.commit();
	        	session.close();
	          }
	      
	      public List<Student> findAll(){
	        	Session session= HibernateSessionFactory.getSession();
	        	Transaction tran= session.beginTransaction();
	        	
	        	String hql="from Student";
	        	Query query= session.createQuery(hql);
	        	List<Student> list= query.list();
	        	
	        	tran.commit();
	        	session.close();
	        	return list;
	          }
	      public List<Student> findByKeyword(String keyword){
	        	Session session= HibernateSessionFactory.getSession();
	        	Transaction tran= session.beginTransaction();
	        	
	        	String hql="from Student where Name like '%s'";
	        		hql=String.format(hql,"%"+keyword+"%");
	        	Query query= session.createQuery(hql);
	        	List<Student> list= query.list();
	        	
	        	tran.commit();
	        	session.close();
	        	return list;
	          }
}
