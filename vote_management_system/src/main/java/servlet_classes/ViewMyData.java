package servlet_classes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.classes.User;

@WebServlet("/userView")
public class ViewMyData extends HttpServlet {

    private EntityManagerFactory emf;

    @Override
    public void init() throws ServletException {
        super.init();
        emf = Persistence.createEntityManagerFactory("vote_management_system");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();

        String name = req.getParameter("username");
        String email = req.getParameter("useremail");
        String password = req.getParameter("userpass");

        EntityManager em = emf.createEntityManager();
        
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        try {
            // Fetch user based on email (assuming email is unique)
            Query query = em.createQuery("SELECT u FROM User u WHERE u.email = :email");
            query.setParameter("email", email);
            User user = (User) query.getSingleResult();

            // Validate user credentials
            if (user != null && user.getName().equals(name) && user.getPassword().equals(password)) {
                // Set attributes for forwarding to VoterId.jsp
                req.setAttribute("name", name);
                req.setAttribute("father", user.getFatherName());
                req.setAttribute("gender", user.getGender());
                req.setAttribute("date", user.getDate());

                // Create a new User object to store in session
                User user1 = new User(name, email, password);

                // Set User object in session
                HttpSession session = req.getSession();
                session.setAttribute("User", user1);
               
                // Forward to VoterId.jsp
                RequestDispatcher rd = req.getRequestDispatcher("VoterId.jsp");
                rd.forward(req, resp);
            } else {
                // Forward to error page if user not found or credentials are incorrect
                RequestDispatcher rd1 = req.getRequestDispatcher("UserErrorPage.jsp");
                rd1.forward(req, resp);
            }
        } catch (NoResultException e) {
            // Handle user not found
            RequestDispatcher rd1 = req.getRequestDispatcher("UserErrorPage.jsp");
            rd1.forward(req, resp);
        } finally {
            em.close();
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
