package com.mi.pnp.control;

import java.io.IOException;
import java.util.Date;
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
import com.mi.pnp.util.BatEncriptador;

/**
 * Servlet implementation class SUsuario
 */
@WebServlet("/SUsuario")
public class SUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(this.getClass().getName());
		HttpSession sesion = request.getSession();
		String ID = (String) sesion.getAttribute("ID");
		if (sesion.getAttribute("ID") != null) {
			if (ID.equals(sesion.getId())) {
				if (sesion.getAttribute("CIP") != null) {
					String evento = request.getParameter("hdEvento");
					if (evento != null || evento != "") {
						
							switch (evento) {
							case "AGREGAR_USUARIO":
								System.out.println("hdEvento :  AGREGAR_USUARIO");
								AgregarUsuario(request, response);
								break;
							case "MODIFICAR_USUARIO":
								System.out.println("hdEvento :  MODIFICAR_USUARIO");
								ModificarUsuario(request, response);
								break;
							case "BUSCAR_USUARIO":
								System.out.println("hdEvento :  BUSCAR_USUARIO");
								try {
									BuscarUsuario(request, response);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								break;
							default:
								break;
							}
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
		} else {
			request.setAttribute("msg", "SESION EXPIRADA, VUELVA A INGRESAR");
			sesion.invalidate();
			System.out.println("DESTINO:" + "index.jsp");
			forwar("index.jsp", request, response);
		}
		
		
		
	}
	private void BuscarUsuario(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, Exception {
		System.out.println("void BuscarUsuario");
		String id_usu = request.getParameter("idusu").trim();
		Usuario usu=null;
		UsuarioDAO dao=new UsuarioDAOimpl();
		usu=dao.GETUsuario(Integer.parseInt(id_usu));
		usu.setPassword(BatEncriptador.getInstance().Desencripta(usu.getPassword()));
		List<Usuario> lista=null;
		lista=dao.listar();
		request.setAttribute("lista",lista);
		request.setAttribute("Usuario",usu);
		request.setAttribute("breadcrumb", "Modificar Usuario");
		request.setAttribute("body", "form_usu");
		forwar("template.jsp", request, response);
		
	}

	private void ModificarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("void ModificarUsuario");
		String txtid = request.getParameter("txtid").trim();
		String cip = request.getParameter("txtcip");
		String grado = request.getParameter("grado");
		String apePat = request.getParameter("apepat").toUpperCase().trim();
		String apeMat = request.getParameter("apemat").toUpperCase().trim();
		String nombres = request.getParameter("nombre").toUpperCase().trim();
		String estado = request.getParameter("estado");
		String perfil = request.getParameter("perfil");
		String password = request.getParameter("password");
		HttpSession sesion = request.getSession();
		String usureg=(String)sesion.getAttribute("CIP");
		Usuario usu=null;
		List<Usuario> lista=null;
		try {
			Usuario u=new Usuario(Integer.parseInt(txtid), apeMat, apePat, cip, Integer.parseInt(estado), new Date(), null, grado, nombres, BatEncriptador.getInstance().Encripta(password), Integer.parseInt(perfil), usureg, "");
			UsuarioDAO dao=new UsuarioDAOimpl();
			usu=dao.Modificar(u);
			lista=dao.listar();
		} catch (Exception e) {
			System.out.println("Error Try Catch: "+e.getMessage() );
		}
		 if (usu!=null) {
			if (usu.getIdUsuario()>0) {
				request.setAttribute("msg", "Correcto, usuario Modificado");
			}else {
				request.setAttribute("msg", "Error, usuario no Modificado");	
			}
		}else {
			request.setAttribute("msg", "Error, usuario no Modificado");
		}
		request.setAttribute("lista",lista);
		request.setAttribute("breadcrumb", "Registrar Usuario");
		request.setAttribute("body", "form_usu");
		forwar("template.jsp", request, response);
		
		
		
		
	}

	private void AgregarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("void AgregarUsuario");
		String cip = request.getParameter("txtcip");
		String grado = request.getParameter("grado");
		String apePat = request.getParameter("apepat").toUpperCase().trim();
		String apeMat = request.getParameter("apemat").toUpperCase().trim();
		String nombres = request.getParameter("nombre").toUpperCase().trim();
		String estado = request.getParameter("estado");
		String perfil = request.getParameter("perfil");
		String password = request.getParameter("password");
		HttpSession sesion = request.getSession();
		String usureg=(String)sesion.getAttribute("CIP");
		Usuario usu=null;
		List<Usuario> lista=null;
		try {
			Usuario u=new Usuario(0, apeMat, apePat, cip, Integer.parseInt(estado), new Date(), new Date(), grado, nombres, BatEncriptador.getInstance().Encripta(password), Integer.parseInt(perfil), " ", usureg);
			UsuarioDAO dao=new UsuarioDAOimpl();
			usu=dao.Grabar(u);
			lista=dao.listar();
		} catch (Exception e) {
			System.out.println("Error Try Catch: "+e.getMessage() );
		}
		 if (usu!=null) {
			if (usu.getIdUsuario()>0) {
				request.setAttribute("msg", "Correcto, usuario registrado");
			}else {
				request.setAttribute("msg", "Error, usuario no registrado");	
			}
		}else {
			request.setAttribute("msg", "Error, usuario no registrado");
		}
		request.setAttribute("lista",lista);
		request.setAttribute("breadcrumb", "Registrar Usuario");
		request.setAttribute("body", "form_usu");
		forwar("template.jsp", request, response);
		
	}

	public void forwar(String jsp, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher(jsp).forward(req, resp);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
