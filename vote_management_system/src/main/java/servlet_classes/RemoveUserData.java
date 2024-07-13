package servlet_classes;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.classes.User; // Import your User entity class

@SuppressWarnings("serial")
@WebServlet("/removeUser")
public class RemoveUserData extends HttpServlet {
    
    EntityManagerFactory emf;
    
    @Override
    public void init() throws ServletException {
        super.init();
        emf = Persistence.createEntityManagerFactory("vote_management_system");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userIdStr = req.getParameter("userId");
        
        if (userIdStr == null || userIdStr.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println("User ID parameter is required.");
            return;
        }
        
        try {
            int userId = Integer.parseInt(userIdStr); // Parse userId as an integer
            
            System.out.println(userId);
            
            EntityManager em = emf.createEntityManager();
            EntityTransaction et = em.getTransaction();
            
            try {
                et.begin();
                
                // Find the user entity by its ID
                User user = em.find(User.class, userId);
                
                resp.setContentType("text/html; charset=UTF-8");
                resp.setCharacterEncoding("UTF-8");
                
                if (user == null) {
					/* resp.setStatus(HttpServletResponse.SC_NOT_FOUND); */
                    resp.getWriter().println("User not found.");
                } else {
                    // Remove the user from the database
                    em.remove(user);
                    et.commit();
                    
					/* resp.setStatus(HttpServletResponse.SC_OK); */
                    resp.getWriter().println("User removed successfully.");
                }
                
            } catch (Exception e) {
                et.rollback();
				/* resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); */
                resp.getWriter().println("Error removing user: " + e.getMessage()+" ,"+e.getStackTrace());
            } finally {
                em.close();
            }
            
        } catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println("Invalid user ID format.");
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
