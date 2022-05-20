package ec.edu.ups.jee.jeeappdocker.service;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import ec.edu.ups.jee.jeeappdocker.business.GestionFacturasON;
import ec.edu.ups.ppw.ppw59.model.Persona;

@WebService
public class ClientesServiceSOAP {
	@Inject
	private GestionFacturasON facOn;
	
	@WebMethod
	public double suma(double a, double b) {
		return a+b;
	}
	
	@WebMethod
	public Respuesta RespcrearCliente(Persona p) {
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
	
	@WebMethod
	public String autorizar(String xmlFactura) {
		//instrucciones de autoriuzado
		return null;
	}
	
	
	@WebMethod
	public String transferir(String numCuentaOrigen, String CedulaOrigen, double monto, 
			String numCuentaDestino, String CedulaDestino, String bancoDestino) {
		//Instrucciones de transferencia entre cuentas
		return null;
	}
	
}
