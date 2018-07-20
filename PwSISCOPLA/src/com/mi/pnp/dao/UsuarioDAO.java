package com.mi.pnp.dao;

import java.util.List;

import com.mi.pnp.beans.Usuario;

public interface UsuarioDAO {

	public Usuario Grabar(Usuario usu) throws Exception;
	public Usuario Modificar(Usuario usu) throws Exception;
	public List<Usuario> listar() throws Exception;
	public Usuario GETUsuario(int id_usuario) throws Exception;
	public Usuario validar (String usuario, String password) throws Exception;
}
