package ec.edu.ups.jee.jeeappdocker.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.ppw.ppw59.model.DetalleFactura;


@Stateless
public class DetallesDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void  insert(DetalleFactura p) {
		em.persist(p);
		
	}
	
	public void  update(DetalleFactura p) {
		em.merge(p);
	}
	
	public DetalleFactura read(int codigo) {
		DetalleFactura p = em.find(DetalleFactura.class, codigo);
		return p;
	}
	
//	public void  delete(in cedula) {
//		DetalleFactura p = em.find(DetalleFactura.class, cedula);
//		em.remove(p);
//	}
	
	public List<DetalleFactura> getList(){
		String jpql = "Select p From DetalleFactura p";
		
		Query q = em.createQuery(jpql, DetalleFactura.class);
		
		return q.getResultList();
	}
	
}
