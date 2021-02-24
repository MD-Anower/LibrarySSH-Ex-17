package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import service.BookCategoryService;
import service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.BookCategory;
import entity.User;

public class BookCategoryAction extends ActionSupport implements ModelDriven<BookCategory> {

	public BookCategory bookCategory= new BookCategory();

	@Override
	public BookCategory getModel() {
		
		return this.bookCategory;
	}

	@Override
	public String execute() throws Exception {
		
		return SUCCESS;
	}
	
	private BookCategoryService bookCategoryService;
	public void setBookCategoryService(BookCategoryService bookCategoryService){
		this.bookCategoryService= bookCategoryService;
	}
	public String list(){
		ActionContext actionContext= ActionContext.getContext();
		List<BookCategory> list = this.bookCategoryService.findAll(bookCategory);
		actionContext.put("list", list);
		
		return "findAll";
	}
	
	public String add(){
		ActionContext actionContext= ActionContext.getContext();
		
		this.bookCategoryService.add(bookCategory);
		
		return "operSuccess";
	}
	
	public String edit(){
		
		this.bookCategoryService.update(bookCategory);
		
		return "operSuccess";
	}
	
    public String delete(){
		
		this.bookCategoryService.delete(bookCategory);
		
		return "operSuccess";
	}
    
    public String query(){
		
    	ActionContext actionContext= ActionContext.getContext();
    	HttpServletRequest request= ServletActionContext.getRequest();
    	String keyword= request.getParameter("keyWord");
		List<BookCategory> list = this.bookCategoryService.findByKeyword(keyword);
		actionContext.put("list", list);
		
		return "findAll";
	}
}
