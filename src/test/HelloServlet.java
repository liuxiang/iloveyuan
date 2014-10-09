package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Hello", urlPatterns = { "/hello.do" })
public class HelloServlet extends HttpServlet
{
	private Hello hello = new Hello();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String name = req.getParameter("user");
		String message = hello.doHello(name);
		req.setAttribute("message", message);
		req.getRequestDispatcher("hello.jsp").forward(req, resp);
	}
}