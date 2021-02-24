package dao;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateSessionFactory;
import entity.Book;
import entity.User;

public class UserDao {
	
	 public void register(User user){
	    	add(user);
	      }
	 public boolean login(User user){
		Session session= HibernateSessionFactory.getSession();
     	Transaction tran= session.beginTransaction();
     	
     	String hql="from User where userName='%s' and password='%s'";
     	hql= String.format(hql, user.getUserName(), user.getPassword());
     	Query query= session.createQuery(hql);
     	List<User> list= query.list();
   
     	tran.commit();
     	session.close();
     	
     	if(list!=null && list.size()>0)
     		return true;
     	else
     		return false;
    
	 }
      public void add(User user){
    	Session session= HibernateSessionFactory.getSession();
    	Transaction tran= session.beginTransaction();
    	
    	session.save(user);
    	tran.commit();
    	session.close();
      }
      
      public void update(User user){
      	Session session= HibernateSessionFactory.getSession();
      	Transaction tran= session.beginTransaction();
      	
      	session.update(user);
      	tran.commit();
      	session.close();
        }
      
      public void delete(User user){
        	Session session= HibernateSessionFactory.getSession();
        	Transaction tran= session.beginTransaction();
        	
        	session.delete(user);
        	tran.commit();
        	session.close();
          }
      
      public User findById(Integer id){
      	Session session= HibernateSessionFactory.getSession();
      	Transaction tran= session.beginTransaction();
      	
      	User user=(User)session.get(User.class, id);
      	
      	tran.commit();
      	session.close();
      	return user;
        }
      public User findByUserName(String userName){
  	    Session session= HibernateSessionFactory.getSession();
	       	Transaction tran= session.beginTransaction();
	   		
	   		String hql = "from User where UserName='%s'";
	   		hql = String.format(hql, userName);
	   				
	   		Query query= session.createQuery(hql);
	   		List<User> list= query.list();
	   				
	   		tran.commit();
	   		session.close();
	   		
	   		if (list.size() > 0)
	   			return list.get(0);
	   		else
	   			return null;
        }
      
      public List<User> findAll(){
        	Session session= HibernateSessionFactory.getSession();
        	Transaction tran= session.beginTransaction();
        	
        	String hql="from User";
        	Query query= session.createQuery(hql);
        	List<User> list= query.list();
        	
        	tran.commit();
        	session.close();
        	return list;
          }
         public List<User> findByKeyword(String keyword){
        	Session session= HibernateSessionFactory.getSession();
        	Transaction tran= session.beginTransaction();
        	
        	String hql="from User where userName like '%s'";
        		hql=String.format(hql,"%"+keyword+"%");
        	Query query= session.createQuery(hql);
        	List<User> list= query.list();
        	
        	tran.commit();
        	session.close();
        	return list;
          }
      
         public Boolean  isPasswordRight(String userName, String oldPassword){
        	Session session= HibernateSessionFactory.getSession();
         	Transaction tran= session.beginTransaction();
     		boolean isSuccess = false;
     		String hql = "from User where UserName='%s' and Password='%s'";
     		hql = String.format(hql, userName,oldPassword);
     				
     		Query query= session.createQuery(hql);
     		List<User> list= query.list();
     		
     		tran.commit();
     		session.close();
     		if (list.size() > 0)
     			isSuccess = true;
     		else
     			isSuccess = false;
     		
     		return isSuccess;
     	}
         
         public Boolean changePsw(User user, String newPassword){
        	 try{
        	Session session= HibernateSessionFactory.getSession();
          	Transaction tran= session.beginTransaction();
     		user.setPassword(newPassword);
     		session.update(user);
     		tran.commit();
     		session.close();
     		return true;
        	 }catch(Exception ex){
        		 return false;
        	 }
        	 
     	}
}
