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

@WebServlet("/updateTeacher")
public class TeacherUpdate extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("harish");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		String id = req.getParameter("id");
		int id1 = Integer.parseInt(id);
		String name = req.getParameter("name");
		String sal = req.getParameter("sal");
		double sal1 = Double.parseDouble(sal);
		String sub = req.getParameter("sub");

		Teacher t = new Teacher();
		t.setId(id1);
		t.setName(name);
		t.setSal(sal1);
		t.setSubject(sub);

		et.begin();
		em.merge(t);
		et.commit();

		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.write("updated successfully");

		RequestDispatcher rd = req.getRequestDispatcher("Teacher.html");
		rd.include(req, resp);

	}
}
