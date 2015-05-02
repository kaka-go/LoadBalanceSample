package com.edw;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/save-session", name = "save-session-servlet")
public class SaveSessionServlet extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		HttpSession session = req.getSession();
		Integer count = (Integer) session.getAttribute("counter");
		if(count == null) {
			count = 0;
		}
		count ++;
		req.getSession().setAttribute("counter", count);
		res.getWriter().println("<html><body>");
		res.getWriter().println("session has been saved to redis, refresh to increase count <br>");
		res.getWriter().println("counter: " + count);
		res.getWriter().println("</body></html>");
		res.flushBuffer();
	}

}
