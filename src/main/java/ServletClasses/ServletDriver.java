package ServletClasses;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EntityClasses.Principle;

@WebServlet("/signup")
public class ServletDriver extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("harish");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		String name = req.getParameter("name");
		String age = req.getParameter("age");
		int age1 = Integer.parseInt(age);
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");

		Principle p = new Principle();
		p.setName(name);
		p.setAge(age1);
		p.setEmail(email);
		p.setPass(pass);

		et.begin();
		em.persist(p);
		et.commit();
		System.out.println("Data Saved Sucessfully!");

		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.write("Data Saved Sucessfully!");
		
		RequestDispatcher rd = req.getRequestDispatcher("Login.html");
		rd.include(req, resp);
	}

}
