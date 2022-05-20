package ec.edu.ups.jee.jeeappdocker.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.ppw.ppw59.model.Persona;


@Stateless
public class PersonaDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void  insert(Persona p) {
		em.persist(p);
	}
	
	public void  update(Persona p) {
		em.merge(p);
	}
	
	public Persona read(String cedula) {
		Persona p = em.find(Persona.class, cedula);
		return p;
	}
	
	public void  delete(String cedula) {
		Persona p = em.find(Persona.class, cedula);
		em.remove(p);
	}
	
	public List<Persona> getList(){
		String jpql = "Select p From Persona p";
		
		Query q = em.createQuery(jpql, Persona.class);
		
		return q.getResultList();
	}
	
	public List<Persona> getListNombre(String filtro){
		String jpql = "Select p From Persona p" + " where nombre LIKE ?1";
		
		Query q = em.createQuery(jpql, Persona.class);
		q.setParameter(1,filtro);
		return q.getResultList();
	}
	
	
}
