package ServletClasses;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EntityClasses.Principle;

@WebServlet("/login")
public class LoginValidation extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("harish");
		EntityManager em = emf.createEntityManager();

		String email = req.getParameter("email");
		String pass = req.getParameter("pass");

		Query q = em.createQuery("select p from Principle p where p.email=?1 and p.pass=?2");
		q.setParameter(1, email);
		q.setParameter(2, pass);

		List<Principle> principles = q.getResultList();

		if (principles.size() > 0) {
			RequestDispatcher rd = req.getRequestDispatcher("TeaStu.html");
			rd.forward(req, resp);
		} else {
			resp.setContentType("text/html");
			PrintWriter pw = resp.getWriter();
			pw.write("Invalid Details Try Again !!!");
			RequestDispatcher rd = req.getRequestDispatcher("Login.html");
			rd.include(req, resp);
		}
	}
}
