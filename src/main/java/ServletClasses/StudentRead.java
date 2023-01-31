package ServletClasses;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import EntityClasses.Student;

@WebServlet("/studentRead")
public class StudentRead extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		int id1 = Integer.parseInt(id);
		System.out.println("hi");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("harish");
		EntityManager em = emf.createEntityManager();

		Student s = em.find(Student.class, id1);

		HttpSession hs = req.getSession();
		hs.setAttribute("hari", s);

		RequestDispatcher rd = req.getRequestDispatcher("StudentRead.jsp");
		rd.forward(req, resp);
	}
}