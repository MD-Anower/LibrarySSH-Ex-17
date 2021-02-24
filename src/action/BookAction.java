package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import service.BookCategoryService;
import service.BookService;
import service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Book;
import entity.BookCategory;
import entity.User;

public class BookAction extends ActionSupport implements ModelDriven<Book> {
     
	private File file;
	private String fileFileName;
	private String fileContentType;
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public Book book= new Book();
	public BookCategory bookCategory= new BookCategory();

	@Override
	public Book getModel() {
		
		return this.book;
	}

	@Override
	public String execute() throws Exception {
		
		return SUCCESS;
	}
	
	private BookService bookService;
	public void setBookService(BookService bookService){
		this.bookService= bookService;
	}
	private BookCategoryService bookCategoryService;
	public void setBookCategoryService(BookCategoryService bookCategoryService){
		this.bookCategoryService= bookCategoryService;
	}
	public String list(){
		ActionContext actionContext= ActionContext.getContext();
		List<Book> list = this.bookService.findAll(book);
		actionContext.put("list", list);
		
		return "findAll";
	}
	
	public String search(){
		ActionContext actionContext= ActionContext.getContext();
		List<Book> list = this.bookService.findAll(book);
		actionContext.put("list", list);
		
		return "search";
	}
	
	public String add() throws IOException{
		InputStream is= new FileInputStream(file);
		String uploadPath = ServletActionContext.getServletContext().
				getRealPath("/upload");
		File toFile = new File(uploadPath, this.getFileFileName());
        OutputStream os = new FileOutputStream(toFile); 
        byte[] buffer = new byte[1024];
        int length = 0;
      
        while(-1 != (length = is.read(buffer, 0, buffer.length))){
             os.write(buffer);
        }
       is.close();
       os.close();
       
       book.setPicture("upload\\" + this.getFileFileName());
		
		this.bookService.add(book);
		
		return "operSuccess";
	}
	
	public String edit() throws IOException{
		InputStream is= new FileInputStream(file);
		String uploadPath = ServletActionContext.getServletContext().
				getRealPath("/upload");
		File toFile = new File(uploadPath, this.getFileFileName());
        OutputStream os = new FileOutputStream(toFile); 
        byte[] buffer = new byte[1024];
        int length = 0;
      
        while(-1 != (length = is.read(buffer, 0, buffer.length))){
             os.write(buffer);
        }
       is.close();
       os.close();
       
       book.setPicture("upload\\" + this.getFileFileName());
		
		this.bookService.update(book);
		
		return "operSuccess";
	}
	
    public String delete(){
		
		this.bookService.delete(book);
		
		return "operSuccess";
	}
    public String showAdd(){
	 ActionContext actionContext= ActionContext.getContext();
		List<BookCategory> list = this.bookCategoryService.findAll(bookCategory);
		actionContext.put("listCategory", list);
		
		return "showAdd";
	}
    
    public String showEdit(){
   	 ActionContext actionContext= ActionContext.getContext();
   		List<BookCategory> list = this.bookCategoryService.findAll(bookCategory);
   		actionContext.put("listCategory", list);
   		actionContext.put("id", book.getId());
   		return "showEdit";
   	}
    public String query(){
		
    	ActionContext actionContext= ActionContext.getContext();
    	HttpServletRequest request= ServletActionContext.getRequest();
    	String keyword= request.getParameter("keyWord");
		List<Book> list = this.bookService.findByKeyword(keyword);
		actionContext.put("list", list);
		
		return "findAll";
	}
}
