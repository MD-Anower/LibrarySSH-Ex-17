package action;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import service.BookCategoryService;
import service.BookService;
import service.StudentService;
import service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Book;
import entity.BookCategory;
import entity.Student;
import entity.User;

public class StudentAction extends ActionSupport implements ModelDriven<Student> {
	public Student student= new Student();
   
	@Override
	public Student getModel() {
		
		return this.student;
	}

	@Override
	public String execute() throws Exception {
		
		return SUCCESS;
	}
	
	private StudentService studentService;
	public void setStudentService(StudentService studentService){
		this.studentService= studentService;
	}
	
	public String list(){
		ActionContext actionContext= ActionContext.getContext();
		List<Student> list = this.studentService.findAll(student);
		actionContext.put("list", list);
		
		return "findAll";
	}
	
    public String delete(){
		
		this.studentService.delete(student);
		
		return "operSuccess";
	}
    
    public String query(){
   		
       	ActionContext actionContext= ActionContext.getContext();
       	HttpServletRequest request= ServletActionContext.getRequest();
       	String keyword= request.getParameter("keyWord");
   		List<Student> list = this.studentService.findByKeyword(keyword);
   		actionContext.put("list", list);
   		
   		return "findAll";
   	}
    
        public String add(){
		ActionContext actionContext= ActionContext.getContext();
		
		this.studentService.add(student);
		
		
		return "operSuccess";
	}
        
  
        public String edit(){
    		
    		this.studentService.update(student);
    		
    		return "operSuccess";
    	}
    
}
