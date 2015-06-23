package test;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.com.sp.capadominio.Persona;
import co.com.sp.capapersistencia.PersonaDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:datasource-test.xml","classpath:applicationContext.xml" })
public class TestGenericDaoImpl {
	
	private static Log logger = LogFactory.getLog("TestGenericDaoImpl");

	@Autowired
	private PersonaDao personaDao;
//	
//	@Autowired
//	private UsuarioDao usuarioDao;
//	
//	@Autowired
//	private GrupoDao grupoDao;
//	
//	@Autowired
//	private ModuloDao moduloDao;
//
	@Test
	@Transactional
	public void deberiaMostrarPersonas() {
		try {
			System.out.println();
			logger.info("Inicio del test deberiaMostrarPersonas");
			List<Persona> personas = personaDao.listar();
			int contadorPersonas = 0;
			for (Persona persona : personas) {
				logger.info("Persona: " + persona);
				contadorPersonas++;
			}
			logger.info("Cantidad personas"+contadorPersonas);
			logger.info("Fin del test deberiaMostrarPersonas");
		} catch (Exception e) {
			logger.error("Error JBDC", e);
		}
	}
//	
//	@Test
//	@Transactional
//	public void deberiaMostrarUsuarios() {
//		try {
//			System.out.println();
//			logger.info("Inicio del test deberiaMostrarUsuarios");
//			List<Usuario> usuarios = usuarioDao.findAllUsuarios();
//			int contador = 0;
//			for (Usuario usuario : usuarios) {
//				logger.info("Usuario: " + usuario);
//				contador++;
//			}
//			logger.info("Cantidad usuario"+contador);
//			logger.info("Fin del test deberiaMostrarUsuarios");
//		} catch (Exception e) {
//			logger.error("Error JBDC", e);
//		}
//	}
//
//
//	@Test
//	@Transactional
//	public void loguearUsuario() {
//		try {
//			System.out.println();
//			logger.info("Inicio del test loguearUsuario");
//			String usuario = "malUsuario";
//			String contrasena = "malContrasena";
//			Usuario usuarioLogueado = usuarioDao.iniciarSesion(usuario, contrasena);
//			if(usuarioLogueado==null){
//				System.out.println("No tiene acceso");
//			}
//			usuario = "joseph";
//			contrasena = "admin";
//			usuarioLogueado = usuarioDao.iniciarSesion(usuario, contrasena);
//			if(usuarioLogueado==null){
//				System.out.println("No tiene acceso");
//			}else{
//				System.out.println("Logueado");
//			}
//			logger.info("Fin del test loguearUsuario");
//		} catch (Exception e) {
//			logger.error("Error JBDC", e);
//		}
//	}

//	@Test
//	@Transactional
//	public void deberiaMostrarGrupos() {
//		try {
//			System.out.println();
//			logger.info("Inicio del test deberiaMostrarGrupos");
//			List<Grupo> lstResult = grupoDao.findAll();
//			int contador = 0;
//			for (Grupo grupo : lstResult) {
//				logger.info("Grupo: " + grupo);
//				contador++;
//			}
//			logger.info("Cantidad grupos"+contador);
//			logger.info("Fin del test deberiaMostrarGrupos");
//		} catch (Exception e) {
//			logger.error("Error JBDC", e);
//		}
//	}
//	
//	@Test
//	@Transactional
//	public void obtenerModulosPorPadre() {
//		try {
//			System.out.println();
//			logger.info("Inicio del test obtenerModulosPorPadre");
//			Modulo moduloPadre = new Modulo();
//			moduloPadre.setIdModulo(null);
//			System.out.println("Obtner modulos padre NULL");
//			List<Modulo> lstResult = moduloDao.findByPadre(moduloPadre);
//			int contador = 0;
//			for (Modulo modulo : lstResult) {
//				logger.info("Modulo: " + modulo.getNombre());
//				contador++;
//			}
//			System.out.println("Obtner modulos padre 1");
//			lstResult = moduloDao.findByPadre(lstResult.get(0));
//			contador = 0;
//			for (Modulo modulo : lstResult) {
//				logger.info("Modulo: " + modulo.getNombre());
//				contador++;
//			}
//			logger.info("Cantidad modulos"+contador);
//			logger.info("Fin del test obtenerModulosPorPadre");
//		} catch (Exception e) {
//			logger.error("Error JBDC", e);
//		}
//	}
	
//	@Test
//	@Transactional
//	public void testeoGenericDao() {
//		try {
//			System.out.println();
//			logger.info("Inicio del test testeoGenericDao");
//			System.out.println("Obtener modulos");
//			List<Modulo> lstResult = moduloDao.listar();
//			for (Modulo modulo : lstResult) {
//				System.out.println(modulo.getNombre());
//				System.out.println("");
//			}
//			System.out.println("Agregar");
//			Modulo modulo = new Modulo();
//			modulo.setIdModulo((long)5);
//			modulo.setNombre("Agregado");
//			modulo = moduloDao.insertar(modulo);
//			System.out.println("Obtener por id");
//			modulo = moduloDao.encontrarPorId((long)5);
//			System.out.println(modulo.getNombre());
//			System.out.println("Modificar");
//			modulo.setNombre("Agregado modificado");
//			modulo = moduloDao.actualizar(modulo);
//			System.out.println("Eliminar");
//			moduloDao.eliminar(modulo);
//			logger.info("Fin del test testeoGenericDao");
//		} catch (Exception e) {
//			logger.error("Error JBDC", e);
//		}
//	}	
	
//	@Test
//	@Transactional
//	public void deberiaActualizarPersona() {
//		try {
//			System.out.println();
//			logger.info("Inicio del test deberiaActualizarPersona");
//			int idPersona = 1;
//			Persona persona = personaDao.findPersonaById(idPersona);
//			logger.info("Persona a modificar (id=" + idPersona + "): "
//					+ persona);
//			// Actualizamos el nombre y apeMaterno
//			persona.setNombre("Administrador");
//			persona.setApeMaterno("Sistemas");
//			personaDao.updatePersona(persona);
//			// Volvemos a leer el usuario
//			persona = personaDao.findPersonaById(idPersona);
//			// Segun la persona recuperada, deberia ser la misma que el registro
//			// 1
//			assertEquals("Administrador", persona.getNombre());
//			// Imprimimos todo el objeto
//			logger.info("Persona modificada (id=" + idPersona + "): " + persona);
//			logger.info("Fin del test deberiaActualizarPersona");
//		} catch (Exception e) {
//			logger.error("Error JBDC", e);
//		}
//	}

//	@Test
//	@Transactional
//	public void deberiaEliminarPersona() {
//		try {
//			System.out.println();
//			logger.info("Inicio del test deberiaEliminarPersona");
//			// Buscamos eliminar la persona con id = 2
//			int idPersona = 2;
//			Persona persona = personaDao.findPersonaById(idPersona);
//			logger.info("Persona a eliminar (id=" + idPersona + "): " + persona);
//			// Eliminamos la persona recuperada
//			personaDao.deletePersona(persona);
//			persona = personaDao.findPersonaById(idPersona);
//			// Deberia de regresar nulo al buscar la persona 2
//			assertNull(persona);
//			// Imprimimos todo el objeto
//			logger.info("Nuevo listado de personas:");
//			List<Persona> personas = personaDao.findAllPersonas();
//			int contadorPersonas = 0;
//			for (Persona persona2 : personas) {
//				logger.info("Persona: " + persona2);
//				contadorPersonas++;
//			}
//			// Segun el numero de personas recuperadas, deberia ser el mismo de
//			// la tabla
//			assertEquals(contadorPersonas, personaDao.contadorPersonas());
//			logger.info("Fin del test deberiaEliminarPersona");
//			System.out.println();
//		} catch (Exception e) {
//			logger.error("Error JBDC", e);
//		}
//
//	}

}