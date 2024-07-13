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
import javax.servlet.http.HttpSession;

import entity.classes.User;

@WebServlet("/voterCardview")
public class VoterCardUpdate extends HttpServlet {

    private static final long serialVersionUID = 1L;
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
        String address = req.getParameter("voteraddress");
        int age = Integer.parseInt(req.getParameter("voterage"));
        String fname = req.getParameter("father");
        String mname = req.getParameter("mother");
        String date = req.getParameter("birth");
        
        // Handle radio button of gender
        String gender = req.getParameter("gender");

        // Ensure gender is set to "male", "female", or "other"
        if (gender == null || (!gender.equals("male") && !gender.equals("female") && !gender.equals("other"))) {
            gender = "other"; // Default to "other" if gender is null or invalid
        }

        // Get User object from session
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("User");

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        
        try {
            // Begin transaction
            et.begin();

            // Retrieve the User entity to update (assuming user ID is 1)
            User updatedUser = em.find(User.class, 1);

            // Update user attributes
            updatedUser.setName(name);
            updatedUser.setAddress(address);
            updatedUser.setAge(age);
            updatedUser.setGender(gender);
            updatedUser.setFatherName(fname);
            updatedUser.setMotherName(mname);
            updatedUser.setDate(date);

            // Merge the updatedUser entity into the persistence context
            em.merge(updatedUser);

            // Commit transaction
            et.commit();

            // Set attributes for displaying in VoterId.jsp
            req.setAttribute("name", updatedUser.getName());
            req.setAttribute("father", updatedUser.getFatherName());
            req.setAttribute("gender", updatedUser.getGender());
            req.setAttribute("date", updatedUser.getDate());

            // Forward to VoterId.jsp upon successful update
            RequestDispatcher rd = req.getRequestDispatcher("VoterId.jsp");
            rd.forward(req, resp);
        } catch (Exception e) {
            // Handle errors
            e.printStackTrace();
            pw.println("Something went wrong...");
            et.rollback(); // Rollback transaction if there's an error
        } finally {
            em.close(); // Close EntityManager
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
