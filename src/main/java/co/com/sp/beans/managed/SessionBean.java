package co.com.sp.beans.managed;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.sp.capadominio.ModuloOpcion;
import co.com.sp.capadominio.Usuario;
import co.com.sp.capaservicio.ModuloOpcionService;
import co.com.sp.capaservicio.UsuarioService;


@ManagedBean
@SessionScoped
@Component
public class SessionBean implements Serializable{

	private static final long serialVersionUID = -124466934030612288L;
	private List<ModuloOpcion> opcionesActivas;
	private Usuario usuarioLogueado;
	private int progreso = 0;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ModuloOpcionService moduloOpcionService;

    public SessionBean() {System.out.println("SessionBean");

    }
    
    @PostConstruct
	public void inicializar() {System.out.println("SessionBean inicializar");
	
	}
    
    public void definirSesionUsuario(String usuario,String password){
    	try {
			usuarioLogueado = usuarioService.iniciarSesion(usuario, password);
			System.out.println("SessionBean definirSesionUsuario Exito");
			System.out.println("SessionBean cargandoOpciones del sistema");
			opcionesActivas = moduloOpcionService.findByRol(usuarioLogueado.getUsuarioRoles().get(0).getRol());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	public List<ModuloOpcion> getOpcionesActivas() {
		return opcionesActivas;
	}

	public Usuario getUsuarioLogueado() {
		return usuarioLogueado;
	}

	public int getProgreso() {
		return progreso;
	}

	public void setProgreso(int progreso) {
		this.progreso = progreso;
	}
    
}
