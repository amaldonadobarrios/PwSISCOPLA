package com.mi.pnp.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private int idUsuario;

	private String apemat;

	private String apepat;

	private String cip;

	private int estado;

	@Temporal(TemporalType.DATE)
	private Date fechamod;

	@Temporal(TemporalType.DATE)
	private Date fechareg;

	private String grado;

	private String nombres;

	private String password;

	private int perfil;

	private String usumod;

	private String usureg;

	
	public Usuario(int idUsuario, String apemat, String apepat, String cip, int estado, Date fechamod, Date fechareg,
			String grado, String nombres, String password, int perfil, String usumod, String usureg) {
		super();
		this.idUsuario = idUsuario;
		this.apemat = apemat;
		this.apepat = apepat;
		this.cip = cip;
		this.estado = estado;
		this.fechamod = fechamod;
		this.fechareg = fechareg;
		this.grado = grado;
		this.nombres = nombres;
		this.password = password;
		this.perfil = perfil;
		this.usumod = usumod;
		this.usureg = usureg;
	}

	public Usuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApemat() {
		return this.apemat;
	}

	public void setApemat(String apemat) {
		this.apemat = apemat;
	}

	public String getApepat() {
		return this.apepat;
	}

	public void setApepat(String apepat) {
		this.apepat = apepat;
	}

	public String getCip() {
		return this.cip;
	}

	public void setCip(String cip) {
		this.cip = cip;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Date getFechamod() {
		return this.fechamod;
	}

	public void setFechamod(Date fechamod) {
		this.fechamod = fechamod;
	}

	public Date getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Date fechareg) {
		this.fechareg = fechareg;
	}

	public String getGrado() {
		return this.grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPerfil() {
		return this.perfil;
	}

	public void setPerfil(int perfil) {
		this.perfil = perfil;
	}

	public String getUsumod() {
		return this.usumod;
	}

	public void setUsumod(String usumod) {
		this.usumod = usumod;
	}

	public String getUsureg() {
		return this.usureg;
	}

	public void setUsureg(String usureg) {
		this.usureg = usureg;
	}

}