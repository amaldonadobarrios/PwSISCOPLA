package com.mi.pnp.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mi.pnp.beans.Usuario;
import com.mi.pnp.dao.UsuarioDAO;
import com.mi.pnp.dao.impl.UsuarioDAOimpl;

/**
 * Servlet implementation class SPage
 */
@WebServlet("/SPage")
public class SPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(this.getClass().getName());
		HttpSession sesion = request.getSession();
		String ID = (String) sesion.getAttribute("ID");
		if (sesion.getAttribute("ID") != null) {
			if (ID.equals(sesion.getId())) {
				if (sesion.getAttribute("CIP") != null) {

					String action = request.getParameter("action") != null ? request.getParameter("action") : "";
					
						switch (action) {
						case "pagehome":
							this.pagehome(request, response);
							break;
						case "login":
							this.pagelogin(request, response);
							break;
						case "regusu":			
							try {
								this.pageregusu(request, response);
							} catch (Exception e) {	
							}
							break;
						case "regtra":
							this.pageregtra(request, response);
							break;
						default:
							this.pagelogin(request, response);
							break;}

				} else {
					request.setAttribute("msg", "SESION EXPIRADA, VUELVA A INGRESAR");
					sesion.invalidate();
					System.out.println("DESTINO:" + "index.jsp");
					forwar("index.jsp", request, response);

				}

			} else {
				request.setAttribute("msg", "SESION EXPIRADA, VUELVA A INGRESAR");
				sesion.invalidate();
				System.out.println("DESTINO:" + "index.jsp");
				forwar("index.jsp", request, response);
			}
		} else {
			request.setAttribute("msg", "SESION EXPIRADA, VUELVA A INGRESAR");
			sesion.invalidate();
			System.out.println("DESTINO:" + "index.jsp");
			forwar("index.jsp", request, response);
		}
	}

	private void pageregtra(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("breadcrumb", "Registro de Trabajo");
		request.setAttribute("body", "form_reg_trabajo");
		forwar("template.jsp", request, response);

	}

	private void pageregusu(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Usuario> lista = null;
		UsuarioDAO dao = new UsuarioDAOimpl();
		lista = dao.listar();
		request.setAttribute("lista", lista);
		request.setAttribute("breadcrumb", "Registro de Usuario");
		request.setAttribute("body", "form_usu");
		forwar("template.jsp", request, response);

	}

	public void forwar(String jsp, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher(jsp).forward(req, resp);
	}

	private void pagehome(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("breadcrumb", "Principal");
		request.setAttribute("body", "home");
		forwar("template.jsp", request, response);
	}

	private void pagelogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		sesion.invalidate();
		forwar("index.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
