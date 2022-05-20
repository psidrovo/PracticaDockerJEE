package ec.edu.ups.jee.jeeappdocker.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.jee.jeeappdocker.dao.DetallesDAO;
import ec.edu.ups.jee.jeeappdocker.dao.FacturaDAO;
import ec.edu.ups.jee.jeeappdocker.dao.PersonaDAO;
import ec.edu.ups.ppw.ppw59.model.DetalleFactura;
import ec.edu.ups.ppw.ppw59.model.Factura;
import ec.edu.ups.ppw.ppw59.model.Persona;


@Stateless
public class GestionFacturasON {
	@Inject
	private PersonaDAO daoPersona;

	@Inject
	private FacturaDAO daoFactura;

	@Inject
	private DetallesDAO daoDetalle;

	// Detalles----------------------
	
	public void guardarDetalles(DetalleFactura det) {
		DetalleFactura p = daoDetalle.read(det.getCodigo());
		if (p == null) {
			daoDetalle.insert(det);
		} else {
			daoDetalle.update(det);
		}
	}
	
	public List<DetalleFactura> getDetalles(){
		return daoDetalle.getList();
	}

	// ------------------------------
	public void guardarFactura(Factura fac) {
		Factura p = daoFactura.read(fac.getNumero());
		if (p == null) {
			daoFactura.insert(fac);
		}else {
			daoFactura.update(p);
		}
	}

//	public List<Factura> getFacturas(){
//		return daoFactura.getList();
//	}
	
//	public Factura getFacturasPorNumero(int Filtro) {
//		//Filtro = Filtro;
//		return daoFactura.read(Filtro);
//	}
	
	// ------------------------------
	
	public double calcularIVA(double valor) {
		return valor * 0.12;
	}

	public void guardarPersona(Persona per) {
		Persona p = daoPersona.read(per.getCedula());
		if (p == null) {
			daoPersona.insert(per);
		} else {
			daoPersona.update(per);
		}

	}

	public List<Persona> getClientes() {
		return daoPersona.getList();
	}

	public List<Persona> getClientesPorNombre(String Filtro) {
		Filtro = "%" + Filtro + "%";
		return daoPersona.getListNombre(Filtro);
	}

	public Persona getCliente(String cedula) {
		Persona p = daoPersona.read(cedula);
		return p;
	}
}
