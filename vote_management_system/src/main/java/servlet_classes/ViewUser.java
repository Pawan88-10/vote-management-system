package servlet_classes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.classes.Admin;
import entity.classes.User;

@WebServlet("/adminView")
public class ViewUser extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    private EntityManagerFactory emf;

    @Override
    public void init() throws ServletException {
        super.init();
        emf = Persistence.createEntityManagerFactory("vote_management_system"); // Replace with your persistence unit name
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        String admin_name = req.getParameter("admin_name");
        String password = req.getParameter("admin_pass");
        String checkbox = req.getParameter("check");
        boolean checked = "true".equals(checkbox);

        //fetch data from table
        EntityManager em = emf.createEntityManager();
        
        Admin admin = em.find(Admin.class, 2);
        
        User user = em.find(User.class, 1);
        Query query = em.createQuery("select u from User u");
        
        List<User> users  = query.getResultList();
        
        req.setAttribute("users", users);
        
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        if (admin != null && admin.getName().equals(admin_name)&& admin.getPassword().equals(password)) {
        	
           User user2 = em.find(User.class, user.getId());
           Admin admin2	 = new Admin(admin_name,password,user);
           HttpSession session = req.getSession();
           req.setAttribute("Admin", admin2);
           req.setAttribute("User", user2);
        	
           RequestDispatcher rd = req.getRequestDispatcher("userViewTable.jsp");
           rd.forward(req, resp);
        } else {
        	RequestDispatcher rd = req.getRequestDispatcher("AdminErrorPage.jsp");
        	rd.forward(req, resp);
        	System.out.println("Data is not matched......");
        }

        em.close();
    }

    @Override
    public void destroy() {
        super.destroy();
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
