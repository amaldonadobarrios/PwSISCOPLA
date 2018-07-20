package com.mi.pnp.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mi.pnp.beans.Usuario;
import com.mi.pnp.dao.UsuarioDAO;
import com.mi.pnp.util.BatEncriptador;

public class UsuarioDAOimpl implements UsuarioDAO {

	@Override
	public Usuario Grabar(Usuario usu) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSISCOPLA");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(usu);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return usu;
	}

	@Override
	public Usuario Modificar(Usuario usu) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSISCOPLA");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Usuario u = null;
		u = em.getReference(Usuario.class, usu.getIdUsuario());
		u.setEstado(usu.getEstado());
		u.setFechamod(new Date());
		u.setApemat(usu.getApemat());
		u.setApepat(usu.getApepat());
		u.setNombres(usu.getNombres());
		u.setCip(usu.getCip());
		u.setPerfil(usu.getPerfil());
		u.setEstado(usu.getEstado());
		u.setGrado(usu.getGrado());
		u.setUsumod(usu.getUsumod());
		u.setPassword(usu.getPassword());
		em.merge(u);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return u;
	}

	@Override
	public List<Usuario> listar() throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSISCOPLA");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT e FROM Usuario e");
		List<Usuario> usu = query.getResultList();
		em.close();
		emf.close();
		return usu;
	}

	@Override
	public Usuario GETUsuario(int id_usuario) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSISCOPLA");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Usuario u = null;
		u = em.getReference(Usuario.class, id_usuario);
		em.close();
		emf.close();
		return u;
	}

	@Override
	public Usuario validar(String usuario, String password) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSISCOPLA");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT e FROM Usuario e where e.cip=:arg1 AND e.password=:arg2");
		query.setParameter("arg1", usuario);
		query.setParameter("arg2", BatEncriptador.getInstance().Encripta(password));
		List<Usuario> usu = query.getResultList();
		em.close();
		emf.close();
		if (usu.size()>0) {
			return usu.get(0);
		}else {
			return null;
		}

	}

}
