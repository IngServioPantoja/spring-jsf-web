package co.com.sp.beans.managed;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.sp.capadominio.Grupo;
import co.com.sp.capaservicio.GrupoService;
import co.com.sp.capaservicio.excepciones.BusinessException;

@ManagedBean
@ViewScoped
@Component
public class GrupoBean implements Serializable{

	private static final long serialVersionUID = -295013253961091251L;

	@Autowired
	private GrupoService grupoService;
	List<Grupo> grupos;
	List<Grupo> gruposFiltradas;

	public GrupoBean() {

	}

	@PostConstruct
	public void inicializar() {

	}

	public void cargarGrupos(){
		try {
			grupos = grupoService.listar();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editListener(RowEditEvent event) {
		Grupo grupo = (Grupo) event.getObject();
		try {
			grupoService.actualizar(grupo);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public List<Grupo> getGruposFiltradas() {
		return gruposFiltradas;
	}

	public void setGruposFiltradas(List<Grupo> gruposFiltradas) {
		this.gruposFiltradas = gruposFiltradas;
	}
}