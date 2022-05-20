package ec.edu.ups.jee.jeeappdocker.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.ppw.ppw59.model.Producto;



@Stateless
public class ProductoDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void  insert(Producto p) {
		em.persist(p);
	}
	
	public void  update(Producto p) {
		em.merge(p);
	}
	
	public Producto read(Integer codigo) {
		Producto p = em.find(Producto.class, codigo);
		return p;
	}
	
//	public void  delete(String cedula) {
//		Producto p = em.find(Producto.class, cedula);
//		em.remove(p);
//	}
	
	public List<Producto> getList(){
		String jpql = "Select p From Producto p";
		
		Query q = em.createQuery(jpql, Producto.class);
		
		return q.getResultList();
	}
	
	public List<Producto> getListNombre(String filtro){
		String jpql = "Select p From Producto p" + " where nombre LIKE ?1";
		
		Query q = em.createQuery(jpql, Producto.class);
		q.setParameter(1,filtro);
		return q.getResultList();
	}
	
}
