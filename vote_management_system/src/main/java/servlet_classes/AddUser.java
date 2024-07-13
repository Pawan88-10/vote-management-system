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
@WebServlet("/addUser")
public class AddUser extends HttpServlet {

    private EntityManagerFactory emf;

    @Override
    public void init() throws ServletException {
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

        System.out.println("Gender : " + gender);

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Admin admin = em.find(Admin.class, 2);
        
        User user = em.find(User.class, 1);
        Query query = em.createQuery("select u from User u");
        
        List<User> users  = query.getResultList();
        
        req.setAttribute("users", users);
        
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        
        User user2 = new User(name,email,pass,address,age,gender,fname,mname,date);

        if (admin != null) {
            try {
                et.begin();
                em.persist(user2);
                et.commit();

                // Store user info in session if needed
                HttpSession session = req.getSession();
                session.getAttribute("User");

                RequestDispatcher rd = req.getRequestDispatcher("userViewTable.jsp");
                rd.forward(req, resp);
            } catch (Exception e) {
                if (et != null && et.isActive()) {
                    et.rollback();
                }
                e.printStackTrace();
                RequestDispatcher rd = req.getRequestDispatcher("error.jsp");
                rd.forward(req, resp);
            } finally {
                em.close();
            }
        } else {
            System.out.println("Admin isn't available..............");
            RequestDispatcher rd = req.getRequestDispatcher("error.jsp");
            rd.forward(req, resp);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
