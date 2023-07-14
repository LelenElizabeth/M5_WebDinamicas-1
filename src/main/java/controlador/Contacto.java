package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Contacto
 */
@WebServlet("/Contacto")
public class Contacto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contacto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
	    if (session != null && session.getAttribute("usuario") != null) {
	    	getServletContext().getRequestDispatcher("/views/contacto.jsp").forward(request, response);
	    } else {
	    	response.sendRedirect(request.getContextPath() + "/Login");
	        // código para desplegar el diseño respectivo
	    }
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String mensaje = request.getParameter("mensaje");
		System.out.println(nombre + "\n"+ email + "\n" + mensaje);
		//Mensaje de exito
		request.setAttribute("mensaje", "Mensaje recibido, te contactaremos por el correo proporcionado.");
		//Redireccionando a la pagina de exito
		getServletContext().getRequestDispatcher("/views/exito.jsp").forward(request, response);
	}

}
