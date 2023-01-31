package ServletClasses;

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

import EntityClasses.Teacher;

@WebServlet("/teacherAdd")
public class TeacherAdd extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String saL = req.getParameter("sal");
		double sal1 = Double.parseDouble(saL);
		String sub = req.getParameter("sub");

		Teacher t = new Teacher();
		t.setName(name);
		t.setSal(sal1);
		t.setSubject(sub);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("harish");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(t);
		et.commit();
		System.out.println("Data Saved Sucessfully!");

		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.write("Teacher Details Added Succefully");

		RequestDispatcher rd = req.getRequestDispatcher("Teacher.html");
		rd.include(req, resp);
	}
}
