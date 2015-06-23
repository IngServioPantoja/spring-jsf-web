package co.com.sp.beans.managed;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.sp.capadominio.Usuario;
import co.com.sp.capaservicio.UsuarioService;
import co.com.sp.capaservicio.excepciones.BusinessException;

@ManagedBean
@ViewScoped
@Component
public class UsuarioBean implements Serializable{

	private static final long serialVersionUID = -3211394890842682243L;

	@Autowired
	private UsuarioService usuarioService;
	List<Usuario> usuarios;
	List<Usuario> usuariosFiltradas;

	public UsuarioBean() {

	}

	@PostConstruct
	public void inicializar() {

	}

	public void cargarUsuarios(){
		try {
			usuarios = usuarioService.listar();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editListener(RowEditEvent event) {
		Usuario usuario = (Usuario) event.getObject();
		try {
			usuarioService.actualizar(usuario);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Usuario> getUsuariosFiltradas() {
		return usuariosFiltradas;
	}

	public void setUsuariosFiltradas(List<Usuario> usuariosFiltradas) {
		this.usuariosFiltradas = usuariosFiltradas;
	}
}