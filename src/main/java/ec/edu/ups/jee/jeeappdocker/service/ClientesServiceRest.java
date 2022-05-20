package ec.edu.ups.jee.jeeappdocker.service;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ec.edu.ups.jee.jeeappdocker.business.GestionFacturasON;
import ec.edu.ups.ppw.ppw59.model.Persona;



@Path("clientes")
public class ClientesServiceRest {
	
	@Inject
	private GestionFacturasON facOn;
	
	@POST
	@Path("suma")
	public double suma(@QueryParam("a") double a, @QueryParam("b") double b) {
		return a+b;
	}
	
	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Respuesta crearCliente(Persona p) {
		//Instrucciones de la funcionalidad
		Respuesta res = new Respuesta();		
		try {
			facOn.guardarPersona(p);
			res.setCodigo(1);
			res.setMensaje("Ok, guardado satisfactoriamente");			
			return res;
		}catch(Exception E) {
			res.setCodigo(99);
			res.setMensaje("Error al guardar");
			return res;
		}
		
	}
	
	@POST
	@Path("autorizar")
	public String autorizar(String xmlFactura) {
		//instrucciones de autoriuzado
		return null;
	}
		
//	@POST
//	@Path("transferir")
//	public String transferir(String numCuentaOrigen, String CedulaOrigen, double monto, 
//			String numCuentaDestino, String CedulaDestino, String bancoDestino) {
//		//Instrucciones de transferencia entre cuentas
//		return null;
//	}
	
	@GET
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<Persona> getClientes(){
		List<Persona> clientes = facOn.getClientes();
		return clientes;
	}
	
	
}
