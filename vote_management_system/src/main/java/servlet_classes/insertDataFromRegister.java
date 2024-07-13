package servlet_classes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmNamedNativeQueryType;

import entity.classes.Admin;
import entity.classes.User;

@WebServlet("/usertableView")
public class insertDataFromRegister extends HttpServlet{

	private static final long serialVersionUID = -5227182684398049855L;
	
	private EntityManagerFactory emf;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		emf = Persistence.createEntityManagerFactory("vote_management_system");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw = resp.getWriter();
		
		String name = req.getParameter("votername");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass"); 
		String address = req.getParameter("voteraddress");
		int age = Integer.parseInt(req.getParameter("voterage"));
		String fname = req.getParameter("father");
		String mname = req.getParameter("mother");
		String date = req.getParameter("birth");
		
		// Handle radio button for gender
	    String gender = req.getParameter("gender"); 

	    // Ensure gender is set to "male", "female", or "other"
	    if (gender == null || (!gender.equals("male") && !gender.equals("female") && !gender.equals("other"))) {
	        gender = "other"; 
	    }
	    
		System.out.println("Gender : "+gender);
		
		//fetch data from table
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        
        Admin admin = em.find(Admin.class, 2);
        User user = new User(name,email,pass,address,age,gender,fname,mname,date);
        
        if (admin != null) {
        	et.begin();
        	em.persist(user);
        et.commit();
        
        RequestDispatcher rd = req.getRequestDispatcher("viewMyData.jsp");
        rd.forward(req, resp);
		} else {
			System.out.println("Admin isn't available..............");
			RequestDispatcher rd = req.getRequestDispatcher("Error : admin is null");
			rd.forward(req, resp);
		}	
		
	}
	
	private <RadioButton> RadioButton findViewById(int selectedId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		if (emf != null && emf.isOpen()) {
            emf.close();
        }
	}
}
