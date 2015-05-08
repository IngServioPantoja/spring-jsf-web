package co.com.sp.beans.managed;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.sp.capadatos.domain.Persona;
import co.com.sp.capaservicio.PersonaService;


@ManagedBean
@ViewScoped
@Component
public class PersonaBean implements Serializable{

	private static Log logger = LogFactory.getLog("PersonaBean");
	private static final long serialVersionUID = -3211394890842682243L;

	@Autowired
	private PersonaService personaService;
	private Persona persona = new Persona();
	

	public PersonaBean() {
	System.out.println("Persona Bean");		
	}

	@PostConstruct
	public void inicializar() {
		System.out.println("Inicializar");
	}

	public void cargarPersonas(){
		personaService.listarPersonas();
		persona.setApeMaterno("asdasd222");
		persona.setIdPersona((long) 2);

		logger.info(persona.getApeMaterno());

		logger.info(persona.getIdPersona());
		System.out.println("Inicializar");
		System.out.println("Inicializar");		
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	
}