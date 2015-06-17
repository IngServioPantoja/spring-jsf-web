package co.com.sp.beans.managed;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.sp.capadominio.ParametroPersona;
import co.com.sp.capadominio.Persona;
import co.com.sp.capaservicio.ParametroPersonaService;
import co.com.sp.capaservicio.PersonaService;


@ManagedBean
@ViewScoped
@Component
public class PersonaBean implements Serializable{

private static final long serialVersionUID = -3211394890842682243L;
	
	@Autowired
	private SessionBean sessionBean;
	
	@Autowired
	private PersonaService personaService;
	
	@Autowired
	private ParametroPersonaService parametroPersonaService;
	
	List<Persona> personas;
	List<Persona> personasFiltradas;
	private Persona persona;
	private List<ParametroPersona> lstGeneros;
	final Long idTipoPrametroGeneto = (long) 1;
	public ParametroPersona genero;
	public PersonaBean() {
		
	}

	@PostConstruct
	public void inicializar() {
		persona = new Persona();
		lstGeneros = null;
	}

	public void cargarPersonas(){
		try {
			personas = personaService.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void limpiarRegistrar(){
		sessionBean.setProgreso(0);
		persona = new Persona();
		if(lstGeneros==null){
			try {
				lstGeneros = parametroPersonaService.findByTipo(idTipoPrametroGeneto);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sessionBean.setProgreso(100);
	}
	
	public void registrar(){
		sessionBean.setProgreso(0);
		try {
			personaService.insertar(persona);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sessionBean.setProgreso(50);
		personas.add(persona);
		sessionBean.setProgreso(100);
	}
	
	public void modificar(){
		sessionBean.setProgreso(0);
		try {
			personaService.actualizar(persona);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Long id = persona.getIdPersona();
		sessionBean.setProgreso(50);
		for (Persona personaModificar : personas) {
			if(personaModificar.getIdPersona().equals(id)){
				personas.remove(persona);
				personas.add(persona);
				sessionBean.setProgreso(70);
				break;
			}
		}
		sessionBean.setProgreso(100);
	}
	
	public void eliminar(){
		sessionBean.setProgreso(0);
		try {
			personaService.eliminar(persona);
			sessionBean.setProgreso(50);
			Long id = persona.getIdPersona();
			for (Persona personaEliminar : personas) {
				if(personaEliminar.getIdPersona().equals(id)){
					personas.remove(personaEliminar);
					break;
				}
			}
			sessionBean.setProgreso(70);
            String msg = persona.getNombre()+" ha sido eliminado exitosamente";
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar", msg));
			persona = new Persona();
		} catch (SQLException e) {
			String msg = "Ha ocurrido un error al eliminar la persona";
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msg));
		}
		sessionBean.setProgreso(100);
	}
	
	public void validarIdentificacion(){System.out.println("validarIdentificacion");
		try {
			boolean existe = personaService.encontrarCedula(persona.getIdentificacion());
			if(existe){
				System.out.println("ya usada");
				FacesMessage message = new FacesMessage();
		        message.setSummary("Cedula ya registrada");
		        FacesContext.getCurrentInstance().addMessage("idFormAgregar:idIdentificacionInput", message);
			}else{
				System.out.println("ya usada");
				FacesMessage message = new FacesMessage();
		        message.setSummary("Cedula disponible");
		        FacesContext.getCurrentInstance().addMessage("idFormAgregar:idIdentificacionInput", message);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void definirActual(Persona persona){
		this.persona = persona;
	}
	
	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public List<Persona> getPersonasFiltradas() {
		return personasFiltradas;
	}

	public void setPersonasFiltradas(List<Persona> personasFiltradas) {
		this.personasFiltradas = personasFiltradas;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public SessionBean getSessionBean() {
		return sessionBean;
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

	public List<ParametroPersona> getLstGeneros() {
		return lstGeneros;
	}

	public void setLstGeneros(List<ParametroPersona> lstGeneros) {
		this.lstGeneros = lstGeneros;
	}
	private String console;
	public String getConsole() {
		return console;
	}

	public void setConsole(String console) {
		this.console = console;
	}

	public ParametroPersona getGenero() {
		return genero;
	}

	public void setGenero(ParametroPersona genero) {
		this.genero = genero;
	}
}