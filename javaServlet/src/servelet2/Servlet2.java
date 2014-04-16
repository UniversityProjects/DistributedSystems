package servelet2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Servlet2() {
    
    	super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 request.setAttribute("get", "doPost");
		 
		 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/es2.jsp");
		 
		 dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 request.setAttribute("post", "doPost");
		 
		 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/es2.jsp");
		
		 dispatcher.forward(request, response);
		
	}

}
