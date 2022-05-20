package ec.edu.ups.jee.jeeappdocker.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.jee.jeeappdocker.dao.ProductoDAO;
import ec.edu.ups.ppw.ppw59.model.Producto;



@Stateless
public class GestionProductosON {	
	
//	@Inject
//	private FacturaDAO daoFactura;
	
	@Inject
	private ProductoDAO daoProducto;
	
	public void guardarProducto(Producto pro){		
		Producto p = daoProducto.read(pro.getCodigo());
		if(p==null) {
			daoProducto.insert(pro);
		}else {
			daoProducto.update(pro);
		}
		
	}
	
	public double calcularIVA(double valor) {
		return valor * 0.12;
	}
	
//	public void guardarPersona(Persona per) {
//		Persona p = daoPersona.read(per.getCedula());
//		if(p==null) {
//			daoPersona.insert(per);
//		}else {
//			daoPersona.update(per);
//		}
//		
//	}
//	
	public List<Producto> getProductos(){
		return daoProducto.getList();
	}
//	
	public List<Producto> getProductoPorNombre(String Filtro){
		Filtro = "%" + Filtro + "%";
		return daoProducto.getListNombre(Filtro);
	}
//	
	public Producto getProducto(Integer codigo) {
		Producto p = daoProducto.read(codigo);
		return p;
	}
}
