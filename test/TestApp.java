import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.UserService;
import entity.User;


public class TestApp {
	
	
	@Test
     public void addUserTest(){
    	 System.out.println("test start.....................");
    	 User user= new User();
    	 user.setUserName("jack");
    	 user.setPassword("123");
    	 
    	 
    	 String xmlpath= "applicationContext.xml";
    	 ApplicationContext applicationContext=null;
    	
    		 applicationContext= new ClassPathXmlApplicationContext(xmlpath); 
    	
    	 
    	 UserService userService=
    			 (UserService)applicationContext.getBean("userService");
    	 userService.addUser(user);
    	 System.out.println("test end........................");
     }
}
