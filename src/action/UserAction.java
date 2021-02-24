package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.UserDao;
import entity.Book;
import entity.BookCategory;
import entity.User;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	public User user= new User();

	@Override
	public User getModel() {
		
		return this.user;
	}

	@Override
	public String execute() throws Exception {
		
		return SUCCESS;
	}
	
	private UserService userService;
	private Integer id;
	public void setUserService(UserService userService){
		this.userService= userService;
	}
	public String add(){
		this.userService.addUser(user);
		return "operSuccess";
	}
	public String register(){
		ActionContext actionContext=ActionContext.getContext();
		
		if(user.getUserName().equals("")){
			actionContext.put("msg", "UserName can not be null.");
			return "registerError";
		}
		if(user.getPassword().equals("")){
			actionContext.put("msg", "Password can not be null.");
			return "registerError";
		}
		if(user.getRepeatPassword().equals("")){
			actionContext.put("msg", "RepeatPassword can not be null.");
			return "registerError";
		}
		if(user.getRepeatPassword().equals(user.getPassword())==false){
			actionContext.put("msg", "Password  and RepeatPassword must be same.");
			return "registerError";
		}
		
		this.userService.register(user);
		return "register";
	}
	
	public String login(){
		ActionContext actionContext= ActionContext.getContext();
		boolean isSuccess=this.userService.login(user);
		if(isSuccess){
			actionContext.getSession().put("user", user);
			return "loginSuccess";
		}else{
			actionContext.put("msg", "Login Fail");
			return "loginFail";
		}
		
	}
	
	public String signOut(){
		ActionContext actionContext= ActionContext.getContext();
		actionContext.getSession().clear();
		return "signOut";
	}
	
	public String list(){
		ActionContext actionContext= ActionContext.getContext();
		List<User> list = this.userService.findAll(user);
		actionContext.put("list", list);
		
		return "findAll";
	}
	public String showAdd(){
		 ActionContext actionContext= ActionContext.getContext();
		  List<User> list = this.userService.findAll(user);
			actionContext.put("listCategory", list);
			
			return "showAdd";
    }
    public String query(){
		
    	ActionContext actionContext= ActionContext.getContext();
    	HttpServletRequest request= ServletActionContext.getRequest();
    	String keyword= request.getParameter("keyWord");
    	List<User> list = this.userService.findByKeyword(keyword);
		actionContext.put("list", list);
		
		return "findAll";
	}
    public String edit(){
		
		this.userService.updateUser(user);
		
		return "operSuccess";
	}
    public String delete(){
		
    	this.userService.deleteUser(user);
		
		return "operSuccess";
	}
    
    public String changePass(){
    	ActionContext actionContext= ActionContext.getContext();
    	User user= (User)actionContext.getSession().get("user");
    	user = userService.findByUserName(user.getUserName());
    	
    	HttpServletRequest request= ServletActionContext.getRequest();
    	String userName = request.getParameter("userName");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		String repeatNewPassword = request.getParameter("repeatNewPassword");
		Boolean isSuccess = userService.isPasswordRight(userName, oldPassword);
		if(isSuccess == true){
			if(newPassword.equals(repeatNewPassword)){
				isSuccess = userService.changePsw(user, newPassword);
				if (isSuccess == true){
					List<User> list = this.userService.findAll(user);
					actionContext.getSession().put("list", list());
					return "findAll";
				}					
			}
			
		}
		return "findAll";
				
	}
   
}
