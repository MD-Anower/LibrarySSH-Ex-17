package service;

import java.util.List;

import dao.UserDao;
import entity.Book;
import entity.User;

public class UserService {
        private UserDao userDao;

		public void setUserDao(UserDao userDao) {
			this.userDao = userDao;
		}
		
		public void register(User user){
			this.userDao.register(user);
		}
		
		public boolean login(User user){
			return this.userDao.login(user);
		}
		
		public void addUser(User user){
			this.userDao.add(user);
		}
		
		public void updateUser(User user){
			this.userDao.update(user);;
		}
		
		public void deleteUser(User user){
			this.userDao.delete(user);;
		}
		
		public User findById(Integer id){
			return this.userDao.findById(id);
		}
		public User findByUserName(String userName){
			return this.userDao.findByUserName(userName);
		}
    	public List<User> findAll(User user) {
			return this.userDao.findAll();
		}
    	public List<User> findByKeyword(String keyword){
	    	return this.userDao.findByKeyword(keyword);
	    }

		public Boolean isPasswordRight(String userName, String oldPassword) {
			
			return this.userDao.isPasswordRight(userName, oldPassword);
		}
       public Boolean changePsw(User user, String newPassword) {
			
			return this.userDao.changePsw(user, newPassword);
		}  
    	
}
