package ec.edu.ups.jee.jeeappdocker.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.ppw.ppw59.model.Factura;



@Stateless
public class FacturaDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void  insert(Factura p) {
		em.persist(p);
	}
	
	public void  update(Factura p) {
		em.merge(p);
	}
	
	public Factura read(int numero) {
		Factura p = em.find(Factura.class, numero);
		return p;
	}
	
	public void  delete(String cedula) {
		Factura p = em.find(Factura.class, cedula);
		em.remove(p);
	}
	
	public List<Factura> getList(){
		String jpql = "Select p From Factura p";
		
		Query q = em.createQuery(jpql, Factura.class);
		
		return q.getResultList();
	}
	
}
