package codington.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codington.handler.ActualizarUserDatos;
import codington.handler.BuscarUserHandler;
import codington.handler.RegistrarUserEventos;
import codington.interfaces.HandleRequest;


/**
 * Servlet implementation class ControladorServlet
 */

public class ControladorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Map<String, HandleRequest> controladores= null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		controladores= new HashMap<String, HandleRequest>();
		controladores.put("/buscarUsuario.do", new BuscarUserHandler());
		controladores.put("/actualizarDatos.do", new ActualizarUserDatos());
		controladores.put("/registrarEventos.do", new RegistrarUserEventos());

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	private void processRequest(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
        // Obtenemos el manejador asociado al                                                                                                                                      evento ocurrido
        HandleRequest rh = (HandleRequest) controladores.get(request.getServletPath());
        
       
        // Comprobamos si se obtuvo correctamente el manejador
        if (rh == null) {
            // Mostramos el error en caso de no cargarse correctamente
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } else {
            
            // Obtenemos la URL resultante de ejecutar el manejador
            String viewUrl = rh.requestHandler(request, response);
            if (viewUrl == null) {
                // Nada
            } else {
                // El RequestHandler correspondiente nos dira que vista utilizar
                request.getRequestDispatcher(viewUrl).forward(request, response);
            }
        }
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
	



}
